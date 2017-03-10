package com.mj.springAction.design.pattern.singletons;
/**
 * 懒汉式,线程不安全
 * @author jing.ming
 *
 */
/////这段代码简单明了，而且使用了懒加载模式，但是却存在致命的问题。
////当有多个线程并行调用 getInstance() 的时候，就会创建多个实例。
////也就是说在多线程下不能正常工作。
public class SingletonLazyNotSafe {

	private static SingletonLazyNotSafe instance ;
	
	private SingletonLazyNotSafe(){}
	
	public static SingletonLazyNotSafe getInstance(){
		if(instance==null){
			instance = new SingletonLazyNotSafe() ;
		}
		return instance ;
	}
}
