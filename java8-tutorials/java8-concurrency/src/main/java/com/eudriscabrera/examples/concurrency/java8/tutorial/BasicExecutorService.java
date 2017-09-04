package com.eudriscabrera.examples.concurrency.java8.tutorial;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ecabrerar
 *
 */
public class BasicExecutorService {
    public static void main(String[] args) {

	ExecutorService executor = Executors.newSingleThreadExecutor();

	executor.submit(() -> {
	    String threadName = Thread.currentThread().getName();

	    System.out.println("Hello " + threadName);
	});
    }
}
