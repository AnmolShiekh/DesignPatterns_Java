package singelton;
/*
 * Author: Anmol Bilal
 * Email: anmol.shiekh1@gmail.com
 * */
public class main_atomicInteger {

	public static void main(String[] args)  throws InterruptedException
	{
		Runnable task = () -> {
			Singeltion_atomicInteger obj=Singeltion_atomicInteger.getInstance();
			for(int i=0;i<1000;i++)
			{
				obj.increment();
			}
		};
		
		Thread t1=new Thread(task);
		Thread t2=new Thread(task);
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		
		System.out.println("Expected 2000, Got "+ Singeltion_atomicInteger.getInstance().getX());

	}

}
