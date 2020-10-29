package com.learning.spring.basics.springbasics.scope.tutorial;

import org.slf4j.Logger;

public class XmlJDBCConnection {
    private Logger LOGGER = org.slf4j.LoggerFactory.getLogger(this.getClass());

    public XmlJDBCConnection() {
	this.LOGGER.info("JDBC Connection");
    }
}
