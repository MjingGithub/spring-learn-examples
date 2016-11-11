package com.mj.springAction;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mj.springAction.chapter4.Magician;
import com.mj.springAction.chapter4.Volunteer;

public class MagicianTest {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-action-config/spring-beans4.xml");
		Volunteer volunteer = (Volunteer)context.getBean("volunteer") ;
		volunteer.thinkofSomething("listen to my heart");
		Magician magician =(Magician)context.getBean("magician") ;
		System.out.println(magician.getThoughts());
	}

}
