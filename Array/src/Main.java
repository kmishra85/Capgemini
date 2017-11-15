import java.util.Arrays;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc= new Scanner(System.in);
		System.out.println("\nEnter the array size:\n");
		int n=sc.nextInt();
		int a[]=new int[n];
		System.out.println("Enter the array elements:\n");
		for(int i=0;i<a.length;i++)
		{
			a[i]=sc.nextInt();
		}
		Arrays.sort(a);
		for(int i=0;i<a.length;i++)
		{
			System.out.println("After sorted "+a[i]);
		}
		int min=a[0];
		int max=a[a.length-1];
		System.out.println("middle element "+a[n/2]);
		System.out.println("sum of smallest and greatest element"+(min+max));
		sc.close();
	}

}
