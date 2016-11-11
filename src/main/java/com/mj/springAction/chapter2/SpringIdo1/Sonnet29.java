package com.mj.springAction.chapter2.SpringIdo1;

public class Sonnet29 implements Poem {

	private static String[] poems = {"人生若只如初见，何事秋风悲画扇。"	
	,"等闲变却故人心，却道故人心易变。","骊山语罢清宵半，泪雨霖铃终不怨。","何如薄幸锦衣郎，比翼连枝当日愿。"} ;
	public Sonnet29(){
		
	}
	public void recite() {
		for(int i = 0;i<poems.length;i++){
			System.out.println(poems[i]); 
		}

	}

}
