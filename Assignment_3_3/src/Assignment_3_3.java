import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;



public class Assignment_3_3 {

	
	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		
		System.out.println("\nEnter the date in dd/MM/yyyy\n");
		String text=sc.next();
		DateTimeFormatter dtf= DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate start= LocalDate.parse(text, dtf);
		LocalDate end= LocalDate.now();
		Period period=start.until(end);
		
		
		System.out.println("\nDays:"+period.get(ChronoUnit.DAYS));
		System.out.println("\nMonths:"+period.get(ChronoUnit.MONTHS));
		System.out.println("\nYears:"+period.get(ChronoUnit.YEARS));
	
	sc.close();
	}

	
}
