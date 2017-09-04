package com.eudriscabrera.examples.concurrency.java8.tutorial;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * 
 * @author ecabrerar
 *
 */

public class ExecutorServiceWithCallableAndFutureAndTimeouts {

    public static void main(String[] args) {
	
	ExecutorService executor = Executors.newFixedThreadPool(1);
	Future<Integer> future = executor.submit(()->{
	    try {
	        TimeUnit.SECONDS.sleep(2);
	        return 123;
	    }
	    catch (InterruptedException e) {
	        throw new IllegalStateException("task interrupted", e);
	    }	    
	
	});

	System.out.println("future done? " + future.isDone());

	Integer result = 0;
	
	try {
	    result = future.get(2,TimeUnit.SECONDS);
	} catch (InterruptedException | ExecutionException | TimeoutException e) {
	   e.printStackTrace();
	}

	System.out.println("future done? " + future.isDone());
	System.out.print("result: " + result);


    }

}
