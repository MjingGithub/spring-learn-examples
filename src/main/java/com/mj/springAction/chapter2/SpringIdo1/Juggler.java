package com.mj.springAction.chapter2.SpringIdo1;
/**
 * 杂技师
 * @author mingjing
 *
 */
public class Juggler implements Performer {

	private int beanBags = 3 ;
	public Juggler(){
		
	}
	public Juggler(int beanBags){
		this.beanBags = beanBags ;
	}
	
	public void perform() {
		System.out.println("Juggling "+this.beanBags+" beanBags.");
	}

}
