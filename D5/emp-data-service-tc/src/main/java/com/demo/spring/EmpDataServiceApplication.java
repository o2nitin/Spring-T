package com.demo.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class EmpDataServiceApplication extends SpringBootServletInitializer{
	
	@Override
   	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
	// TODO Auto-generated method stub
	return builder.sources(EmpDataServiceApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(EmpDataServiceApplication.class, args);
	}
	
	public ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.description("Rest doc for EMp Servc")
				.license("open")
				.title("Api Doc")
				.build();
	}
	
	@Bean
	public Docket docket() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.any())
				.apis(RequestHandlerSelectors.basePackage("com.demo.spring"))
				.build()
				.apiInfo(apiInfo());
	}
}
