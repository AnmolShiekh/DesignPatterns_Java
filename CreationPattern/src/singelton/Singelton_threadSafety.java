package singelton;
/*
 * Author: Anmol Bilal
 * Email: anmol.shiekh1@gmail.com
 * */
/* Thread Safe Version: if multiple threads exist the base can end up generating multiple instances accidently.
For example, two threads (t1 and t2) running in parallel and so far the singelton class has no object. Both threads create an object
since no memory has been allocated yet, getinstance for t1 and t2 will allocate the memory to a new instance due to 
parallel execution. In such scenarios, we use volatile. */
public class Singelton_threadSafety {

	/*Step 1: A static instance: so that there is exactly one shared instance for the entire class, no matter how many references are generated.
	Volatile: Ensures visibility across multiple threads. it ensures that the latest value of the variable comes from the main memory
	and not from the thread local cache. Once a value is updated it immediatley writes the value back to the main memory.
	*/

	private static volatile Singelton_threadSafety instance;
	//Step 2: A private constructor. so that no other class can call it.
	private Singelton_threadSafety() {
		System.out.println("Singelton Created by"+Thread.currentThread().getName());
	}

	//Step 3: Public method to get the instance in other classes.
	public static Singelton_threadSafety getInstance()
	{
		if(instance==null)
		{
			synchronized (Singelton_threadSafety.class) {
				if(instance == null){
					/*Double-Checked Locking: To ensure if two threads enter the synchornization block they don't end with two instances.
					 * For example:
					 * Thread A → sees instance == null → enters synchronized.
					 * Thread B → sees instance == null → waits for the lock.
					 * Thread A → creates instance → exits lock.
					 * Thread B → gets lock → sees instance != null → skips creation.
					 */
					instance=new Singelton_threadSafety();
				}
			}

		}
		return instance;
	}

	public void OtherMethods()
	{
		System.out.println("Hello, we are learning Singleton Design Pattern");
	}
}
