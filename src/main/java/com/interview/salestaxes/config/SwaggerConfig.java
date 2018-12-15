package com.interview.salestaxes.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select().apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .pathMapping("/")
                .apiInfo(metadata());
    }

    private ApiInfo metadata(){
        Contact contact = new Contact("Dorjan Dika", "https://github.com/dordika/sales-taxes", "dorjan.dika@gmail.com");

        //ApiInfo(String title, String description, String version, String termsOfServiceUrl, String contactName, String license, String licenseUrl) {
        return new ApiInfo(
                "Sales Taxes",
                "Code Challenge",
                "1.0",
                "https://github.com/dordika/sales-taxes",
                contact,
                "licence dorjan",
                "https://github.com/dordika/sales-taxes",
                new ArrayList<>());
    }

}
