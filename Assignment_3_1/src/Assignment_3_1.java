import java.util.Scanner;	





public class Assignment_3_1 {

	public static void main(String[] args) {
		
		String str1,res;
		int choice;
		Scanner sc= new Scanner(System.in);
		System.out.println("\nEnter the String");
		str1=sc.next();
		System.out.println("\nEnter yourchoice:");
		System.out.println("1.Add the string to itself\n2.Replace the odd position with #\n"
				+ "3.remove the duplicate character in string\n.change the odd character to upper case\n"
				+ "Enter your choice\n");
		choice=sc.nextInt();
		res=Assignment_3_1.operations(str1,choice);
		System.out.println("Output:\n"+res);
		
		sc.close();
		
	}
	
	
	
	static String operations(String str1,int choice)
	{
	
		String str=str1;
		
		switch(choice){
		case 1:
			   str=str.concat(str);
			   break;
		case 2:
			   for(int i=0;i<str.length()-1;i++){
				   if((i+1)%2!=0){
					   str=str.replace(str.charAt(i),'#');   
				   }
				      
			   }
			   break;
		case 3:
			StringBuffer b=new StringBuffer(str);
				for(int i=0;i<b.length()-1;i++)
				{
					for(int j=1;j<b.length();j++)
					{
						if(b.charAt(i)==b.charAt(j))
						{
							b.deleteCharAt(j);
						}
					}
				}
				str=b.toString();
			//System.out.println(b);
				break;
		case 4:
				String newstr="";
				for(int i=0;i<str.length();i++)
				{
					char ch=str.charAt(i);
					if((i)%2!=0)
					
						newstr=newstr+ch;
					
					else
					newstr=newstr+Character.toUpperCase(ch);
	
				}
				str=newstr;
				break;
			
			 
		default:
				System.out.println("\nEnter a valid choice\n");
			  
		
		}
		return str;
	}



}

