package com.levelup.java.date;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.time.StopWatch;
import org.apache.log4j.Logger;
import org.junit.Test;

import com.google.common.base.Stopwatch;

/**
 * This java example will demonstrate calculating elapsed time in java.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/calculate-elapsed-time/'>Calculate elapsed time</a>
 * 
 */
public class MeasureElapsedTime {

	private static final Logger logger = Logger.getLogger(MeasureElapsedTime.class);
	
	@Test
	public void calculate_elapsed_time_in_java () throws InterruptedException {
		
		long startTime = System.currentTimeMillis();
		
		Thread.sleep(2); // simulate work
		
		long estimatedTime = System.currentTimeMillis() - startTime;

		logger.info("time: " + estimatedTime); 

		assertTrue(estimatedTime >= 0);
	}
	
	@Test
	public void calculate_elapsed_time_nano_in_java () throws InterruptedException {
		
		long startTime = System.nanoTime();

		Thread.sleep(2); // simulate work
		
		long estimatedTime = System.nanoTime() - startTime;

		logger.info("time: " + estimatedTime); 
		
		assertTrue(estimatedTime >= 0);
	}
	
	@Test
	public void calculate_elapsed_time_in_guava() throws InterruptedException {

		Stopwatch stopwatch = Stopwatch.createStarted();
		
		Thread.sleep(2); // simulate work

		stopwatch.stop(); // optional

		long millis = stopwatch.elapsed(TimeUnit.MILLISECONDS);

		logger.info("time: " + stopwatch); 
		
		assertTrue(millis >= 0);
	}

	@Test
	public void calculate_elapsed_time_in_apache_commons () throws InterruptedException {
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		
		Thread.sleep(2); // simulate work
		
		stopWatch.stop();
		long millis = stopWatch.getNanoTime();

		logger.info("time: " + millis); 
		
		assertTrue(millis >= 0);
	}
	
	@Test
	public void calculate_elapsed_time_in_spring () throws InterruptedException {
		
		org.springframework.util.StopWatch stopWatch = 
				new org.springframework.util.StopWatch();
		
		stopWatch.start("step 1");
		Thread.sleep(2); // simulate work
		stopWatch.stop();

		stopWatch.start("step 2");
		Thread.sleep(5); // simulate work
		stopWatch.stop();

		stopWatch.start("step 3");
		Thread.sleep(3); // simulate work
		stopWatch.stop();

		logger.info("time: " + stopWatch.prettyPrint()); 
		
		assertTrue(stopWatch.getTotalTimeMillis() >= 0);
	}
	

}
