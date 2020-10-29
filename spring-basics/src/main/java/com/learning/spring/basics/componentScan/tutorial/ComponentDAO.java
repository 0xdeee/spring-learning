package com.learning.spring.basics.componentScan.tutorial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ComponentDAO {

    @Autowired
    ComponentJDBCConnection jdbcConnection;

    public ComponentDAO() {
	System.out.println("ComponentDAO bean created");
    }

    public ComponentJDBCConnection getJdbcConnection() {
	return this.jdbcConnection;
    }

    public void setJdbcConnection(ComponentJDBCConnection jdbcConnection) {
	this.jdbcConnection = jdbcConnection;
    }

}
