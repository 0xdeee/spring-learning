package com.learning.spring.basics.componentScan.tutorial;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
// @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE) 
// To make the bean as PROTOTYPE scope even when they are autowired to a depenecy we have to use value as PROTOTYPE and proxyMode as TARGET_CLASS
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ComponentJDBCConnection {

    public ComponentJDBCConnection() {
	System.out.println("JDBC Connection");
    }
}
