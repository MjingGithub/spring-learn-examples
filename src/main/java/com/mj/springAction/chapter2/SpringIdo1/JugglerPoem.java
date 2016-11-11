package com.mj.springAction.chapter2.SpringIdo1;

public class JugglerPoem extends Juggler{

	private Poem poem ;
	public JugglerPoem(Poem poem ){
		super() ;
		this.poem = poem ;
	}
	public JugglerPoem(int beanBags,Poem poem){
		super(beanBags) ;
		this.poem = poem ;
	}
	public void perform(){
		super.perform();
		System.out.println("While reciting ...");
		poem.recite();
	}
	
	public void beforePerform(){
		System.out.println("Turn on the lights.");
	}
	
	public void afterPerform(){
		System.out.println("Turn off the lights.");
	}
}
