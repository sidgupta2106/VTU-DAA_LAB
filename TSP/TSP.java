import java.util.*;
class TSP
{
    static int g[][] = new int [10][10];
    static int v[] = new int [10];
    static int n;
    
    void getNext(int n)
    {
        int i, j;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the weighted matrix");
        
        for(i=0;i<n;i++)
            for(j=0;j<n;j++)
                g[i][j]=in.nextInt();
                
        for(i=0;i<n;i++)
            v[i]=0;
    }
    
    int tsp(int s)
    {
        int i, j, ans, count=0;
        ans = Integer.MAX_VALUE;
        
        for(j=0;j<n;j++)
        {
            if(v[j]==1)
                count++;
        }
        
        if (count==n)
            return g[s][0];
            
        for(i=0;i<n;i++)
        {
            if(v[i]==0)
            {
                v[i]=1;
                int nextans = g[s][i]+tsp(i);
                ans = Math.min(ans, nextans);
                v[i]=0;
            }
        }
        
        return ans;
    }
    
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        TSP obj = new TSP();
        int s;
        System.out.println("Enter the order of the matrix");
        n=in.nextInt();
        obj.getNext(n);
        System.out.println("Enter the source vertex");
        s=in.nextInt();
        int a = obj.tsp(s);
        
        System.out.println("The cost of the shortest path is " +a);
    }
}

       