public class Transaction {
    
private String type; 
private double amount; 


public Transaction(String type, double amount)
{
    this.type = type;
    this.amount = amount;

    
    if(!type.toLowerCase().equals("deposit:") &&  !type.toLowerCase().equals("transfer_out:") &&  !type.toLowerCase().equals("withdrawal:") &&  !type.toLowerCase().equals("transfer_in:"))
    {
         throw new IllegalArgumentException("Error: Transaction can only be one of the following: Deposit, Withdrawal, Transfer_Out");
    }

    if(Math.abs(amount * 100 - Math.round(amount * 100)) > 0.0001)
    {
         throw new IllegalArgumentException("Error: Initial deposit cannot have more than 2 decimal places!");
    }
}

public double getAmount()
{
    return amount;
}

public String getType()
{
    return type;
}

 @Override

 public String toString()
 {
    return type.toUpperCase() +  " $" + amount;
 }







}
