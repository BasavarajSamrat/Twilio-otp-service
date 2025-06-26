package com.example.send_otp;


import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {

    private  String SECURITY_SCHEMA_NAME ="BearerAuth";

    @Bean
    public OpenAPI customOpenApi(){
        return new OpenAPI()
                .info(
                         new Info()
                        .title("OTP Service")
                        .description("Send otp to the customer")
                        .version("4.0.1")
                        .contact(
                                new Contact()
                                        .url("https://github.com/BasavarajSamrat")
                                        .email("basavarajsamrat@gmail.com")
                                        .name("Basavaraj Samrat"))
                )
                .externalDocs(
                        new ExternalDocumentation()
                                .description("OTP service through twilio api")
                                .url("https://github.com/BasavarajSamrat")

                )
                .servers(List.of(
                        new Server().url("http://localhost:8080").description("Local Server"),
                        new Server().url("http://localhost:9090").description("ProductionServer"))
                )
                .addSecurityItem(new SecurityRequirement().addList(SECURITY_SCHEMA_NAME))
                         .components(new Components()
                                 .addSecuritySchemes(SECURITY_SCHEMA_NAME,new SecurityScheme()
                                         .name(SECURITY_SCHEMA_NAME)
                                         .type(SecurityScheme.Type.HTTP)
                                         .scheme("bearer")
                                         .bearerFormat("JWT")
                                         .description("Enter the JWT token in format : Bearer <Token>")

                         )

                );

    }
}
