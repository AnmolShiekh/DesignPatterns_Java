package singelton;

/*
 * Author: Anmol Bilal
 * Email: anmol.shiekh1@gmail.com
 * */
public class main_Singelton {
	public static void main(String[] args)
	{
		Singelton obj1= Singelton.getInstance();
		obj1.OtherMethods();
		Singelton obj2=Singelton.getInstance();
		System.out.println(obj1 == obj2); // to ensure that both objects are referring to same instance.
	}

}
