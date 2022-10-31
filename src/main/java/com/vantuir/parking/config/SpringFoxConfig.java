package com.vantuir.parking.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
public class SpringFoxConfig {
    @Bean
    public Docket getDocket() {

        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                //.apis(RequestHandlerSelectors.basePackage("com.vantuir.parking"))
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any()) //!novo

                .build()
                .apiInfo(metaData());

    }


    private ApiInfo metaData() {
        return new ApiInfoBuilder()
                .title("Parking rest API")
                .description("Spring Boot REST API for Parking")
                .version("1.0.0")
                .license("apache Licence Version 2.0")
                .licenseUrl("http://www.apache.org/licences/LICENSE-2.0")
                .build();

    }

}
