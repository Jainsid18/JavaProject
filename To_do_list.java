import java.lang.*;
import java.util.*;

public class To_do_list
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		ArrayList<String>tasks = new ArrayList<>();
		int choice;
		
		while(true)
		{
			System.out.println("\n1.Add Task");
			System.out.println("\n2.View  Task");
			System.out.println("\n3.Remove Task");
			System.out.println("\n4.Exit");
			System.out.println("Enter your choice");
			choice =sc.nextInt();
			sc.nextLine();
			
			switch(choice)
			{
				case 1:
				System.out.println("Enter task:");
				String task=sc.nextLine();
				tasks.add(task);
				System.out.println("Task added");
				break;
				case 2:
				  System.out.println("\nYour Tasks:");
				  for(int i=0;i<tasks.size();i++)
				  {
					  System.out.println((i+1) + "." + tasks.get(i));
				  }
				  break;
				case 3:
				System.out.println("Enter task number to remove");
				int taskNumber=sc.nextInt();
				if(taskNumber>=1 && taskNumber <=tasks.size())
				{
					tasks.remove(taskNumber -1);
					System.out.println("Task removed");
				}else{
					System.out.println("Invalid task number.");
				}
				break;
				case 4:
				  System.out.println("Exiting...Bye!");
				  sc.close();
				  return;
				default:
				   System.out.println("Invalid choice.Try again.");
			}
		}
	}
}
				  
				
		
				
			
			
			