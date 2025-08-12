package singelton;
/*
 * Author: Anmol Bilal
 * Email: anmol.shiekh1@gmail.com
 * */
/*
 * Limitation of Volatile: It does not hanlde atomic operations like x++. For example, two threads t1 & t2 might do x++ but ends up with
	only one increment and then write to main memory.*/

public class Singelton_counter_atomicOP {
	private static volatile Singelton_counter_atomicOP instance;
	private int x=0;
	
	private Singelton_counter_atomicOP()
	{
		System.out.println("Instance Created By: "+ Thread.currentThread().getName());
	}
	
	public static Singelton_counter_atomicOP getInstance()
	{
		if(instance==null)
		{
			synchronized (Singelton_counter_atomicOP.class) {
				if(instance==null) //Double Check Lock
					instance=new Singelton_counter_atomicOP();
			}
		}
		return instance;
	}
	
	public int increment() // Fix 1: Define a method to perfrom the increment.
	{
		x++;
		System.out.println("X= "+this.getX()+" from "+Thread.currentThread().getName());
		return x;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

}
