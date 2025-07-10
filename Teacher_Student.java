import java.lang.*;
import java.util.*;
class Whiteboard
{
	String text;
	int numofstu=0;
	int count=0;
	public void attendance()
	{
		numofstu++;
	}
	synchronized public void write(String t)
	{
		System.out.println("Teacher is writing:- " +t);
		while(count!=0)
			try{
				wait();
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			text=t;
			count=numofstu;
			notifyAll();
	}
	
    synchronized public String read()
	{
		while(count==0)
			try{
				wait();
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			String t=text;;
			count--;
			if(count==0)
				notify();
			return t;
	}
}

class Teacher extends Thread{
	Whiteboard whiteboard;
	String notes[]={" Java is a language ","Itis OOPs","It is a platform Independent","It support Thread", "end"};
	public Teacher(Whiteboard whiteboard)
	{
		this.whiteboard=whiteboard;
	}
	public void run()
	{
		for(int i=0;i<notes.length;i++){
	       whiteboard.write(notes[i]);
		}
	}
}

class Student extends Thread
{
	String name;
	Whiteboard wb;
	public Student(String n,Whiteboard w)
	{
		name=n;
		wb=w;
	}
	 public void run()
	 {
		 String text;
		 wb.attendance();
		 
		 do
		 {
			 text=wb.read();
			 System.out.println(name +" Reading " +text);
			 System.out.flush();
		 }while(!text.equals("end"));
	 }
}

public class Teacher_Student
{
	public static void main(String args[])
	{
		Whiteboard wb=new Whiteboard();
		Teacher t=new Teacher(wb);
		
		Student s1=new Student("1. John",wb);
		Student s2=new Student("2. Ajay",wb);
		Student s3=new Student("3. Kloob",wb);
		Student s4=new Student("4. Smith",wb);
		t.start();
		s1.start();
		s2.start();
		s3.start();
		s4.start();
		
	}
}
	

	
	
	
	