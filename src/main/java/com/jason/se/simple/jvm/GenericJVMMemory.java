package com.jason.se.simple.jvm;

import java.util.Timer;
import java.util.TimerTask;

public class GenericJVMMemory   extends TimerTask {
	
	public static void main(String[] args) {
		GenericJVMMemory.getInstance();
	}
	
	public void run() {
		Runtime runtime = Runtime.getRuntime();
		System.out.println("最大内存:"+(runtime.maxMemory()/(1024*1024))+"m,当前空闲内存:"+(runtime.freeMemory()/(1024*1024))+"m,当前JVM占用内存总数:"+(runtime.totalMemory()/(1024*1024))+"m,使用内存:"+((runtime.totalMemory()-runtime.freeMemory())/(1024*1024))+"m.实际可用内存:"+((runtime.maxMemory()-runtime.totalMemory()+runtime.freeMemory())/(1024*1024))+"m");
		System.gc();
	}

	public long scheduledExecutionTime() {
		return super.scheduledExecutionTime();
	}
	
	private void setTimeOut(){
		Timer timer=new Timer();
		timer.schedule(genericJVNMemory,0, 1000);
	}
	
	private static GenericJVMMemory genericJVNMemory;
	
	private GenericJVMMemory() {}
	
	public static  GenericJVMMemory getInstance(){
		if (genericJVNMemory==null) {
			genericJVNMemory=new GenericJVMMemory();
			genericJVNMemory.setTimeOut();
		}
		return genericJVNMemory;
	}
	
}
