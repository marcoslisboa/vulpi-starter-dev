package com.vulpi.starterdev.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

    @Bean
    public Docket swagger() {
        return new Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.vulpi.starterdev.controller.rest"))
            .paths(PathSelectors.any())
            .build()
            .apiInfo(
                new ApiInfoBuilder()
                    .version("1.0.0")
                    .title("Vulpi Starter Dev API")
                    .description("Documentation API v1.0")
                    .contact(new Contact("Development Team", "", "contact@vulpi.com.br"))
                    .build()
            );
    }
}
