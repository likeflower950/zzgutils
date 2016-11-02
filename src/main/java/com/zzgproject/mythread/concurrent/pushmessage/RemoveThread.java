package com.zzgproject.mythread.concurrent.pushmessage;

import java.util.Map.Entry;

public class RemoveThread implements Runnable {

	@Override
	public void run() {
		try {
		      for (int i = 0; i < 10000; i++) {
		        Thread.sleep(2000);
		        for(Entry<Integer, String> map:MainThread.pushmessage.entrySet()){
		          if (map.getKey()==i) {
		            System.out.println("成功收到id为："+map.getKey()+"返回的信息，删除该元素");
		            MainThread.pushmessage.remove(map.getKey());
		          }
		        }
		        System.out.println("内存对象中的元素数量为："+MainThread.pushmessage.size());
		      }
		    } catch (InterruptedException e) {
		      e.printStackTrace();
		    }
	}

}
