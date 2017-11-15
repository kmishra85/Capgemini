import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String choice="";
		ArrayList<String> a1=new ArrayList<String>();
		Scanner sc=new Scanner(System.in);
	
		System.out.println("\nEnter array elements:\n");
	
		do{
			a1.add(sc.next());
			System.out.println("\nWant to add more(yes/no)?\n");
			choice=sc.next();
		/*	if(choice.equalsIgnoreCase("yes"))
			{
				continue;
			}
			else
			{
				break;
			} */
		}while(choice.equalsIgnoreCase("yes"));
	
		Iterator<String> itr=a1.iterator();
		while(itr.hasNext())
		{
			String s=(String)itr.next();
			System.out.println(s);
		}
		
		Collections.sort(a1);
	
		System.out.println("\nArray after sorting is:\n");

		for(String out:a1)
		{
			System.out.println(out);
		}
		
		sc.close();
	}

}
