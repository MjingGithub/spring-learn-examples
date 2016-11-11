package com.mj.springAction.chapter4;

public class Magician implements MindReader {
	
	private String thoughts ;

	public void interceptThoughts(String thoughts) {
		System.out.println("Intercept volunteer`s thoughts.");
		this.thoughts = thoughts ;

	}

	public String getThoughts() {
		return thoughts;
	}

}
