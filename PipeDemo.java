import java.lang.*;
import java.util.*;
import java.io.*;

class Producer extends Thread
{
   OutputStream os;
    
	public Producer(OutputStream o)
	{
		os=o;
	}
	public void run()
	{
		int count=1;
		
		while(true)
		{
			try
			{
				os.write(count);
				os.flush();
				System.out.println("Producer" + count);
				System.out.flush();
				Thread.sleep(10);
				count++;
			}
			catch(Exception e){}
		}
	}
}

class Consumer extends Thread
{
   InputStream is;
    
	public Consumer(InputStream s)
	{
		is=s;
	}
	public void run()
	{
		int x;
		
		while(true)
		{
			try
			{
				x=is.read();
				
				System.out.println("Consumer" + x);
				System.out.flush();
			}
			catch(Exception e){}
		}
	}
}

public class PipeDemo
{
	public static void main(String args[]) throws Exception
	{
		PipedInputStream pis=new PipedInputStream();
		PipedOutputStream pos=new PipedOutputStream();
		
		
		pis.connect(pos);
		Producer p=new Producer(pos);
		Consumer c=new Consumer(pis);
		
		p.start();
		c.start();
	}
}
		