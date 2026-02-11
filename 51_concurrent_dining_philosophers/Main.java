
public class Main
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