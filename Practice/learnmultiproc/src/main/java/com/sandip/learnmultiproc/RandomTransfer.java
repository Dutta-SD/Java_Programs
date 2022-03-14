package com.sandip.learnmultiproc;

/*
 * Random Transfer class using Functional Interface
 * Can also use Lambda Expression
 */
public class RandomTransfer implements Runnable {
	public RandomTransfer(int startAccount, int endAccount) {
		super();
		this.startAccount = startAccount;
		this.endAccount = endAccount;
	}			
	private int STEPS = 30;
	private int MAX_AMOUNT = 10000;
	private int DELAY = 10;
	private int startAccount, endAccount;

	public void run() {
		try {
			for (int i = 0; i < STEPS; i++) {
				double amount = MAX_AMOUNT * Math.random();
				System.out.println("Transferred Rs " + amount + " from " + startAccount + " to " + endAccount);
				Thread.sleep((int) (DELAY * Math.random()));
			}

		} catch (InterruptedException e) {
		}
	}
}
