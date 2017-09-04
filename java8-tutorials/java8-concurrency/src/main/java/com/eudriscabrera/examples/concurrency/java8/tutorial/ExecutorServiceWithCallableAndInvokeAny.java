package com.eudriscabrera.examples.concurrency.java8.tutorial;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 
 * @author ecabrerar
 *
 */

public class ExecutorServiceWithCallableAndInvokeAny {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

	ExecutorService executor = Executors.newWorkStealingPool();

	List<Callable<String>> callables = Arrays.asList(callable("task1", 2), callable("task2", 1),
		callable("task3", 3));

	String result = executor.invokeAny(callables);
	System.out.println(result);
    }

    static Callable<String> callable(String result, long sleepSeconds) {
	return () -> {
	    TimeUnit.SECONDS.sleep(sleepSeconds);
	    return result;
	};
    }
}
