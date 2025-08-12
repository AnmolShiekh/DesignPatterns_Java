package singelton;
/*
 * Author: Anmol Bilal
 * Email: anmol.shiekh1@gmail.com
 * */
public class mian_threadSingleton {
	public static void main(String[] args)
	{
		for(int i=0;i<10;i++)
		{
			Thread t=new Thread(() -> 
			{
				Singelton_threadSafety obj_t1=Singelton_threadSafety.getInstance();
				System.out.println("The instance: "+obj_t1.hashCode()+" from "+Thread.currentThread().getName());
			} , "Thread-"+i);
			t.start();
		}


	}
}
