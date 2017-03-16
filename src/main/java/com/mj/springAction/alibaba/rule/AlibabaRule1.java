package com.mj.springAction.alibaba.rule;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author jing.ming
 *
 */
public class AlibabaRule1 {

	public static void main(String[] args) {
		/**
		 * Arrays.asList方法使用注意:：asList的返回对象是一个Arrays内部类，并没有实现集合的修改方法
		 */
		String[] strArr = new String[]{"a","b"} ;
		List listArr = Arrays.asList(strArr) ;
		listArr.add("c") ;//1,修改,抛出异常java.lang.UnsupportedOperationException
		strArr[0] = "a11" ;  //listArr.get(0)也会相应修改
		

		/**
		 * list转array:array要求带size大小,避免转化异常和null数据
		 */
		List<String> list = new ArrayList<String>() ;
		list.add("mj") ;
		list.add("bt") ;
		String[] str = new String[list.size()] ; //这里要带size大小,避免转化异常和null数据
		str = list.toArray(str) ;
		
		/**
		 * SimpleDateFormat
		 * 是线程不安全的类，一般不要定义为static变量，如果定义为static，必须加锁，或者使用DateUtils工具类。
		 * 如果是JDK8的应用，可以使用Instant代替Date，LocalDateTime代替Calendar，DateTimeFormatter代替Simpledateformatter，
		 * 官方给出的解释：simple beautiful strong immutable thread-safe。
		 */
		final ThreadLocal<DateFormat> df = new ThreadLocal<DateFormat>() {
			@Override
			protected DateFormat initialValue() {
				return new SimpleDateFormat("yyyy-MM-dd");
			}
		};
		
		
		/**
		 * 高并发时，同步调用应该去考量锁的性能损耗。
		 * 能用无锁数据结构，就不要用锁；能锁区块，就不要锁整个方法体；能用对象锁，就不要用类锁。
		 */
		
		/**
		 * 对多个资源、数据库表、对象同时加锁时，需要保持一致的加锁顺序，否则可能会造成死锁。 
		 * 说明：线程一需要对表A、B、C依次全部加锁后才可以进行更新操作，那么线程二的加锁顺序也必须是A、B、C，否则可能出现死锁。
		 */
		
		/**
		 * 并发修改同一记录时，避免更新丢失，需要加锁。要么在应用层加锁，要么在缓存加锁，
		 * 要么在数据库层使用乐观锁，使用version作为更新依据。
		 * 说明：如果每次访问冲突概率小于20%，推荐使用乐观锁，否则使用悲观锁。乐观锁的重试次数不得小于3次。
		 */
		
		/**
		 * **********************
		 * 乐观锁的实现方式
		 * **********************
		 * 1.增加一个version版本字段
		 * UPDATE T_IRS_RESOURCE
		 * set version = version + 1
		 * where resource_id = ?
		 * and version = ?
		 * 
		 * 2.为数据表增加一个时间戳字段，然后通过比较时间戳检查该数据是否被其他事务修改过。
		 * 3.三是检查对应的字段的值有没有变化。
		 * ************
		 * 悲观锁:
		 * ************
		 * 很简单，在SQLMAP中的查询语句中增加 for update即可。不过要注意的是，如果查询语句中有表关联，
		 * 只是用for update会锁住所有表的相关记录，建议使用for update of t.id。
		 * 如果你不想让你的事务等待其他事务的锁，可以在for update 后加上 nowait，这样当遇上冲突时数据库会抛出异常。
		 */
		
		
		
		/**
		 * 多线程并行处理定时任务时，Timer运行多个TimeTask时，只要其中之一没有捕获抛出的异常，其它任务便会自动终止运行，
		 * 使用ScheduledExecutorService则没有这个问题。
		 * 
		 */
		
		/**
		 * 使用CountDownLatch进行异步转同步操作，每个线程退出前必须调用countDown方法，线程执行代码注意catch异常，
		 * 确保countDown方法可以执行，避免主线程无法执行至await方法，直到超时才返回结果。 
		 * 说明：注意，子线程抛出异常堆栈，不能在主线程try-catch到。
		 * http://bastengao.com/blog/2014/03/from-asycn-to-sync-in-java.html
		 */
	}

}
