package com.vakt.traders;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class TradersApplication {

	public static void main(String[] args) {
		SpringApplication.run(TradersApplication.class, args);
	}
	
	@Bean
	public RestTemplate getRestTemplate() {
	   return new RestTemplate();
	}
	
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/api/**").allowedMethods("GET", "POST", "PUT", "DELETE").allowedOrigins("*")
                .allowedHeaders("*");
			}
		};
	}

}
