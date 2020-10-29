package com.learning.spring.basics.springbasics;

import org.slf4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.learning.spring.basics.componentScan.tutorial.ComponentDAO;


@SpringBootApplication
/*
 * Here the @SpringBootApplicaiton annotation
 * inclues @ComponentScan("com.learning.spring.basics.springbasics") so if we
 * place our component classes inside this package alone then this code will
 * work fine.
 * 
 * But in this example we have placed the component classes i.e
 * ComponentDAO.class in another package so by default spring wont seatch that
 * package and gives a unable to create bean exception explaining no suitable
 * class was found.
 * 
 * In order to make spring scan for dependencies even in other packages we have
 * to specify those packages explicitly in -
 * 
 * @ComponentScan("package of the component classes")
 */
@ComponentScan("com.learning.spring.basics.componentScan.tutorial")
public class SpringComponentScanApplication {
    // for logging
    private static Logger LOGGER = org.slf4j.LoggerFactory.getLogger(SpringComponentScanApplication.class);

    public static void main(String[] args) {
	ApplicationContext applicationContext = SpringApplication.run(SpringComponentScanApplication.class, args);

	ComponentDAO componentDAO = applicationContext.getBean(ComponentDAO.class);

	LOGGER.info("{}", componentDAO);
    }

}
