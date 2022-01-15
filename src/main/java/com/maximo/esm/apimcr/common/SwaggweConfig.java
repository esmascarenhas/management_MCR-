package com.maximo.esm.apimcr.common;

import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import java.util.ArrayList;

import static springfox.documentation.builders.PathSelectors.regex;


@EnableSwagger2
@Configuration
public class SwaggweConfig {

    @Bean
    public Docket apimcr(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.maximo.esm.apimcr"))
                .paths(regex("/api.*"))
                .build()
                .apiInfo(metaInfo());
    }

    private ApiInfo metaInfo() {
        ApiInfo apiInfo = new ApiInfo(
                "MCR API REST",
                "API REST de controle de Reservas e Encomendas do MCR",
                "1.0",
                "Terms of Service",
                new Contact("Emerson Mascarenhas","https://www.mcr.com.br","esmascarenhas12@gmail.com"),
                "Apache License Version 2.0",
                "https://www.apache.org/license.html",new ArrayList<VendorExtension>());
        return apiInfo;
    }
}
