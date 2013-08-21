package com.jason.se.thread.simple;

public class TestThread {
	public static void main(String[] args) {
		new MyThread().start();
		new Thread(new WoThread()).start();
	}
}

class MyThread extends Thread{

	@Override
	public void run() {
		for (int i = 0; i <100; i++) {
			System.out.println("Hello:"+i);
		}
	}
	
}
class WoThread implements Runnable {
	@Override
	public void run() {
		for (int i = 0; i <100; i++) {
			System.out.println("wow:"+i);
		}
	}
}

