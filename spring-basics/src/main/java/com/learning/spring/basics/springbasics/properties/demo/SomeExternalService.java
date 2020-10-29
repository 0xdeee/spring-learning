package com.learning.spring.basics.springbasics.properties.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SomeExternalService {

    // step 2
    // this application will take value from app.properties as declared in
    // configuraion class/starter class
    // @value tells specifically which properties value to take
    @Value("${external.service.url}")
    private String url;

    public String getUrl() {
	return this.url;
    }

    public void setUrl(String url) {
	this.url = url;
    }

}
