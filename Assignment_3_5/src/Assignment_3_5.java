import java.time.LocalDate;

import java.time.format.DateTimeFormatter;

import java.util.Scanner;



public class Assignment_3_5 {

	
	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		
		System.out.println("\nEnter the date for purchase in MM/yyyy\n");
		String text1=sc.next();
	
		System.out.println("\nEnter the date for warranty in MM\n");
		String text2=sc.next();
		
		
	
		
		int months=Integer.parseInt(text2);
		DateTimeFormatter dft=DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate start=LocalDate.parse(text1, dft);
		System.out.println("\nYour product will expire on:\n");
		
		System.out.println(start.plusMonths(months));
	
	sc.close();
	}

	
}
