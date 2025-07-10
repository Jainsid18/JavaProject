import java.lang.*;
import java.util.*;
class Account{
	private int balance =5000;
	public synchronized void withdraw(String name,int amount)
	{
		System.out.println(name + " is trying to withdraw rupees: " + amount);
		if(balance>=amount)
		{
			System.out.println(name+" is withdrawing rupees: " + amount);
			try
			{
				Thread.sleep(1000);
			}
			catch(InterruptedException e){
				System.out.println("Thread interrupted");
			}
			balance=balance-amount;
			System.out.println(name +" completed withdrawal. Remaining balance : "+ balance);
		}
		else {
			 System.out.println("Sorry " + name + ", insufficient balance. Current balance: ₹" + balance);
		}
	}
}
 
class WithdrawThread extends Thread
{
	private Account account;
	private String user;
	private int amount;
	
	public WithdrawThread(Account account, String user, int amount) {
        this.account = account;
        this.user = user;
        this.amount = amount;
    }
	
	public void run(){
		account.withdraw(user,amount);
	}
}

public class  ATMWithdrawalSimulation {
	public static void main(String args[])
	{
		Account account=new Account();
		WithdrawThread user1 = new WithdrawThread(account, "Siddhant", 3000);
        WithdrawThread user2 = new WithdrawThread(account, "Ravi", 2500);
        WithdrawThread user3 = new WithdrawThread(account, "Neha", 2000);
		
		user1.start();
		user2.start();
		user3.start();
	}
}

	