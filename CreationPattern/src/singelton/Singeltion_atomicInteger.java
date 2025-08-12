package singelton;
/*
 * Author: Anmol Bilal
 * Email: anmol.shiekh1@gmail.com
 * */
/*
 * Limitation of Volatile: It does not hanlde atomic operations like x++. For example, two threads t1 & t2 might do x++ but ends up with
	only one increment and then write to main memory.*/

import java.util.concurrent.atomic.AtomicInteger;

public class Singeltion_atomicInteger {
	
	private static volatile Singeltion_atomicInteger instance;
	private AtomicInteger x=new AtomicInteger(0);

	private Singeltion_atomicInteger()
	{
		System.out.println("Instance Created From "+ Thread.currentThread().getName());
	}
	
	public static Singeltion_atomicInteger getInstance()
	{
		if(instance == null)
		{
			synchronized (Singeltion_atomicInteger.class) {
				if(instance==null)
				{
					instance=new Singeltion_atomicInteger();
				}
				
			}
		}
		return instance;
	}
	
	public void increment() // Fix 2: Atomic Integer
	{
		x.incrementAndGet();
	}

	public AtomicInteger getX() {
		return x;
	}

	public void setX(AtomicInteger x) {
		this.x = x;
	}
	
}
