package com.example.pokedex.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Component
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
        .select()
        .apis(RequestHandlerSelectors.basePackage("com.example.pokedex"))
        .paths(PathSelectors.any())
        .build()
        .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
            "Pokedex API",
            "API para consultar a los pokemons",
            "1.0.0",
            "Terms of service",
            "Miguel Sarmiento",
            "License of API",
            "API license URL"
        );
    }
}
