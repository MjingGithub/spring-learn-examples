package com.mj.springAction.alibaba.rule;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class MyTimerTask extends TimerTask{

	@Override
	public void run() {
		System.out.println("Timer task started at:"+new Date());
        completeTask();
        System.out.println("Timer task finished at:"+new Date());
		
	}
	
	private void completeTask() {
        try {
            //assuming it takes 20 secs to complete the task
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
	
	public static void main(String[] args) {
		TimerTask timerTask = new MyTimerTask() ;
		 //running timer task as daemon thread
        Timer timer = new Timer(true);
        //schedule 是 前一个任务结束时间跟后一个启动时间相隔 period 时间间隔，
        //而 scheduleAtFixedRate 是 任务开始时间间隔 period ， 定时执行，前一个未结束不影响后一个触发执行
        timer.scheduleAtFixedRate(timerTask, 0, 10*1000);
        System.out.println("TimerTask started");
        //cancel after sometime
        try {
			Thread.sleep(120000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        timer.cancel();
        System.out.println("TimerTask cancelled");
        try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
