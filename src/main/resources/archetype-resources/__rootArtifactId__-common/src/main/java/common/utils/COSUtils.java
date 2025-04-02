#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.common.utils;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.model.GetObjectRequest;
import com.qcloud.cos.model.PutObjectRequest;
import ${groupId}.base.exception.BusinessException;
import ${package}.common.config.TencentCOSConfig;
import jakarta.annotation.PreDestroy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class COSUtils {
    private static final Logger logger = LoggerFactory.getLogger(COSUtils.class);

    private final COSClient cosClient;

    private final TencentCOSConfig tencentCOSConfig;


    @Autowired
    public COSUtils(COSClient cosClient,TencentCOSConfig tencentCOSConfig) {
        this.cosClient = cosClient;
        this.tencentCOSConfig = tencentCOSConfig;
    }

    @PreDestroy
    public void shutdown() {
        try {
            if (cosClient != null) {
                cosClient.shutdown();
                logger.info("COSClient 已成功关闭");
            }
        } catch (Exception e) {
            logger.error("关闭 COSClient 时发生异常", e);
        }
    }

    /**
     * 检查 COSClient 是否可用
     */
    private void ensureClientIsActive() {
        if (cosClient == null) {
            throw new BusinessException("COSClient 未初始化");
        }
        try {
            cosClient.getClientConfig(); // 简单调用以验证客户端是否处于活动状态
        } catch (IllegalStateException e) {
            throw new BusinessException("COSClient 已关闭，无法执行操作", e);
        }
    }

    /**
     * 上传文件到默认存储桶
     *
     * @param file      文件对象
     * @param key       存储路径（如 "user/avatar.jpg"）
     * @param overwrite 是否覆盖已有文件
     * @return 文件访问 URL
     */
    public String upload(File file, String key, boolean overwrite) {
        ensureClientIsActive(); // 添加状态检查
        try {
            // 检查文件是否存在且可读
            if (!file.exists() || !file.canRead()) {
                throw new BusinessException("文件不存在或不可读: " + file.getAbsolutePath());
            }
            // 检查是否允许覆盖
            if (!overwrite && cosClient.doesObjectExist(tencentCOSConfig.getBucketName(), key)) {
                throw new BusinessException("文件已存在且不允许覆盖: " + key);
            }

            // 执行上传
            PutObjectRequest request = new PutObjectRequest(tencentCOSConfig.getBucketName(), key, file);
            cosClient.putObject(request);

            // 生成访问 URL
            String url = generateUrl(key);
            logger.info("文件上传成功: {} -> {}", key, url);
            return url;
        } catch (Exception e) {
            logger.error("文件上传失败: {}", key, e);
            throw new BusinessException("上传失败: " + e.getMessage(), e);
        }
    }

    /**
     * 下载文件
     *
     * @param key      存储路径
     * @param destFile 本地保存路径
     */
    public void download(String key, File destFile) {
        ensureClientIsActive(); // 添加状态检查
        try {
            GetObjectRequest request = new GetObjectRequest(tencentCOSConfig.getBucketName(), key);
            cosClient.getObject(request, destFile);
            logger.info("文件下载成功: {} -> {}", key, destFile.getAbsolutePath());
        } catch (Exception e) {
            logger.error("文件下载失败: {}", key, e);
            throw new BusinessException("下载失败: " + e.getMessage(), e);
        }
    }

    /**
     * 生成文件访问 URL
     */
    public String generateUrl(String key) {
        return String.format("https://%s.cos.%s.myqcloud.com/%s", tencentCOSConfig.getBucketName(), tencentCOSConfig.getRegion(), key);
    }

    /**
     * 删除文件
     */
    public void delete(String key) {
        ensureClientIsActive(); // 添加状态检查
        try {
            cosClient.deleteObject(tencentCOSConfig.getBucketName(), key);
            logger.info("文件删除成功: {}", key);
        } catch (Exception e) {
            logger.error("文件删除失败: {}", key, e);
            throw new BusinessException("删除失败: " + e.getMessage(), e);
        }
    }
}