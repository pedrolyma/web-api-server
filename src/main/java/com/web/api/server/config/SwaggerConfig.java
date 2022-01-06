package com.web.api.server.config;

import springfox.documentation.swagger2.annotations.EnableSwagger2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.web.api.server.model.Usuario;

import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;


import static springfox.documentation.builders.PathSelectors.regex;

import java.util.ArrayList;
import java.util.Arrays;

// localhost:8080/swagger-ui.html
@Configuration
//@EnableSwagger2
public class SwaggerConfig {

	@Bean
    public Docket webServiceApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.web.api.server"))
                .paths(regex("/api/v1.*"))
                .build()
                .ignoredParameterTypes(Usuario.class)
                .apiInfo(metaInfo())
                .globalOperationParameters(Arrays.asList(
                		new ParameterBuilder()
                		.name("Authorization")
                		.description("Header para token JWT")
                		.modelRef(new ModelRef("string"))
                		.parameterType("header")
                		.required(false)
                		.build()));
    }

    private ApiInfo metaInfo() {

        ApiInfo apiInfo = new ApiInfo(
                "Agendamento API REST",
                "API REST de Serviços de Agendamento.",
                "1.0",
                "Terms of Service",
                new Contact("Pedro Lima", "https://linkedin.com/in/pedrolyma",
                        "pelyma33@gmail.com"),
                "Apache License Version 2.0",
                "https://www.apache.org/licesen.html", new ArrayList<VendorExtension>()
        );

        return apiInfo;
    }
}
