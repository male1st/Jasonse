package com.jason.se.simple.jvm;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Timer;
import java.util.TimerTask;

public class JVMMemory {
	public static void main(String[] args) {
		/*
		 * long maxMemonry = Runtime.getRuntime().maxMemory(); // 最大可用内存，对应-Xmx
		 * 
		 * long freeMemonry = Runtime.getRuntime().freeMemory(); // 当前JVM空闲内存
		 * 
		 * long totalMemory = Runtime.getRuntime().totalMemory(); //
		 * 当前JVM占用的内存总数，其值相当于当前JVM已使用的内存及freeMemory()的总和
		 * 
		 * System.out.println(maxMemonry + ":\r" + freeMemonry + ":\n" +
		 * totalMemory);
		 * 
		 * System.out.println(totalMemory - freeMemonry);
		 * 
		 * System.out.println(maxMemonry / 1024 / 1024);
		 */

		GCTimerTask.getInstance();

	}
}

class GCTimerTask extends TimerTask {
	private static GCTimerTask instance = null;

	public void run() {
		Calendar cal = new GregorianCalendar();
		int hour24 = cal.get(Calendar.HOUR_OF_DAY); // 0..23
		int min = cal.get(Calendar.MINUTE); // 0..59
		System.out.print("[" + String.valueOf(hour24) + ":"
				+ String.valueOf(min) + "]");
		System.out.println("JVM可用内存:"
				+ java.lang.Runtime.getRuntime().freeMemory() / (1024 * 1024)
				+ "M/" + java.lang.Runtime.getRuntime().totalMemory()
				/ (1024 * 1024) + "M");
		System.gc();
	}

	private void startWork() {
		Timer t = new Timer();
		t.schedule(instance, 0, 1000);
	}

	public static GCTimerTask getInstance() {
		if (instance == null) {
			instance = new GCTimerTask();
			instance.startWork();
		}
		return instance;
	}

}