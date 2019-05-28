import java.io.*;
import java.util.*;

class quicksort
{	
	static int MAX = 99995;
	static int a[] = new int[MAX];
	static String s = null;

	void readArr(int a[],int n)
	{
		for(int i=0;i<n;i++)
		{
			Random rand = new Random();
			a[i]=rand.nextInt();
		}
	}

	static int partArr(int a[],int l,int r)
	{
		int p = a[l];
		int i= l;
		int j =r+1;
		int temp;
		do
		{
			do
			{
				++i;
			}while(i<=r && a[i]<p);

			do
			{
				--j;
			}while(j>=l && a[j]>p);

			if(i<=r)
			{
				temp = a[i];
				a[i]=a[j];
				a[j]=temp;
			}
		}while(i<j);

		if(i<=r)
		{
			temp =a[i];
			a[i]=a[j];
			a[j]=temp;
		}
	
		temp=a[j];
		a[j]=a[l];
		a[l]=temp;

		return j;
	}

	void qsort(int a[],int l, int r)
	{
		if(l<r)
		{
			int m = partArr(a,l,r);
			qsort(a,l,m-1);
			qsort(a,m+1,r);
		}
	}

	void plotgraph(int a[]) throws IOException
        {
                File file = new File("plotzz.txt");
                FileWriter wr = new FileWriter(file);
                BufferedWriter bf = new BufferedWriter(wr);
                bf.write("titleText: Sort algorithm analysis\n");
                bf.write("XunitText: problem size\n");
                bf.write("YunitText: Time taken in sec\n");
                for(int i=5000; i<MAX;i+=100)
                {
                        readArr(a,i);
                        double timebefore = System.currentTimeMillis();
                        qsort(a,0,i-1);
                        double timeafter = System.currentTimeMillis();
                        double timespent = (timeafter - timebefore)*Math.pow(10,-3);
                        bf.write(i +" "+timespent+"\n");
                }
                bf.close();
                Process p = Runtime.getRuntime().exec("xgraph plotzz.txt");
                BufferedReader bf1 = new BufferedReader(new InputStreamReader(p.getInputStream()));
                while ((s = bf1.readLine())!=null)
                        System.out.println(s);

                bf1.close();
        }



	public static void main(String args[]) throws IOException
	{
		quicksort obj = new quicksort();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("\nEnter array size: ");
		int num = sc.nextInt();
		System.out.println("\nEnter elements: ");
		for(int i=0;i<num;i++)
			obj.a[i]=sc.nextInt();

		obj.qsort(a,0,num-1);
		System.out.println("\nSorted elements: \n");
		for(int i=0;i<num;i++)
			System.out.println("\n"+obj.a[i]);

		System.out.println("\nPlotting graph...");
		obj.plotgraph(a);
	}

}

