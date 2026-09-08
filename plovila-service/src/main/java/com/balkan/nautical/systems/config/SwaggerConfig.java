package com.balkan.nautical.systems.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;







@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI appApiDoc() {
        OpenAPI apiDoc = new OpenAPI();

        return apiDoc.info(
            new Info()
                .title("Balkan Nautical API")
                .description("API for managing vessels and nautical equipment and lot of other services")
                .version("1.0.0")
                .license(
                    new License()
                        .name("Copyright by nautika-oglasi d.o.o")
                        .url("### enter url here later ###")
                )
        );
    }
}