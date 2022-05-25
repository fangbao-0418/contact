package com.eiot6;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@RestController
@SpringBootApplication
@EnableSwagger2
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
    // 跨域
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**");
//						.allowedMethods("PUT", "DELETE")
//						.allowedHeaders("header1", "header2", "header3")
//						.exposedHeaders("header1", "header2")
//						.allowCredentials(false).maxAge(3600)
                        // .allowedOrigins("http://localhost:8080");
            }
        };
    }

    @Bean
    public Docket createRestApi() {
           return new Docket(DocumentationType.SWAGGER_2)
                   .apiInfo(apiInfo())
                   .select()
                    //    .apis(RequestHandlerSelectors.basePackage("com.blog.tutorial.controller"))
                   .paths(PathSelectors.any())
                   .build();
       }
       private ApiInfo apiInfo() {
           return new ApiInfoBuilder()
                   .title("swagger-bootstrap-ui RESTful APIs")
                   .description("swagger-bootstrap-ui")
                //    .termsOfServiceUrl("http://localhost:7001/")
                //    .license("http://localhost:7001/")
                //    .licenseUrl("http://localhost:7001/")
                //    .contact("developer@mail.com")
                   .version("1.0")
                   .build();
       }

}
