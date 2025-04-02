#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.web.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;

import java.util.List;

@Configuration
@ConditionalOnMissingBean(name = "springWebProvider")
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Complex Web API")
                        .version("1.0")
                        .description("API documentation for Complex Web application"))
                .servers(List.of(
                        new Server()
                                .url("http://localhost:8083/${parentArtifactId}/v3/api-docs")
                                .description("本地开发环境")
                        ));
    }

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("${artifactId}") // 模块名称
                .packagesToScan("${package}.web.controller") // 确保扫描控制器包
                .build();
    }
}
