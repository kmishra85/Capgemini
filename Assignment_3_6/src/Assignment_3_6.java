import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Scanner;


public class Assignment_3_6 {
	
	
	static void display(String zoneId)
	{
		String id=zoneId;
		
		if(id.equalsIgnoreCase("America/New_York"))
		{
			ZonedDateTime america= ZonedDateTime.now(ZoneId.of("America/New_York"));
			System.out.println("America:"+america);
		}
		else if(id.equalsIgnoreCase("Europe/London"))
		{
			ZonedDateTime europe= ZonedDateTime.now(ZoneId.of("Europe/London"));
			System.out.println("Europe:"+europe);
		}
		else if(id.equalsIgnoreCase("Asia/Tokyo"))
		{
			ZonedDateTime asia= ZonedDateTime.now(ZoneId.of("Asia/Tokyo"));
			System.out.println("Asia:"+asia);
		}
		else if(id.equalsIgnoreCase("Africa/Cairo"))
		{
			ZonedDateTime africa= ZonedDateTime.now(ZoneId.of("Africa/Cairo"));
			System.out.println("Africa:"+africa);
		}
		else if(id.equalsIgnoreCase("Australia/Sydney"))
		{
			ZonedDateTime australia= ZonedDateTime.now(ZoneId.of("Australia/Sydney"));
			System.out.println("Australia:"+australia);
		}
	
		else
		{
			System.out.println("\nEnter a valid zone id\n");
		
			
		}
		
		
		
	}
	

	public static void main(String[] args) {
		
	String zoneid;
	Scanner sc= new Scanner(System.in);
	System.out.println("\nEnter the Zone id:\n");
	System.out.println("\n1.America/New_York\n2.Europe/London\n3.Asia/Tokyo\n4.Africa/Cairo"
			+ "\n5.Australia/Sydney\n6.India");
	zoneid=sc.next();
	Assignment_3_6.display(zoneid);
	
	sc.close();
	
	}
}
