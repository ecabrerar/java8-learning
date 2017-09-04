package com.eudriscabrera.examples.concurrency.java8.tutorial;

import java.util.concurrent.TimeUnit;

/**
 * @author ecabrerar
 *
 */
public class BasicThreadWithSleepTime {

    public static void main(String[] args) {
	Runnable task = () -> {

	    try {
		String name = Thread.currentThread().getName();

		System.out.println("Foo " + name);
		TimeUnit.SECONDS.sleep(1);
		System.out.println("Bar " + name);
		
	    } catch (InterruptedException e) {		
		e.printStackTrace();
	    }

	};

	task.run();
	
	Thread thread = new Thread(task);
	thread.start();

    }

}
