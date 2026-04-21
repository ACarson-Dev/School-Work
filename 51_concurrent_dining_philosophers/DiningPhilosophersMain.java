/*
Title: Blocking Tableware
Author: Alexander Carson in collaboration with Neal Holtschulte
Date: 04-12-2026
Purpose: Coordinate shared utensil access between philosopher threads
Sources: Winterbe Java 8 Concurrency Tutorial - Synchronized and Locks:
             https://winterbe.com/posts/2015/04/30/java8-concurrency-tutorial-synchronized-locks-examples/
             - Reference for ReentrantLock usage and tryLock behavior
         Oracle Java API - ReentrantLock:
             https://docs.oracle.com/javase/7/docs/api/java/util/concurrent/locks/ReentrantLock.html
             - Reference for ReentrantLock methods including tryLock, unlock, and isHeldByCurrentThread
         Queried Claude AI for the following:
             - References formatting
*/
public class DiningPhilosophersMain
{
	public static void main(String args[])
	{
		BlockingTableware place_setting = new BlockingTableware();
		PhilosopherBest p1 = new PhilosopherBest(place_setting);
		PhilosopherBest p2 = new PhilosopherBest(place_setting);

		p1.setName("Plato");
		p2.setName("Socrates");
		
		long start = System.nanoTime();
		
		// Start two threads
		p1.start();
		p2.start();
		
		// wait for threads to end
		try
		{
			p1.join();
			p2.join();
		}
		catch(Exception e)
		{ 
			System.out.println("Interrupted"); 
		}

		long end = System.nanoTime();
		
		System.out.printf("Philosophers prevented each other from eating %d times\nand it took them %.5f seconds to eat.", place_setting.getFailureCount(), ((double)(end-start)/1000000000L));
	} 
}