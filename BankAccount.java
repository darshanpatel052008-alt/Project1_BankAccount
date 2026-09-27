import java.util.ArrayList;
public class BankAccount{


private String accountNumber;
private String accountHolderName; 
private double balance;
private ArrayList<Transaction> transactions;


public BankAccount( String accountNumber, String accountHolderName, double balance)
{

    if(Math.abs(balance * 100 - Math.round(balance * 100)) > 0.0001)
    {
         throw new IllegalArgumentException("Error: Balance cannot have more than 2 decimal places!");
         
    }
    else
    {
         this.accountNumber = accountNumber;
         this.accountHolderName = accountHolderName;
         this.balance = balance;
    }

    transactions = new ArrayList<Transaction>();
}

public String getAccountNumber()
{
   return accountNumber;
}

public String getAccountHolderName()
{
    return accountHolderName;
}

public double getBalance()
{
    return balance; 
}

public ArrayList<Transaction> getTransactions()
{
    return transactions;
}


public boolean deposit(double amount)
{
   
   
    if(amount < 0)
    {
       return false;  
    }

    if(Math.abs(amount * 100 - Math.round(amount * 100)) > 0.0001)
    {
         throw new IllegalArgumentException("Error: Deposit amount cannot have more than 2 decimal places!");
         
    }

    else
    {
        balance += amount;
        transactions.add(new Transaction("DEPOSIT:", amount));
        return true;
        
    }
    
}

public boolean withdraw(double amount)
{

     if(Math.abs(amount * 100 - Math.round(amount * 100)) > 0.0001)
    {
         throw new IllegalArgumentException("Error: Withdrwal amount cannot have more than 2 decimal places!");
         
    }
     else if(amount < 0 || getBalance()-amount <0)
    {
        return false; 
    }

    else
    {
        balance-=amount;
        transactions.add(new Transaction("WITHDRAWAL:", amount));
        return true;
    }
}


public boolean transfer(BankAccount targetAccount, double amount)
{
     if(Math.abs(amount * 100 - Math.round(amount * 100)) > 0.0001)
    {
         throw new IllegalArgumentException("Error: Transfer amount cannot have more than 2 decimal places!");
         
    }
     else if(amount < 0 || getBalance()-amount <0)
    {
        return false; 
    }

    else
    {
        balance-=amount;
        targetAccount.balance += amount;
        transactions.add(new Transaction("TRANSFER OUT:", amount));
        targetAccount.transactions.add(new Transaction("TRANSFER IN:", amount));
        return true;
    }
        
}


public void transactionHistory()
{
    for(Transaction transaction : transactions)
    {
        System.out.println(transaction);
    }
}

























}