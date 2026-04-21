//Created with support from:
//https://winterbe.com/posts/2015/04/30/java8-concurrency-tutorial-synchronized-locks-examples/
import java.util.concurrent.locks.ReentrantLock;

public class BlockingTableware
{
	//https://docs.oracle.com/javase/7/docs/api/java/util/concurrent/locks/ReentrantLock.html
	private ReentrantLock knife = new ReentrantLock();
	private ReentrantLock fork = new ReentrantLock();
	
	private int blocked_count = 0;
	
	//Returns true if knife was successfully acquired
	public boolean pickupKnife()
	{
		//tryLock both attempts to acquire the lock and reports
		//back True if it was successful or False if not.
		boolean acquired = knife.tryLock();
		if(acquired)
			System.out.println(Thread.currentThread().getName()+" picked up knife.");
		else
			System.out.println(Thread.currentThread().getName()+" wants knife but can't have it.");
		return acquired;
	}
	
	public boolean iHaveKnife()
	{
		return knife.isHeldByCurrentThread();
	}
	
	public void putDownKnife()
	{
		System.out.println(Thread.currentThread().getName()+" puts down knife.");
		knife.unlock();
	}

	//Returns true if fork was successfully acquired
	public boolean pickupFork()
	{
		boolean acquired = fork.tryLock();
		if(acquired)
			System.out.println(Thread.currentThread().getName()+" picked up fork.");
		else
			System.out.println(Thread.currentThread().getName()+" wants fork but can't have it.");
		return acquired;
	}
	
	public boolean iHaveFork()
	{
		return fork.isHeldByCurrentThread();
	}
	
	public void putDownFork()
	{
		System.out.println(Thread.currentThread().getName()+" puts down fork.");
		fork.unlock();
	}
	
	private String whatsMissing()
	{
		if(!iHaveFork() && !iHaveKnife())
			return "knife and fork";
		if(!iHaveKnife())
			return "knife";
		if(!iHaveFork())
			return "fork";
		return "";
	}
	
	public boolean eat()
	{
		if(iHaveKnife() && iHaveFork())
		{
			System.out.println("Yum :) says "+Thread.currentThread().getName());
			return true;
		}
		else
		{
			System.out.println(Thread.currentThread().getName()+" can't eat :( doesn't have "+whatsMissing());
			blocked_count++;
			return false;
		}
	}

	public synchronized boolean blockingEat()
	{
		// Keep trying until they have both utensils
		while (!iHaveKnife() || !iHaveFork())  // While they don't have both'
		{
			pickupKnife();
			pickupFork();

			// If they couldn't get both, put down whatever they have and wait
			if (!iHaveKnife() || !iHaveFork())
			{
				// Put down whatever they have
				if (iHaveKnife()) putDownKnife();
				if (iHaveFork()) putDownFork();

				try
				{
					wait(); // Wait to be notified by another thread if they can't get both
				}
				// If the thread is interrupted, exit the method
				catch (InterruptedException e)
				{
					Thread.currentThread().interrupt();
				}
			}
		}

		// They have both utensils — eat
		eat();

		// Put down utensils so the other philosopher can use them
		putDownKnife();
		putDownFork();

		// Wake up the other philosopher
		notifyAll();

		return true; // They were able to eat:)
	}

	public int getFailureCount()
	{
		return blocked_count;
	}
}