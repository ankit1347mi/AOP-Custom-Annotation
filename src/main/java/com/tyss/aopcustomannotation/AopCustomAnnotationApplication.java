package com.tyss.aopcustomannotation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableAspectJAutoProxy
@EnableSwagger2
@EnableWebMvc
public class AopCustomAnnotationApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopCustomAnnotationApplication.class, args);
	}

}
