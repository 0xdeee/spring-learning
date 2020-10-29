package com.learning.demo;

import org.slf4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.learning.spring.basics.springbasics.scope.tutorial.XmlPersonDAO;

public class SpringWithXmlApplication {

    private static Logger LOGGER = org.slf4j.LoggerFactory.getLogger(SpringWithXmlApplication.class);

    public static void main(String[] args) {

	try (ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
		"applicationContext.xml")) {
	    XmlPersonDAO XMLPersonDAO0 = applicationContext.getBean(XmlPersonDAO.class);
	    XmlPersonDAO XMLPersonDAO1 = applicationContext.getBean(XmlPersonDAO.class);
	    LOGGER.info("Beans Loaded are ---> {}", (Object) applicationContext.getBeanDefinitionNames());
	    // Beans Loaded are ---> [xmlJdbcConnection, xmlPersonDAO]

	    // after addding component scan
	    /*
	     * 08:13:20.286 [main] INFO com.learning.demo.SpringWithXmlApplication - Beans
	     * Loaded are ---> [binarySearchImpl1, bubbleSortAlgorithm, quickSortAlgorithm,
	     * springBasicsCDIApplication, org.springframework.context.annotation.
	     * internalConfigurationAnnotationProcessor,
	     * org.springframework.context.annotation.internalAutowiredAnnotationProcessor,
	     * org.springframework.context.annotation.internalCommonAnnotationProcessor,
	     * org.springframework.context.event.internalEventListenerProcessor,
	     * org.springframework.context.event.internalEventListenerFactory,
	     * xmlJdbcConnection, xmlPersonDAO,
	     * org.springframework.boot.autoconfigure.AutoConfigurationPackages,
	     * org.springframework.boot.autoconfigure.context.
	     * PropertyPlaceholderAutoConfiguration, propertySourcesPlaceholderConfigurer,
	     * org.springframework.boot.autoconfigure.aop.
	     * AopAutoConfiguration$ClassProxyingConfiguration,
	     * org.springframework.boot.autoconfigure.aop.AopAutoConfiguration,
	     * org.springframework.boot.autoconfigure.availability.
	     * ApplicationAvailabilityAutoConfiguration, applicationAvailability,
	     * org.springframework.boot.autoconfigure.context.
	     * ConfigurationPropertiesAutoConfiguration,
	     * org.springframework.boot.context.properties.
	     * ConfigurationPropertiesBindingPostProcessor,
	     * org.springframework.boot.context.
	     * internalConfigurationPropertiesBinderFactory,
	     * org.springframework.boot.context.internalConfigurationPropertiesBinder,
	     * org.springframework.boot.context.properties.BoundConfigurationProperties,
	     * org.springframework.boot.context.properties.ConfigurationBeanFactoryMetadata,
	     * org.springframework.boot.autoconfigure.context.LifecycleAutoConfiguration,
	     * lifecycleProcessor,
	     * spring.lifecycle-org.springframework.boot.autoconfigure.context.
	     * LifecycleProperties,
	     * org.springframework.boot.autoconfigure.info.ProjectInfoAutoConfiguration,
	     * spring.info-org.springframework.boot.autoconfigure.info.
	     * ProjectInfoProperties,
	     * org.springframework.boot.autoconfigure.task.TaskExecutionAutoConfiguration,
	     * taskExecutorBuilder, applicationTaskExecutor,
	     * spring.task.execution-org.springframework.boot.autoconfigure.task.
	     * TaskExecutionProperties,
	     * org.springframework.boot.autoconfigure.task.TaskSchedulingAutoConfiguration,
	     * taskSchedulerBuilder,
	     * spring.task.scheduling-org.springframework.boot.autoconfigure.task.
	     * TaskSchedulingProperties,
	     * org.springframework.aop.config.internalAutoProxyCreator]
	     */


	    LOGGER.info("{}", XMLPersonDAO0);
	    LOGGER.info("{}", XMLPersonDAO0.getXmlJdbcConnection());
	    LOGGER.info("{}", XMLPersonDAO1);
	    LOGGER.info("{}", XMLPersonDAO0.getXmlJdbcConnection());
	} catch (BeansException e) {
	    e.printStackTrace();
	}
    }

}
