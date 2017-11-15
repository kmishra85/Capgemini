import java.util.Arrays;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n;
		Scanner sc=new Scanner(System.in);
		System.out.println("\nEnter the number of strings in array:\n");
		n=sc.nextInt();
		String a[]= new String[n];
		System.out.println("\nEnter array elements:\n");
		for(int i=0;i<n;i++)
		{
			a[i]=sc.next();
		}
		Arrays.sort(a);
		System.out.println("\nArray after sorting is:\n");
		for(int i=0;i<n;i++)
		{
			System.out.println(a[i]);
		}
		sc.close();
	}

}
