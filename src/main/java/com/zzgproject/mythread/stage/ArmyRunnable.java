package com.zzgproject.mythread.stage;

/**
 * 
 * @author zzg
 * 军队线程
 * 模拟作战双方的行为
 */
public class ArmyRunnable implements Runnable {

	//volatile保证了线程可以正确的读取其他线程写入的值
	//可见性 ref JMM， happens-before原则
	volatile boolean keepRunning = true;

	@Override
	public void run() {
		while(keepRunning){
			//发动5连击
			for(int i=0;i<5;i++){
				System.out.println(Thread.currentThread().getName()+"进攻对方["+i+"]");
				//让出了处理器时间，下次该谁进攻还不一定呢！
				Thread.yield();
			}

		}
		
		System.out.println(Thread.currentThread().getName()+"结束了战斗！");

	}
	
	
	public static void main(String[] args){
		
		ArmyRunnable armyTaskOfSuiDynasty = new ArmyRunnable();
		ArmyRunnable armyTaskOfRevolt = new ArmyRunnable();
		
		//使用Runnable接口创建线程
		Thread  armyOfSuiDynasty = new Thread(armyTaskOfSuiDynasty,"隋军");
		Thread  armyOfRevolt = new Thread(armyTaskOfRevolt,"农民起义军");
		
		//启动线程，让军队开始作战
		armyOfSuiDynasty.start();
		armyOfRevolt.start();

	}

}




