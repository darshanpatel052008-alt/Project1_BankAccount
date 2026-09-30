# Bank Account & Transaction System

A modular, object-oriented Java application that models core banking operations, account state management, and transaction history auditing.

## Key Features

- **Account Encapsulation:** Protects internal balance and holder details using strict field visibility and state validation.
- **Transaction Auditing:** Automatically logs deposits, withdrawals, and transfers in chronological order using an internal `ArrayList`.
- **Inter-Account Transfers:** Safely transfers funds between accounts while generating atomic source and target audit records.
- **Console Interface:** Interactive CLI built with `Scanner` that validates user inputs and prevents runtime crashes.

## Tech Stack

- **Language:** Java (JDK 17+)
- **Version Control:** Git & GitHub
- **IDE:** Visual Studio Code

## Project Structure

```text
Project1_BankAccount/
├── BankAccount.java     # Core domain logic, balance checks, and transaction storage
├── Transaction.java     # Transaction data model and formatting
├── Main.java            # Interactive console loop and user input handling
├── .gitignore           # Excludes compiled .class files
└── README.md            # Project documentation


## How to Run

1. Clone the repository:
   ```bash
   git clone https://github.com/darshanpatel052008-alt/Project1_BankAccount.git
Navigate to the project directory:

Bash
cd Project1_BankAccount
Compile all Java source files:

Bash
javac *.java
Run the application:

Bash
java Main