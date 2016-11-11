package com.mj.springAction;

import org.springframework.beans.factory.annotation.Required;

public class OrdinaryMen implements Humans {

	private String name  ;
	
	public String getName() {
		return name;
	}

	@Required
	public void setName(String name) {
		this.name = name;
	}

	public void life() {
		System.out.println(this.name+" `s life is hard.") ;

	}

	public void work() {
		System.out.println(this.name+" `s work is tired.") ;

	}

}
