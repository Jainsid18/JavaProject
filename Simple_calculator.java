import java.lang.*;
import java.util.*;
public class Simple_calculator
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		double num1,num2,result;
		int choice;
		
		System.out.println("Simple Calculator");
		System.out.println("==================");
		
		System.out.println("Enter first Number:");
		num1=sc.nextDouble();
		
		System.out.println("Enter Second Number:");
		num2=sc.nextDouble();
		
		System.out.println("\n Select Operation");
		System.out.println("1. Addition(+)");
		System.out.println("2. Substraction(-)");
		System.out.println("3. Multiplication(*)");
		System.out.println("4. Division(/)");
		
		System.out.println("Enter the choice (1-4)");
		choice = sc.nextInt();
		
		switch(choice)
		{
			case 1:
			   result = num1 + num2;
			   System.out.println("Result:" + result);
			   break;
			   
			case 2:
			   result = num1 - num2;
			   System.out.println("Result:" + result);
			   break;
			   
			case 3:
			   result = num1 * num2;
			   System.out.println("Result:" + result);
			   break;
			   
			case 4:
			if (num2!=0){
			   result = num1 / num2;
			   System.out.println("Result" + result);
			  }else{
				System.out.println("Error: Division by zero is not allowed.");
			  }
			   break;
			   
			default:
			   System.out.println("Invalid choice! Please enter a number 1 and 4.");
		}
		
		sc.close();
	}
}
			   
			   
			   
		
		