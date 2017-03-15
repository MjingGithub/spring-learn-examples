package com.mj.springAction.alibaba.rule;
/**
 * 
 * @author jing.ming
 *Java中的ThreadLocal类允许我们创建只能被同一个线程读写的变量。
 *因此，如果一段代码含有一个ThreadLocal变量的引用，即使两个线程同时执行这段代码，它们也无法访问到对方的ThreadLocal变量。
 */
public class SequenceNumber {

	private static ThreadLocal<Integer> seqNum = new ThreadLocal<Integer>(){
		@Override
		protected Integer initialValue(){
			return 0;
			
		}
		
	} ;
	
	public int getNextNum(){
		seqNum.set(seqNum.get()+1);
		return seqNum.get() ;
	}
	
	public static void main(String[] args) {
		SequenceNumber sn = new SequenceNumber() ;
		TestClient t1 = new TestClient(sn);
		TestClient t2 = new TestClient(sn);
		TestClient t3 = new TestClient(sn);
		t1.start();
		t2.start();
		t3.start();
	}
	
	/**
	 * 考察输出的结果信息，我们发现每个线程所产生的序号虽然都共享同一个SequenceNumber实例，但它们并没有发生相互干扰的情况，
	 * 而是各自产生独立的序列号，这是因为我们通过ThreadLocal为每一个线程提供了单独的副本。
	 * @author jing.ming
	 *
	 */
	
	private static class TestClient extends Thread{
		private SequenceNumber sn ;
		public TestClient(SequenceNumber sn){
			this.sn = sn ;
		}
		
		public void run(){
			for (int i = 0; i < 3; i++) {
				System.out.println("thread["+Thread.currentThread().getName()+"] sn["+sn.getNextNum()+"]");
				}
		}
	}
}
