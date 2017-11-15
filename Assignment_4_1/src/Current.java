public class Current extends Account{
	double withDrawalLimit = 1000;
	
	final void withdraw(double withdrawAmount){
		
		if(withdrawAmount  > balance)
		{
			System.out.println("Insufficent Balance");
		}
		else
		{
			
			if(balance > withDrawalLimit )
			{
				System.out.println("Yo!! Withdrawal Limit Exceeded");
			}
			else
			{
				balance = balance - withdrawAmount;
				System.out.println("Balance After Withdraw is :"+balance+ "\n");
			}
			
		}
		
		
	}
}