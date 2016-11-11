package com.mj.springAction.chapter4;

public class Volunteer implements Thinker {

	private String thoughts ;
	public void thinkofSomething(String thoughts) {
		this.thoughts = thoughts ;

	}
	public String getThoughts(){
		return  thoughts ;
	}

}
