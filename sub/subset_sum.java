
import java.util.Scanner;

public class subset_sum
{
	public static int n, d, cnt;
	public static int[] arr, x;

	public static void initialize()
	{
		for (int i = 0; i < n; i++)
			x[i] = -1;
	}
	public static void find_subsets(int s, int k, int sum)
	{
		x[k] = 1;
		if (s + arr[k] == d)
        {
			System.out.print("\nSolution " + cnt + ": { ");
			for (int i = 0; i < n; i++)
				if (x[i] == 1)
					System.out.print(arr[i] + ", ");
			System.out.println("\b\b }");
			cnt++;
		}
		 if (k < n - 1) {
			if (s + arr[k] + arr[k + 1] <= d) {
				find_subsets(s + arr[k], k + 1, sum - arr[k]);
			}
			if (s + sum - arr[k] >= d && s + arr[k + 1] <= d) {
				x[k] = 0;
				find_subsets(s, k + 1, sum - arr[k]);
			}
		}
		x[k] = 0;
	}
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("\nWELCOME:\n");
		System.out.print("Enter:-\n Number of Elements: ");
		n = sc.nextInt();
		arr = new int[n];
		x = new int[n];
		System.out.print(" Elements (In Ascending Order): ");
		for (int i = 0; i < n; i++)
		{
			arr[i] = sc.nextInt();
		}
		System.out.print(" Required Sum: ");
		d = sc.nextInt();
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += arr[i];
		}
		if (arr[0] > d || sum < d) {
			System.out.println("\nSolution Doesn't Exist\n");
			return ;
		}
		else
		{
			initialize();
			cnt = 1;
			find_subsets(0,0,sum);
		}

		if (cnt == 1)
			System.out.println("\nSolution Doesn't Exist\n");
		else
			System.out.println();
	}
}
