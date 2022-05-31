package com.jdc.assignment.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.springframework.context.support.GenericXmlApplicationContext;

@WebListener
public class SpringConatinerManager implements ServletContextListener {

	
	public static final String SPRING_CONTEXT = "spring.context";
	private GenericXmlApplicationContext springContext;

	@Override
	public void contextInitialized(ServletContextEvent sce) {

		// Start IOC Container test
		System.out.println("Start IOC Contanier");

		/// Create IOC container

		springContext = new GenericXmlApplicationContext("classpath:application.xml");

		// added IOC Container to Application Scope.
		sce.getServletContext().setAttribute(SPRING_CONTEXT, springContext);

	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {

		// Close IOC Container test
		System.out.println("End IOC Contanier");

		if (null != springContext) {
			springContext.close();
		}
	}
}
