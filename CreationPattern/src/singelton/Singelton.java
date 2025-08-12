package singelton;
/*
 * Author: Anmol Bilal
 * Email: anmol.shiekh1@gmail.com
 * */
/*
 * Ensures that only one instance of a class exists in the whole application, and provide global point of access (public) to it.
 * */

public class Singelton {
	
	//Step 1: A static instance: so that there is exactly one shared instance for the entire class, no matter how many references are generated.
	private static Singelton instance;
	//Step 2: A private constructor. so that no other class can call it.
	private Singelton() {}
	
	//Step 3: Public method to get the instance in other classes.
	public static Singelton getInstance()
	{
		if(instance==null)
			instance=new Singelton();
		return instance;
	}
	
	public void OtherMethods()
	{
		System.out.println("Hello, we are learning Singleton Design Pattern");
	}
}