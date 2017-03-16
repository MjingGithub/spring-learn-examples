package com.mj.springAction.activeMq;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextLoader;

public class TestBase implements ContextLoader {
	private String[] springXmlList = {"spring-jms-config/spring-config-activeMq.xml"};

	@Override
	public ApplicationContext loadContext(String... locations) throws Exception {
		return new ClassPathXmlApplicationContext(locations);
	}

	@Override
	public String[] processLocations(Class<?> arg0, String... arg1) {
		return springXmlList;
	}

}




