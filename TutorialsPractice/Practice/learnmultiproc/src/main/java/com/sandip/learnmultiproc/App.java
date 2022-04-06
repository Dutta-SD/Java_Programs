package com.sandip.learnmultiproc;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		Runnable r1 = new RandomTransfer(0, 1);
		Runnable r2 = new RandomTransfer(2, 3);
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		t1.start();
		t2.start();
	}
}

