package com.mj.springAction.design.pattern.singletons;
/**
 * 静态内部类 static nested class
 * @author jing.ming
 *
 */
///这种写法仍然使用JVM本身机制保证了线程安全问题；由于 SingletonHolder 是私有的，
///除了 getInstance() 之外没有办法访问它，因此它是懒汉式的；
///同时读取实例的时候不会进行同步，没有性能缺陷；也不依赖 JDK 版本。
///这种单例模式的实现方法无疑是最完美的
public class SingletonNestedClass {

	private static class SingletonHolder{
		private static final SingletonNestedClass INSTANCE = new SingletonNestedClass() ;
	}
	
	private SingletonNestedClass(){}
	
	public static final SingletonNestedClass getInstance(){
		return SingletonHolder.INSTANCE ;
	}
}
