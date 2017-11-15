import java.util.Scanner;

enum gender1
{	
	M,F;
}


public class EnumPerson {
	
	static String fName="Divya";
	static String lName="Bharati";
	static char gender;
	static gender1 val;
	static int weigth=20;
	static double age=85.5;
	
	static void display()
	{
		System.out.println("\nPerson Details");
		System.out.println("\n____________________________");
		System.out.println("\nFirst Name: "+fName+"\nLast Name: "+lName+"\nGender: "+val+"\nAge: "+age+"\nWeigth: "+weigth);
	}
	
	public static void main(String[] args) {
		
		Scanner s= new Scanner(System.in);
		System.out.println("\nEnter First Name:\n");
		EnumPerson.fName=s.next();
		System.out.println("\nEnter Last Name:\n");
		EnumPerson.lName=s.next();
		System.out.println("\nEnter gender (M/F?):\n");
		EnumPerson.gender=s.next().charAt(0);
		if(gender=='M')
			 val=gender1.M;
		else
			val=gender1.F;
		
		System.out.println("\nEnter Weigth:\n");
		EnumPerson.weigth=s.nextInt();
		System.out.println("\nEnter Age:\n");
		EnumPerson.age=s.nextDouble();
		EnumPerson.display();
		s.close();
	}

}
