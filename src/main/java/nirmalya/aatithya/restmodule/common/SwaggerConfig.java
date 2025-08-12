package nirmalya.aatithya.restmodule.common;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("nirmalya.aatithya.restmodule"))
                .paths(PathSelectors.regex("/api/.*"))
                .build().apiInfo(metaData());
    }
    
	private ApiInfo metaData() {
        return new ApiInfoBuilder()
                .title("HRMS Swagger Configuration")
                .description("HRMS")
//                .contact(new Contact("Nirmalya Labs Team", "http://nirmalyalabs.com", "jineshbehera06@gmail.com"))
                .license("HRMS").licenseUrl("https://news7.nerp.in/").version("1.0.0")
                .build();
    }

}
