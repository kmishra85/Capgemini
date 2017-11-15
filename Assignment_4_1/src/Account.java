
import java.util.Random;
import java.util.Scanner;

public class Account extends Person{
	
	long accNum;
	static double balance=0.0;
	
	void deposite(double depositeAmount){
		double amount = depositeAmount; 
		balance = balance+amount;
		System.out.println("Balance is :"+balance);
	};
	void withdraw(double withdrawAmount){
		double amount1 = withdrawAmount;
		double minBalance = 100;
		
		if(withdrawAmount  > balance)
		{
			System.out.println("Insufficent Balance");
		}
		else
		{
			
			if(balance < minBalance )
			{
				System.out.println("Minmum Balnce should be maintained of Rs.500");
			}
			else
			{
				balance = balance - withdrawAmount;
				System.out.println("Balance After Withdraw is :"+balance+ "\n");
			}
			
		}
		
	};
	void getBalance(){
		System.out.println("Balance Amount is :"+balance+ "\n");
		
	};
	void display(String person, float age,double balance, long accNum ){
	
		
		
	}


	public String toString() {
		return "Account Details are: \naccNum=" + accNum + "\n balance=" + balance + "\n person=" + person + "\n age=" + age ;
	}
	public static void main(String[] args) {
		
		Random rn = new Random();
		Scanner in = new Scanner(System.in);
		int choice;
		
		Account Alpha = new Account();
		System.out.println("Enter the UserName:");
		Alpha.person=in.next();
		System.out.println("Enter the Age:");
		Alpha.age=in.nextFloat();
		//System.out.println("Enter the AcountNumber");
		Alpha.accNum=rn.nextInt(1000);
	
		
		

		
		do{
			System.out.println("Enter Your Choice\n 1.Deposit\n 2.Withdraw\n 3.Get Details\n 4.Exit\n");
			choice = in.nextInt();
			switch(choice){  
		 	
		    case 1: 
		    	System.out.println("Enter the Amount to be \n");
		    	double Money = in.nextDouble();
		    	Alpha.deposite(Money);
		    break;  
		    case 2: 
		    	System.out.println("Enter Amount to be Withdrawn\n");
		    	double Money1 = in.nextDouble();
		    	Alpha.withdraw(Money1);
		    break;  
		    case 3:
		    	Alpha.getBalance();
		    	System.out.println(Alpha);
		    break;
		    case 4: 
		    	
		    break;
		    default:System.out.println("Ivalid option");  
		 	}
		
		}
		while(choice != 4);
		
		in.close();
		
		
	}

}