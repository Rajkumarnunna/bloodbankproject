package com.example.bloodbank.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI bloodBankOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Blood Bank API")
                        .description("Blood Bank Management System API")
                        .version("1.0"));
    }
}