import java.lang.*;
import java.util.*;
class ATM
{
	public synchronized void  checkBalance(String name)
	{
		System.out.println(name + "Is checking balance");
		try
		{
			Thread.sleep(1000);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
			
	}
	public synchronized void withdraw(String name , int amount)
	{
		System.out.println(name + "Is withdrwaing  his amount "+ amount);
		try
		{
			Thread.sleep(1000);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}

class Customer extends Thread
{
	ATM atm;
	String name;
	int amount;
	Customer(String name,ATM atm, int amount)
	{
		this.name=name;
		this.atm=atm;
		this.amount=amount;
	}
		
	public void run()
	{
		atm.checkBalance(name);
		atm.withdraw(name,amount);
	}
}

public class ATM_Machine
{
	public static void main(String args[])
	{
		ATM atm=new ATM();
		Customer c1=new Customer("Siddhant",atm,100);
		Customer c2=new Customer("Shivam",atm,200);
		c1.start();
		c2.start();
	}
}
		