package com.learning.spring.basics.springbasics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

import com.learning.spring.basics.springbasics.properties.demo.SomeExternalService;

@SpringBootApplication
@ComponentScan("com.learning.spring.basics.springbasics.properties.demo")
// step 1 - add the path of propery file from which we want to take value from.
@PropertySource("classpath:app.properties")
public class SpringPropertiesApplication {

    public static void main(String[] args) {

	ApplicationContext applicationContext = SpringApplication.run(SpringPropertiesApplication.class, args);
	SomeExternalService service = applicationContext.getBean(SomeExternalService.class);
	System.out.println(service.getUrl());
    }

}
