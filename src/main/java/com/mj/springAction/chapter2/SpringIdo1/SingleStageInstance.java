package com.mj.springAction.chapter2.SpringIdo1;

/**
 * 单例类
 * @author mingjing
 *
 */
public class SingleStageInstance {

	private SingleStageInstance(){
		
	}
	//延迟加载实例
	private static class singleInstanceHolder{
		static SingleStageInstance instance= new SingleStageInstance() ;
	}
	//返回实例
	public static SingleStageInstance getInstance(){
		return singleInstanceHolder.instance ;
	}
}
