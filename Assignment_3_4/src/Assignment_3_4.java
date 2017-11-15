import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;



public class Assignment_3_4 {

	
	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		
		System.out.println("\nEnter the date in dd/MM/yyyy\n");
		String text1=sc.next();
		DateTimeFormatter dtf1= DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate start= LocalDate.parse(text1, dtf1);
		
		System.out.println("\nEnter the date in dd/MM/yyyy\n");
		String text2=sc.next();
		DateTimeFormatter dtf2= DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate end= LocalDate.parse(text2, dtf2);
		
		Period period=start.until(end);
		
		
		System.out.println("\nDays:"+period.get(ChronoUnit.DAYS));
		System.out.println("\nMonths:"+period.get(ChronoUnit.MONTHS));
		System.out.println("\nYears:"+period.get(ChronoUnit.YEARS));
	
	sc.close();
	}

	
}
