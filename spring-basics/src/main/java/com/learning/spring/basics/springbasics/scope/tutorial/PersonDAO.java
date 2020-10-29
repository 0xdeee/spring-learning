package com.learning.spring.basics.springbasics.scope.tutorial;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class PersonDAO {

    private Logger LOGGER = org.slf4j.LoggerFactory.getLogger(this.getClass());

    @Autowired
    JDBCConnection jdbcConnection;

    @PostConstruct
    public void postConstruct() {
	this.LOGGER.info("Bean Created");
    }

    @PreDestroy
    public void preDestroy() {
	this.LOGGER.info("Bean Destroyed-----------------------------------------------");
    }

    public PersonDAO() {
	System.out.println("PersonDAO bean created");
    }

    public JDBCConnection getJdbcConnection() {
	return this.jdbcConnection;
    }

    public void setJdbcConnection(JDBCConnection jdbcConnection) {
	this.jdbcConnection = jdbcConnection;
    }

}
