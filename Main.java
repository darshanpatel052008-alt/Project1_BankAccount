
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main 
{
private static ArrayList<BankAccount> accounts = new ArrayList<>();
    private static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
       
        int choice = 0;

        while (choice != 7) {
            printMenu();
            try {
                choice = scan.nextInt();
                }

            catch (InputMismatchException e) {
                System.out.println("\nError: Choice must be a integer 1-7");
                scan.nextLine();
                          
            }

            switch(choice)
            {
                case 1 -> createAccount();
                case 2 -> makeDeposit();
                
            }

        }
    }

    private static void printMenu() {
        System.out.print("\n========================================\n" +
                "       BANK ACCOUNT SYSTEM MENU         \n" +
                "========================================\n" +
                "1. Create Account\n" +
                "2. Deposit\n" +
                "3. Withdraw\n" +
                "4. Transfer\n" +
                "5. Print Transaction History\n" +
                "6. View Account Details\n" +
                "7. Exit\n" +
                "----------------------------------------\n" +
                "Enter choice: ");
    }


    private static void createAccount()
    {
        double deposit = 0; 
       System.out.print("Enter Account Number: ");
       String accountNumber = scan.nextLine();

       scan.nextLine();
    
       System.out.print("Enter Account Holder Name: ");
       String accountHolderName = scan.nextLine();
      

       System.out.print("Enter Initial Deposit: ");
       try
       {
         deposit = scan.nextDouble();
       }

         catch (InputMismatchException e) {
                System.out.println("\nError: Initial Deposit must be a vaild positive number (no units)");
                scan.nextLine();
                return;
            }

       BankAccount bankAccount = new BankAccount(accountNumber, accountHolderName, deposit);
        accounts.add(bankAccount);
        
        System.out.println("\nSUCCESS: Account " + accountNumber + "created for " + accountHolderName + " with balance $" + deposit);
    }


    private static BankAccount findAccount(String accountNumber) {
    for (BankAccount acc : accounts) {
        if (acc.getAccountNumber().equalsIgnoreCase(accountNumber)) {
            return acc; 
        }
    }
    return null;
    }

    private static void makeDeposit()
    {
      double deposit = 0; 
       System.out.print("Enter Account Number: ");
       String accountNumber = scan.nextLine();
       scan.nextLine();
         
       
       if(findAccount(accountNumber) == null)
       {
        System.out.println("\nError: Can't find Account Number in the system.");
        return;

       }

        System.out.print("Enter Deposit: ");
       try
       {
         deposit = scan.nextDouble();
       }

         catch (InputMismatchException e) {
                System.out.println("\nError: Deposit must be a vaild positive number (no units)");
                scan.nextLine();
                return;
            }
          findAccount(accountNumber).deposit(deposit);

       System.out.println("\nSUCCESS: Deposited $" + deposit + " New Balance: $" + findAccount(accountNumber).getBalance());
       
    }



}
