import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<BankAccount> accounts = new ArrayList<>();
    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
       
      
        int choice = 0;

        while (choice != 7) {
            printMenu();
            try {
                // Read full line as String, then parse as integer
                choice = Integer.parseInt(scan.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("\nError: Choice must be an integer");
                continue;
            }

            switch (choice) {
                case 1 -> createAccount();
                case 2 -> makeDeposit();
                case 3 -> makeWithdrawal();
                case 4 ->  makeTransfer();
                case 5-> transactionHistory();
                case 6-> accountDetails();
                case 7 -> System.out.println("Exiting program. Goodbye!");
                default -> System.out.println("Invalid choice. Enter 1-7.");
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

    private static void createAccount() {
        System.out.print("Enter Account Number: ");
        String accountNumber = scan.nextLine().trim();

        System.out.print("Enter Account Holder Name: ");
        String accountHolderName = scan.nextLine().trim();

        System.out.print("Enter Initial Deposit: ");
        double deposit = 0;
        try {
            deposit = Double.parseDouble(scan.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("\nError: Initial Deposit must be a valid positive number (no units)");
            return;
        }

        BankAccount bankAccount = new BankAccount(accountNumber, accountHolderName, deposit);
        accounts.add(bankAccount);

        System.out.println("\nSUCCESS: Account " + accountNumber + " created for " + accountHolderName + " with balance $" + deposit);
    }

    private static BankAccount findAccount(String accountNumber) {
        for (BankAccount acc : accounts) {
            if (acc.getAccountNumber().equalsIgnoreCase(accountNumber)) {
                return acc;
            }
        }
        return null;
    }

    private static void makeDeposit() {
        System.out.print("Enter Account Number: ");
        String accountNumber = scan.nextLine().trim();

        BankAccount account = findAccount(accountNumber);
        if (account == null) {
            System.out.println("\nError: Can't find Account Number in the system.");
            return;
        }

        System.out.print("Enter Deposit: ");
        double deposit = 0;
        try {
            deposit = Double.parseDouble(scan.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("\nError: Deposit must be a valid positive number (no units)");
            return;
        }

        account.deposit(deposit);
        System.out.println("\nSUCCESS: Deposited $" + deposit + " New Balance: $" + account.getBalance());
    }


private static void makeWithdrawal() {
        System.out.print("Enter Account Number: ");
        String accountNumber = scan.nextLine().trim();

        BankAccount account = findAccount(accountNumber);
        if (account == null) {
            System.out.println("\nError: Can't find Account Number in the system.");
            return;
        }

        System.out.print("Enter WithDrawal Amount: ");
        double withdrawal = 0;
        try {
            withdrawal = Double.parseDouble(scan.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("\nError: WithDrawal must be a valid positive number (no units)");
            return;
        }

        boolean status = account.withdraw(withdrawal);
       
        if(!status)
        {
          System.out.println("ERROR: Transaction rejected. Insufficient funds or invalid amount!");
          System.out.println("Current Balance: $" + account.getBalance());
          return;
        }
        System.out.println("\nSUCCESS: Withdrew $" + withdrawal + " New Balance: $" + account.getBalance());
    }

  private static void makeTransfer() {
        System.out.print("Enter Source Account Number: ");
        String sourceNumber = scan.nextLine().trim();

        BankAccount account = findAccount(sourceNumber);
        if (account == null) {
            System.out.println("\nError: Can't find Source Account Number in the system.");
            return;
        }

        System.out.print("Enter Target Account Number: ");
        String targetNumber = scan.nextLine().trim();

        BankAccount account2 = findAccount(targetNumber);
        if (account2 == null) {
            System.out.println("\nError: Can't find Target Account Number in the system.");
            return;
        }

        System.out.print("Enter Transfer Amount: ");
        double transfer = 0;
        try {
            transfer = Double.parseDouble(scan.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("\nError: Transfer amount must be a valid positive number (no units)");
            return;
        }

        boolean status = account.transfer(account2, transfer);

        if(!status)
        {
             System.out.println("ERROR: Transaction rejected. Insufficient funds or invalid amount!");
              System.out.println("Current Source Balance: $" + account.getBalance());

        }
        System.out.println("\nSUCCESS: Transfered $" + transfer + " from " + sourceNumber + " to " + targetNumber);
    }

private static <Transactions> void transactionHistory()
{
    System.out.print("Enter Account Number: ");
        String accountNumber = scan.nextLine().trim();

        BankAccount account = findAccount(accountNumber);
        if (account == null) {
            System.out.println("\nError: Can't find Account Number in the system.");
            return;
        }
        System.out.println("\n=========================================");
        System.out.println("====== Transaction History for " + accountNumber + " ======");
        System.out.println("Account Holder: " + account.getAccountHolderName());

         ArrayList<Transaction> array = account. getTransactions();
       
        for(int i = 1; i<=array.size(); i++)
        {
          System.out.println(i + ". " + array.get(i-1));
        }

    System.out.println("Current Balance: $" + account.getBalance());
    System.out.println("=========================================");
}


private static void accountDetails()
{
    System.out.print("Enter Account Number: ");
        String accountNumber = scan.nextLine().trim();

        BankAccount account = findAccount(accountNumber);
        if (account == null) {
            System.out.println("\nError: Can't find Account Number in the system.");
            return;
        }

        System.out.println("\n=========================================");
        System.out.println("             ACCOUNT DETAILS             ");
        System.out.println("=========================================");
        System.out.println("Account Number: " + account.getAccountNumber());
        System.out.println("Account Holder: " + account.getAccountHolderName());
        System.out.println("Current Balance: $" + account.getBalance());
        System.out.println("=========================================");

}




}