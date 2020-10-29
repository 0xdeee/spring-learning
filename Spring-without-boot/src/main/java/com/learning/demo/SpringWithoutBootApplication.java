package com.learning.demo;

import org.springframework.beans.BeansException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.learning.spring.basics.springbasics.basics.tutorial.BinarySearchImpl;

// here were are not using spring boot so the huge amount of autoconfiguration done by spring boot should be done manually
// @Configuration specifies the starting point of the application
@Configuration
// w/o BOOT we have to manually add component scan path for spring to identify the component classes.
@ComponentScan("com.learning.spring.basics.springbasics.basics.tutorial")
public class SpringWithoutBootApplication {

    public static void main(String[] args) {
	// W/O SpingBoot we cannot use SpringBootApplication.run(class, args) to get the
	// intance of application context.
	// we can take that using AnnotationConfigApplicationContext class.
	try (AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
		SpringWithoutBootApplication.class)) {
	    BinarySearchImpl binarySearch = applicationContext.getBean(BinarySearchImpl.class);
	    BinarySearchImpl binarySearch1 = applicationContext.getBean(BinarySearchImpl.class);

	    System.out.println(binarySearch);
	    System.out.println(binarySearch1);

	    int result = binarySearch.binarySearch(new int[] { 12, 4, 2, 5, 10 }, 5);
	    System.out.println(result);
	    // applicationContext.close(); - we can use try-with-resources to use the
	    // feature of auto closing resources.
	} catch (BeansException e) {
	    e.printStackTrace();
	}
    }

}
