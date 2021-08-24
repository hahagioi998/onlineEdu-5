package cn.lizhi.serviceBase.config;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 对Swagger进行测试
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket webApiConfig() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("webApi") // 组名
                .apiInfo(webApiInfo())
                .select()
//                .paths(Predicates.not(PathSelectors.regex("/admin/.*"))) // 排除admin
                .paths(Predicates.not(PathSelectors.regex("/error.*"))) //  排除error
                .build();
    }

    private ApiInfo webApiInfo() {
        return new ApiInfoBuilder()
                .title("网站-课程中心API文档") // Api 标题
                .description("本文档描述了课程中心微服务接口定义") // 标题下的description
                .version("1.0") //  版本信息
                .contact(new Contact("liz", "http://chemlez.cn",
                        "liz_1106@163.com")) // 联系信息
                .build();
    }
}