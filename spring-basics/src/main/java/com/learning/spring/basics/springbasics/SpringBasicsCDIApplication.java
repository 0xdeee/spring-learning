package com.learning.spring.basics.springbasics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.learning.spring.basics.CDI.basics.BinarySearchImpl1;

@SpringBootApplication
@ComponentScan("com.learning.spring.basics.CDI.basics")
public class SpringBasicsCDIApplication {

    public static void main(String[] args) {

	ApplicationContext applicationContext = SpringApplication.run(SpringBasicsCDIApplication.class, args);
	BinarySearchImpl1 binarySearch = applicationContext.getBean(BinarySearchImpl1.class);
	BinarySearchImpl1 binarySearch1 = applicationContext.getBean(BinarySearchImpl1.class);

	System.out.println(binarySearch);
	System.out.println(binarySearch1);

	int result = binarySearch.binarySearch(new int[]{12, 4, 2, 5, 10}, 5);
	System.out.println(result);
    }

}
