package com.web.api.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSpringDataWebSupport  // para spring pegar parametros e passar ao spring data
@EnableCaching
@EnableSwagger2
public class WebApiServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebApiServerApplication.class, args);
	}
	
	// na url = localhost:8080/clientes?page=0&size=10&sort=id,asc
	// git alura 1843-spring-parte3-testes-deploy

}
