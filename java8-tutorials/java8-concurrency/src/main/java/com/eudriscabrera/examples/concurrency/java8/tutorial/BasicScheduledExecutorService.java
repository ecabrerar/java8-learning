
package com.eudriscabrera.examples.concurrency.java8.tutorial;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * @author ecabrerar
 *
 */
public class BasicScheduledExecutorService {

 
    public static void main(String[] args) throws InterruptedException {
	ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

	Runnable task = () -> System.out.println("Scheduling: " + System.nanoTime());
	ScheduledFuture<?> future = executor.schedule(task, 3, TimeUnit.SECONDS);

	TimeUnit.MILLISECONDS.sleep(1337);

	long remainingDelay = future.getDelay(TimeUnit.MILLISECONDS);
	System.out.printf("Remaining Delay: %sms", remainingDelay);

    }

}
