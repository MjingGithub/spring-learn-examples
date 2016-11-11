package com.mj.springAction;

public class Companys {
    private Humans human ;
	public Companys(Humans human){
		this.human = human ;
	}
	public void companyEarn(){
		human.work();
		//human.life();
	}

}
