package com.eudriscabrera.examples.concurrency.java8.tutorial;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 
 * @author ecabrerar
 *
 */

public class ExecutorServiceWithCallableAndInvokeAll {

    public static void main(String[] args) throws InterruptedException {
	
	
	ExecutorService executor = Executors.newWorkStealingPool();
	
	List<Callable<String>> callables = Arrays.asList(
	        () -> "task1",
	        () -> "task2",
	        () -> "task3");
	
	executor.invokeAll(callables)
	.stream()
	.map(future -> {
	    try {
	            return future.get();
	        }
	        catch (Exception e) {
	            throw new IllegalStateException(e);
	        }
	    }
	).forEach(System.out::println);
    }

}
