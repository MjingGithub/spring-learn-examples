package com.mj.springAction;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mj.springAction.chapter2.SpringIdo1.Juggler;
import com.mj.springAction.chapter2.SpringIdo1.JugglerPoem;
import com.mj.springAction.chapter2.SpringIdo1.SingleStageInstance;
import com.mj.springAction.chapter2.SpringIdo1.Sonnet29;

public class TestPerformer2 {

	public static void main(String[] args) {//classpath:spring-action-config/spring-beans.xml
	//	ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-action-config/spring-beans2.xml");

		//JugglerPoem ordinaryJuggler =(JugglerPoem) context.getBean("jukePoem") ;
		Sonnet29 sonnet29= new Sonnet29() ;
		JugglerPoem ordinaryJuggler = new JugglerPoem(15,sonnet29) ;
		ordinaryJuggler.perform();
	//	SingleStageInstance instance = (SingleStageInstance)context.getBean("singleInstance") ;
	

	}

}
