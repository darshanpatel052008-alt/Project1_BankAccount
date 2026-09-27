public class Transaction {
    
private String type; 
private double amount; 


public Transaction(String type, double amount)
{
    this.type = type;
    this.amount = amount;

    String text =Double.toString(amount);

    int index = text.indexOf(".");
    
    if(text.length()-1 - index > 2)
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
    return type.toUpperCase() + ":" + "$" + amount;
 }







}
