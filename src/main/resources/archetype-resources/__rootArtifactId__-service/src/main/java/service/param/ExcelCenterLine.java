#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.service.param;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * 运输分拨线路信息表
 * @TableName dim_mdm_tms_center_line
 */
@Data
public class ExcelCenterLine {

    @ExcelProperty("线路名称")
    private String lineName;
    @ExcelProperty("分拨距离")
    private Integer km;
    @ExcelProperty("始发分拨名称")
    private String origCenterName;

    @ExcelProperty("始发分拨编号")
    private String origCenterCode;

    @ExcelProperty("目的分拨名称")
    private String destCenterName;
    @ExcelProperty("目的分拨编号")
    private String destCenterCode;






}