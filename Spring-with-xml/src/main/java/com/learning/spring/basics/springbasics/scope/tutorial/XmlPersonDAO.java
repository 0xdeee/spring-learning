package com.learning.spring.basics.springbasics.scope.tutorial;

import org.slf4j.Logger;

public class XmlPersonDAO {

    private Logger LOGGER = org.slf4j.LoggerFactory.getLogger(this.getClass());

    XmlJDBCConnection xmlJdbcConnection;

    public XmlPersonDAO() {
	this.LOGGER.info("PersonDAO bean created");
    }

    public XmlJDBCConnection getXmlJdbcConnection() {
	return this.xmlJdbcConnection;
    }

    public void setXmlJdbcConnection(XmlJDBCConnection xmlJdbcConnection) {
	this.xmlJdbcConnection = xmlJdbcConnection;
    }

}
