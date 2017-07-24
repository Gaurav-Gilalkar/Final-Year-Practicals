import java.io.*;

public class GGByzantine
{
	public static void main(String a[]) throws IOException
	{
		double s1,s2,s3,s4,s5,per;
		int num,choice=10,fact;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(choice!=0)
		{	
		System.out.println("Enter your choice");
		System.out.println("0. Exit");
		System.out.println("1. Calculate result");
		System.out.println("2. Calculate factorial");
		choice = Integer.parseInt(br.readLine());
		switch(choice)		   
		{
			case 0:
			System.out.println("The program will now exit in 2 seconds");
			try
			{
				Thread.sleep(2000);
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
			break;
			case 1:
			System.out.println("You chose to calculate result");
			System.out.println("Enter the marks of all subjects of a student(out of 100) separated by end of line: ");
		    s1 = Double.parseDouble(br.readLine());
			s2 = Double.parseDouble(br.readLine());
			s3 = Double.parseDouble(br.readLine());
			s4 = Double.parseDouble(br.readLine());
			s5 = Double.parseDouble(br.readLine());
			per=result(s1,s2,s3,s4,s5);
			System.out.println("The student has scored "+per+"%");
			break;
			
			case 2:
			System.out.println("You chose to calculate factorial");
			System.out.println("Enter the number to calculate it's factorial");
			num = Integer.parseInt(br.readLine());
		    fact = factorial(num);
			System.out.println("Factorial of "+num+" is "+fact);
			break;
			
			default:
			System.out.println("Please enter a proper choice");
			
		
		}
		}		
	}
	static double result(double s1,double s2,double s3,double s4,double s5)
	{
		double total,res;
		total = s1 + s2 + s3 + s4 + s5;
		res = total*500/100;
		return res; 
	}
	static int factorial(int num)
	{
		int fact=0,i;
		for(i=1;i<=num;i++)
			fact=fact*i;
		return fact;
	}
	
}