
package com.eudriscabrera.examples.concurrency.java8.tutorial;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author ecabrerar
 *
 */
public class ScheduledExecutorServiceWithFixedExecutionDelay {

 
    public static void main(String[] args) throws InterruptedException {
	ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

	Runnable task = () -> {
	    try {
	        TimeUnit.SECONDS.sleep(2);
	        System.out.println("Scheduling: " + System.nanoTime());
	    }
	    catch (InterruptedException e) {
	        System.err.println("task interrupted");
	    }
	};
	
	

	executor.scheduleWithFixedDelay(task, 0, 1, TimeUnit.SECONDS);
    }

    
    
}
