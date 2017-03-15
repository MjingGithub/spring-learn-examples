package com.mj.springAction.alibaba.rule;

import java.util.Comparator;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程池的使用
 * @author jing.ming
 *
 */
//1.corePoolSize（线程池的基本大小）：当提交一个任务到线程池时，线程池会创建一个线程来执行任务，即使其他空闲的基本线程能够执行新任务也会创建线程，
//  等到需要执行的任务数大于线程池基本大小时就不再创建。如果调用了线程池的prestartAllCoreThreads方法，线程池会提前创建并启动所有基本线程。
//2.runnableTaskQueue（任务队列）：用于保存等待执行的任务的阻塞队列。 可以选择以下几个阻塞队列。
//  *ArrayBlockingQueue：是一个基于数组结构的有界阻塞队列，此队列按 FIFO（先进先出）原则对元素进行排序。
//  *LinkedBlockingQueue：一个基于链表结构的阻塞队列，此队列按FIFO （先进先出） 排序元素，吞吐量通常要高于ArrayBlockingQueue。静态工厂方法Executors.newFixedThreadPool()使用了这个队列。
//  *SynchronousQueue：一个不存储元素的阻塞队列。每个插入操作必须等到另一个线程调用移除操作，否则插入操作一直处于阻塞状态，吞吐量通常要高于LinkedBlockingQueue，静态工厂方法Executors.newCachedThreadPool使用了这个队列。
//  *PriorityBlockingQueue：一个具有优先级的无限阻塞队列。
//3.maximumPoolSize（线程池最大大小）：线程池允许创建的最大线程数。如果队列满了，并且已创建的线程数小于最大线程数，则线程池会再创建新的线程执行任务。
//  值得注意的是如果使用了无界的任务队列这个参数就没什么效果。
//4.ThreadFactory：用于设置创建线程的工厂，可以通过线程工厂给每个创建出来的线程设置更有意义的名字。
//5.RejectedExecutionHandler（饱和策略）：当队列和线程池都满了，说明线程池处于饱和状态，那么必须采取一种策略处理提交的新任务。
//  这个策略默认情况下是AbortPolicy，表示无法处理新任务时抛出异常。以下是JDK1.5提供的四种策略。
//  *AbortPolicy：直接抛出异常。
//  *CallerRunsPolicy：只用调用者所在线程来运行任务。
//  *DiscardOldestPolicy：丢弃队列里最近的一个任务，并执行当前任务。
//  *DiscardPolicy：不处理，丢弃掉。
//  *当然也可以根据应用场景需要来实现RejectedExecutionHandler接口自定义策略。如记录日志或持久化不能处理的任务。
//6.keepAliveTime（线程活动保持时间）：线程池的工作线程空闲后，保持存活的时间。所以如果任务很多，并且每个任务执行的时间比较短，可以调大这个时间，提高线程的利用率。
//7.TimeUnit（线程活动保持时间的单位）：可选的单位有天（DAYS），小时（HOURS），分钟（MINUTES），毫秒(MILLISECONDS)，微秒(MICROSECONDS, 千分之一毫秒)和毫微秒(NANOSECONDS, 千分之一微秒)。
public class ThreadPoolUnity {
	
	public static void main(String[] args) {
		PriorityBlockingQueue workQueue = new PriorityBlockingQueue<>(2, new Comparator(){

			@Override
			public int compare(Object o1, Object o2) {
				// TODO Auto-generated method stub
				return 0;
			}
			
		}) ; 
		int corePoolSize = 3 ;   //线程池的基本大小
		int maximumPoolSize = 5 ;  //线程池最大大小
		long keepAliveTime = 1000 ; //线程活动保持时间
		TimeUnit unit = TimeUnit.MILLISECONDS ;  //线程活动保持时间的单位
		ThreadPoolExecutor executor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue) ;
		//我们可以使用execute提交的任务，但是execute方法没有返回值，所以无法判断任务是否被线程池执行成功
		executor.execute(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		//我们也可以使用submit 方法来提交任务，它会返回一个future,那么我们可以通过这个future来判断任务是否执行成功，通过future的get方法来获取返回值，
		//get方法会阻塞住直到任务完成，而使用get(long timeout, TimeUnit unit)方法则会阻塞一段时间后立即返回，这时有可能任务没有执行完。
	   Future<Object> future =  (Future<Object>) executor.submit(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				
			}
	    	
	    }) ;
	   try {
		     Object s = future.get();
		} catch (InterruptedException e) {
		    // 处理中断异常
		} catch (ExecutionException e) {
		    // 处理无法执行任务异常
		} finally {
		    // 关闭线程池
		    executor.shutdown();
		}
	}

	/**
	 * 当提交一个新任务到线程池时，线程池的处理流程如下：

	   1.首先线程池判断基本线程池是否已满？没满，创建一个工作线程来执行任务。满了，则进入下个流程。
	   2.其次线程池判断工作队列是否已满？没满，则将新提交的任务存储在工作队列里。满了，则进入下个流程。
	   3.最后线程池判断整个线程池是否已满？没满，则创建一个新的工作线程来执行任务，满了，则交给饱和策略来处理这个任务。
	 */
	
	/**
	 ***********合理配置线程池************************************
	 * 任务性质不同的任务可以用不同规模的线程池分开处理。CPU密集型任务配置尽可能小的线程，如配置Ncpu+1个线程的线程池。
	 * IO密集型任务则由于线程并不是一直在执行任务，则配置尽可能多的线程，如2*Ncpu。混合型的任务，如果可以拆分，
	 * 则将其拆分成一个CPU密集型任务和一个IO密集型任务，只要这两个任务执行的时间相差不是太大，那么分解后执行的吞吐率要高于串行执行的吞吐率，
	 * 如果这两个任务执行时间相差太大，则没必要进行分解。
	 * 我们可以通过Runtime.getRuntime().availableProcessors()方法获得当前设备的CPU个数。
	 */
}
