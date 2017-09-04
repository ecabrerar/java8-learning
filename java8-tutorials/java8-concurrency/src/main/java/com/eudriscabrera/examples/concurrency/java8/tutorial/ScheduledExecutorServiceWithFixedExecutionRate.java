
package com.eudriscabrera.examples.concurrency.java8.tutorial;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author ecabrerar
 *
 */
public class ScheduledExecutorServiceWithFixedExecutionRate {

 
    public static void main(String[] args) throws InterruptedException {
	ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

	Runnable task = () -> System.out.println("Scheduling: " + System.nanoTime());
	int initialDelay = 0;
	int period = 1;

	executor.scheduleAtFixedRate(task, initialDelay, period, TimeUnit.SECONDS);
    }

    
    
}
