package com.mj.springAction;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CompanyMainTest {

	public static void main(String[] args) {
		//ApplicationContext context =new FileSystemXmlApplicationContext("c:/foo.xml") ;
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-action-config/spring-beans.xml");
		Companys company = (Companys)context.getBean("companys") ;
		company.companyEarn();
	}

}
