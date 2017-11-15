import java.util.Scanner;


public class Student {
	
	static String fName;
	static String lName;
	static char gender;
	static int weigth;
	static double age;
	
	static void display()
	{
		System.out.println("\nPerson Details");
		System.out.println("\n____________________________");
		System.out.println("\nFirst Name: "+fName+"\nLast Name: "+lName+"\nGender: "+gender+"\nAge: "+age+"\nWeigth: "+weigth);
	}
	
	public static void main(String[] args) {
		
		Scanner s= new Scanner(System.in);
		System.out.println("\nEnter First Name:\n");
		Student.fName=s.next();
		System.out.println("\nEnter Last Name:\n");
		Student.lName=s.next();
		System.out.println("\nEnter Gender:\n");
		Student.gender=s.next().charAt(0);
		System.out.println("\nEnter Weigth:\n");
		Student.weigth=s.nextInt();
		System.out.println("\nEnter Age:\n");
		Student.age=s.nextDouble();
		Student.display();
		s.close();
	}

}
