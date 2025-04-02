#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.service.listener;


import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.exception.ExcelDataConvertException;
import com.alibaba.fastjson2.JSON;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.function.Consumer;

@Slf4j
public class ExcelDataListener<T> extends AnalysisEventListener<T> {

    private static final Integer BATCH_SIZE = 1000;

    private Integer sheetNo;

    private Executor executor;

    private List<T> dataList = new ArrayList<>();

    private Consumer<List<T>> dataHandler;

    public ExcelDataListener(Integer sheetNo, Executor executor, Consumer<List<T>> dataHandler) {
        this.sheetNo = sheetNo;
        this.executor = executor;
        this.dataHandler = dataHandler;
    }

    @Override
    public void invoke(T data, AnalysisContext analysisContext) {
        log.info("解析到一条数据：{}", JSON.toJSONString(data));
        dataList.add(data);
        if (dataList.size() >= BATCH_SIZE) {
            List<T> batchData = new ArrayList<>(dataList);
            CompletableFuture.runAsync(() -> {
                log.info("批量处理数据，数据量：{}", batchData.size());
                dataHandler.accept(batchData); // 使用 dataHandler 处理数据
            }, executor);
            dataList.clear();
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        log.info("已解析完所有数据!");
        if (!dataList.isEmpty()) {
            List<T> remainingData = new ArrayList<>(dataList);
            CompletableFuture.runAsync(() -> {
                log.info("处理剩余数据，数据量：{}", remainingData.size());
                dataHandler.accept(remainingData); // 使用 dataHandler 处理数据
            }, executor);
            dataList.clear();
        }
    }

    @Override
    public void onException(Exception exception, AnalysisContext context) throws Exception {
        if (exception instanceof ExcelDataConvertException) {
            ExcelDataConvertException convertException = (ExcelDataConvertException) exception;
            Integer row = convertException.getRowIndex();
            Integer column = convertException.getColumnIndex();
            log.error("sheetNo：{}，第{}行，第{}列数据转换失败，异常信息：{}", sheetNo, row, column, exception.getMessage());
        } else if (exception instanceof com.alibaba.excel.exception.ExcelCommonException) {
            log.error("Excel格式转换异常，请尝试指定'excelType'：{}", exception.getMessage(), exception);
        } else {
            log.error("导入其他异常信息：{}", exception.getMessage(), exception);
        }
    }

    // 获取解析后的数据（可选）
    public List<T> getDataList() {
        return dataList;
    }
}
