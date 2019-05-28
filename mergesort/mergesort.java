import java.io.*;
import java.util.*;

class mergesort
{
	static int MAX = 150000;
	static int a[] = new int[MAX];
	static String s = null;

	void readArr(int a[],int n)
	{
		for(int i=0;i<n;i++)
		{
			Random rand = new Random();
			a[i] = rand.nextInt();
		}
	}
	
	static int[] joinArr(int a[], int b[], int c[], int n)
	{
		int p = n/2;
		int q = n-p;
		int i=0,j=0,k=0;
		while( i!=p && j!=q)
		{
			if(b[i]<c[j])
			{
				a[k] = b[i];
				i++;
				k++;
			}
			else
			{
				a[k] = c[j];
				j++;
				k++;
			}
		}

		while(i!=p)
		{
			a[k]=b[i];
			i++;
			k++;
		}

		while(j!=q)
		{
			a[k]=c[j];
			j++;
			k++;
		}

		return a;
	}

	static int[] sortArr(int a[],int n)
	{
		int p = n/2;
		int q = n-p;

		int[] b = new int[p];
		int[] c = new int[q];

		if(n>1)
		{
			for(int i=0;i<p;i++)
			{
				b[i]=a[i];
			}

			sortArr(b,p);
			
			int w=0;
			for(int i=p; i<n; i++)
			{
				c[w]=a[i];
				w++;
			}

			sortArr(c,q);

			joinArr(a,b,c,n);
		}
		return a;
	}

	void plotgraph(int a[]) throws IOException
	{
		File file = new File("plotted.txt");
		FileWriter wr = new FileWriter(file);
		BufferedWriter bf = new BufferedWriter(wr);
		bf.write("titleText: Sort algorithm analysis\n");
		bf.write("XunitText: problem size\n");
		bf.write("YunitText: Time taken in sec\n");
		for(int i=5000; i<MAX;i+=100)
		{
			readArr(a,i);
			double timebefore = System.currentTimeMillis();
			sortArr(a,i);
			double timeafter = System.currentTimeMillis();
			double timespent = (timeafter - timebefore)*Math.pow(10,-3);
			bf.write(i +" "+timespent+"\n");
		}
		bf.close();
		Process p = Runtime.getRuntime().exec("xgraph plotted.txt");
		BufferedReader bf1 = new BufferedReader(new InputStreamReader(p.getInputStream()));
		while ((s = bf1.readLine())!=null)
			System.out.println(s);

		bf1.close();
	}

	public static void main(String args[]) throws IOException
	{
		mergesort obj = new mergesort();
		obj.plotgraph(a);
	}
}
