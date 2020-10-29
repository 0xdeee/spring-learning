package com.learning.spring.basics.springbasics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.learning.spring.basics.springbasics.basics.tutorial.BinarySearchImpl;

@SpringBootApplication
@ComponentScan("com.learning.spring.basics.springbasics.basics.tutorial")
public class SpringBasicsApplication {

    // for spring to manage depenedencies we need to tell spring the following
    // What are the beans that spring needs to manage ? - using @Component
    // annotation.
    // What are the depenedencies of a bean ? - using @Autowired annotation
    // Where to search for beans ? - uisng @ComponentScan(path)
    // since we have placed all the classes in this single package we dont have to
    // tell sprint the path
    // because @SpringBootApplication included @ComponentScan for the package it
    // presents internally.

    public static void main(String[] args) {
	/*
	 * BinarySearchImpl binarySearch = new BinarySearchImpl( new
	 * BubbleSortAlgorithm()); int result = binarySearch.binarySearch(new int[]{12,
	 * 4, 2, 5, 10}, 5); System.out.println(result);
	 */
	// SpringApplication.run(SpringBasicsApplication.class, args);

	// all the beans that are automatically created by SPRING will be stored in
	// ApplicationContext...
	// it is a IOC containder.
	// SpringApplication.run() returns the instance of current ApplciaitonContext.
	ApplicationContext applicationContext = SpringApplication.run(SpringBasicsApplication.class, args);
	// since all the beans that spring has created are in ApplicationContext we are
	// using the instance of ApplicationContext and accessing the getBean() to get
	// the bean/obj of the class we need
	BinarySearchImpl binarySearch = applicationContext.getBean(BinarySearchImpl.class);
	BinarySearchImpl binarySearch1 = applicationContext.getBean(BinarySearchImpl.class);

	// demonstrating singleton bean & prototype bean creation
	System.out.println(binarySearch);
	System.out.println(binarySearch1);

	// QuickSortAlgorithm qs = applicationContext.getBean(QuickSortAlgorithm.class);
	// System.out.println(qs);
	// here since "new" keyword is not used this appln is completely loosely
	// coupled.
	int result = binarySearch.binarySearch(new int[]{12, 4, 2, 5, 10}, 5);
	System.out.println(result);
    }

}
