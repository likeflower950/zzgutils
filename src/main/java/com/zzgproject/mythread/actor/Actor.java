package com.zzgproject.mythread.actor;


/**
 * @author zzg
 * 创建一个线程类
 * Actor对象通过继承Thread对象创建线程对象
 */
public class Actor extends Thread {
	
	public void run(){
		
		System.out.println(Thread.currentThread().getName()+"是一个演员22222222222222！");
		
		System.out.println(getName()+"是一个演员！");
		int count = 0;
		boolean keepRunning = true;
	
		while(keepRunning){
			System.out.println(getName()+"登台演出："+ (++count));
			
			if(count == 100){
				keepRunning = false;
			}
			
			if(count%10== 0){
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println(getName()+"的演出结束了！");
	}
	
	
	public static void main(String[] args){
		Thread actor = new Actor();
		actor.setName("Mr. Thread");
		
		actor.start();
		
		/**
		 *  实现Runnable接口的线程类，在实例化的时候，需要通过传递线程对象进行创建
		 */
		Thread actressThread = new Thread(new Actress(), "Ms. Runnable");
		actressThread.start();
	}

}


/**
 * =====一个类中可以有多个CLASS对象，但是只能有一个public对象=====
 * @author zzg
 * Actress对象通过实现Runnable对象创建线程对象
 */
class Actress implements Runnable{

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+"是一个演员！");
		int count = 0;
		boolean keepRunning = true;
	
		while(keepRunning){
			System.out.println(Thread.currentThread().getName()+"登台演出："+ (++count));
			
			if(count == 100){
				keepRunning = false;
			}
			
			if(count%10== 0){
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println(Thread.currentThread().getName()+"的演出结束了！");
		
	}
	
}