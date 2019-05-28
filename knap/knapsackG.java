import java.util.*;
import java.io.*;

public class knapsackG
{
	public static void main(String args[])
	{
		int i, j=0, max_qty, m,n;
		float sum=0, max;
		Scanner in = new Scanner(System.in);
		int array[][]=new int [2][20];
		System.out.println("Enter number of items");
		n=in.nextInt();
		System.out.println("Enter the weights of each item");
		for(i=0;i<n;i++)
			array[0][i]=in.nextInt();
		
		System.out.println("Enter the values of each item");
		for(i=0;i<n;i++)
			array[1][i]=in.nextInt();
		
		System.out.println("Enter the maximum value of the knapsack");
		max_qty=in.nextInt();
	
		m=max_qty;
		while(m>=0)
		{
			max=0;
			for(i=0;i<n;i++)
			{
				if(((float)array[1][i]/(float)array[0][i])>max)
				{
					max=((float)array[1][i])/((float)array[0][i]);
					j=i;
				}
			}
			if(array[0][j]>m)	
			{
				System.out.println("Quantity of item number: " +(j+1) +" added is "+m);
				sum+=m*max;
				m=-1;
			}
			else
			{
				System.out.println("Quantity of item number: "+(j+1) +" added is "+array[0][j]);
				m-=array[0][j];
				sum+=(float)array[1][j];
				array[1][j]=0;
			}
		}
		System.out.println("The total profit is: " +sum);
		in.close();
	}
}
