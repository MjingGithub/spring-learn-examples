package com.mj.springAction.design.pattern.singletons;
/**
 * 枚举 Enum
 * @author jing.ming
 *
 */
///我们可以通过EasySingleton.INSTANCE来访问实例，这比调用getInstance()方法简单多了。
///创建枚举默认就是线程安全的，所以不需要担心double checked locking，
///而且还能防止反序列化导致重新创建新的对象。但是还是很少看到有人这样写，可能是因为不太熟悉吧。
public enum SingletonEnum {

	INSTANCE ;
}
