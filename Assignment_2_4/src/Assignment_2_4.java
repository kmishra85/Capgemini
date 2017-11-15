
import java.util.Scanner;


public class Assignment_2_4 {
	
	static void acceptDetails(Person p)
	{
			Scanner sc = new Scanner(System.in);
		System.out.println("First Name:");
		String fName= sc.next();
		p.setFirstName(fName);
		System.out.println("Last Name:");
		String lName= sc.next();
		p.setLastName(lName);
		System.out.println("Gender:");
		char gender= sc.next().charAt(0);
		p.setGender(gender);
		sc.close();
	}
	
	static void display(Person p)
	{
		System.out.println("\nPerson Details");
		System.out.println("\n_____________________\n");
		System.out.println("First Name:"+p.getFirstName()+"\n"+"Last Name:"+p.getLastName()+"\n"+"Gender:"+p.getGender());
		
	}
	
	
	public static void main(String[] args) {
		
		Person p = new Person();
		Assignment_2_4.acceptDetails(p);
		Assignment_2_4.display(p);
		
	
		
		
	}
}
