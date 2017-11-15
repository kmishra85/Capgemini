public class Savings extends Account {
 	
 	double minBalance = 1000;
 	
 	final void withdraw(double withdrawAmount){
 		
 		if(withdrawAmount  > balance)
 		{
 			System.out.println("Insufficent Balance");
 		}
 		else
 		{
 			
 			if(balance < minBalance )
 			{
				System.out.println("Minmum Balnce should be maintained of Rs 1000");
 			}
 			else
 			{
 				
 				balance = balance - withdrawAmount;
 				System.out.println("Balance After Withdraw is :"+balance+ "\n");
 			}
 			
 		}
 		
 		
 	}
 
 }