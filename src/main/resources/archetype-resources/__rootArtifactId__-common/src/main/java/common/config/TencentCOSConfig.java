#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.common.config;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.region.Region;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
public class TencentCOSConfig {

    @Value("${symbol_dollar}{tentent.cos.secretId}")
    private String secretId;

    @Value("${symbol_dollar}{tentent.cos.secretKey}")
    private String secretKey;

    @Value("${symbol_dollar}{tentent.cos.region}")
    private String region;

    @Value("${symbol_dollar}{tentent.cos.bucketName}")
    private String bucketName;

    @Bean
    public COSClient cosClient() {
        COSCredentials cred = new BasicCOSCredentials(secretId, secretKey);
        ClientConfig clientConfig = new ClientConfig(new Region(region));
        return new COSClient(cred, clientConfig);
    }

}
