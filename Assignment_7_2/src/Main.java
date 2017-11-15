import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		ArrayList<String> a1=new ArrayList<String>();
		Scanner sc=new Scanner(System.in);
		System.out.println("\nEnter the number of strings in array:\n");
		int n=sc.nextInt();
		System.out.println("\nEnter array elements:\n");
		for(int i=0;i<n;i++)
		{
			a1.add(sc.next());
		}
		Collections.sort(a1);
		System.out.println("\n");
		System.out.println("\nArray after sorting is:\n");
		System.out.println("\n");
		for(String out:a1)
		{
			System.out.println(out);
		}
		
		sc.close();
	}

}
