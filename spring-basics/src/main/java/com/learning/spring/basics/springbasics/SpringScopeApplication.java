package com.learning.spring.basics.springbasics;

import org.slf4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.learning.spring.basics.springbasics.scope.tutorial.PersonDAO;


@SpringBootApplication
public class SpringScopeApplication {
    // for logging
    private static Logger LOGGER = org.slf4j.LoggerFactory.getLogger(SpringScopeApplication.class);

    public static void main(String[] args) {
	ApplicationContext applicationContext = SpringApplication.run(SpringScopeApplication.class, args);

	/*
	 * the default scope for these will be singleton so both personDAO0 & personDAO1
	 * will be referring to the same bean in IOC container i.e ApplicationContext.
	 * 
	 * CASE 1 - If we change the bean scope to PROTOTYPE then each personDAO will
	 * get unique bean from ApplicationContext. but the dependency bean will be same
	 * becuase it will by default be created as a singleton bean by spring
	 * 
	 * CASE 2 - If we change both the personDAO bean and its dependency
	 * JDBCConnection bean's scope to PROTOTYPE we can see the below log printing
	 * different beans for personDAO but eventhough the dependency bean is marked as
	 * PROTOTYPE the log prints the same bean.
	 * 
	 * ************************** Solution **************************************
	 * 
	 * using scope will work to give out diff beans when they are taken from
	 * applicaitonContext but here we are autowiring the bean of JDBCConnection to 2
	 * diff personDAO. spring will be happy with the first instance it gets hold of
	 * and wire the dependency it doesnt realise that this depenedency bean's scope
	 * is PROTOTYPE.
	 * 
	 * In order to make SPRING realise a bean is to be autowired as PROTOTYPE SCOPE
	 * we have to use PROXY - done at JDBCConnection class ->
	 */
	PersonDAO personDAO0 = applicationContext.getBean(PersonDAO.class);
	PersonDAO personDAO1 = applicationContext.getBean(PersonDAO.class);

	LOGGER.info("{}", personDAO0);
	LOGGER.info("{}", personDAO0.getJdbcConnection());
	LOGGER.info("{}", personDAO1);
	LOGGER.info("{}", personDAO0.getJdbcConnection());
    }

}
