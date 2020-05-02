package com.hcl.flagpicker.swagger;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {                                    
    @Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          //.apis(RequestHandlerSelectors.any())              
          .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
          .paths(PathSelectors.any())
          .build()
          .apiInfo(apiInfo());                                           
    }
    
    private ApiInfo apiInfo() {
        return new ApiInfo(
          "Flag Picker API", 
          "The Flag Picker API can be used to pick the flag of the nation. The API provides different URI’s "
          + "for providing flag based on country or continent passed.The API includes JUNIT scenarios to perform unit testing, various"
          + " levels of logging", 
          "1.2", 
          " ", 
          new Contact("Dinesh Polepalle", "", ""), 
          " ", " ", Collections.emptyList());
    }
}