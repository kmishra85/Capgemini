import java.util.Scanner;

public class Assignment_3_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String str="";
		int n=0,m=0;
		System.out.println("Enter the string");
		str=sc.nextLine();
		int l=str.length();
		String newstr=str.toUpperCase();
		for(int i=0;i<l-1;i++)
		{
			char ch=newstr.charAt(i);
			char ch1=newstr.charAt(i+1);
			if(ch<=ch1)
				n=1;
			else
				m=1;
		}
		if(n==1 && m==1)
		System.out.println("negative");
		else
			System.out.println("positive");
		sc.close();	
	}

}