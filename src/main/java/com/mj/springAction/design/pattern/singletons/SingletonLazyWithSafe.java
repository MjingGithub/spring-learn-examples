package com.mj.springAction.design.pattern.singletons;
/**
 * 懒汉式,线程安全
 * @author jing.ming
 *
 */
////虽然做到了线程安全，并且解决了多实例的问题，但是它并不高效。
////因为在任何时候只能有一个线程调用 getInstance() 方法。
////但是同步操作只需要在第一次调用时才被需要，即第一次创建单例实例对象时。这就引出了双重检验锁。
public class SingletonLazyWithSafe {

	private static SingletonLazyWithSafe instance ;
	
	private SingletonLazyWithSafe(){}
	
	public static synchronized SingletonLazyWithSafe getInstance(){
		if(instance==null){
			instance = new SingletonLazyWithSafe() ;
		}
		return instance ;
	}
}
