import java.security.SecureRandom;

public class PhilosopherBest extends Thread
{
	private static final SecureRandom generator = new SecureRandom();
	private BlockingTableware t;
	
	// Constructor
	public PhilosopherBest(BlockingTableware t){
		this.t=t;
	}

	public void run()
	{
		for(int i=0; i<1000; i++)
		{
			t.blockingEat();
		}
	}
}