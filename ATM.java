import java.text.DecimalFormat;
import java.util.Scanner;
class BankAccount {
    private double balance;
    private String accountNumber;
    private String pin;

    public BankAccount(String accountNumber, String pin, double initialBalance) {
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public boolean validatePin(String enteredPin) {
        if(enteredPin.length()==4) {
            return true;
        }
        return false;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            String patten="#,##,###.00";
            DecimalFormat format=new DecimalFormat(patten);
            System.out.println("Deposit successful. New balance: $" +format.format( balance));
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    public boolean withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
            return false;
        }
        if (balance >= amount) {
            balance -= amount;
            String patten="#,##,###.00";
            DecimalFormat format=new DecimalFormat(patten);
            System.out.println("Withdrawal successful. New balance: $" +format.format(balance));
            return true;
        } else {
            System.out.println("Insufficient balance for withdrawal.");
            return false;
        }
    }
}


class ATM {
    private BankAccount currentAccount;
    public ATM() {
        this.currentAccount = null;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the ATM!");

        // Simulate a login process
        System.out.print("Enter account number: ");
        String enteredAccountNumber = scanner.nextLine();
        System.out.print("Enter PIN: ");
        String enteredPin = scanner.nextLine();


        BankAccount checkAccount = new BankAccount(enteredAccountNumber, enteredPin, 1000.00);

        if (enteredAccountNumber.equals(checkAccount.getAccountNumber()) && checkAccount.validatePin(enteredPin)) {
            this.currentAccount = checkAccount;
            System.out.println("Login successful!");
            showMainMenu(scanner);
        } else {
            System.out.println("Invalid account number or PIN. Exiting.");
        }

        scanner.close();
    }


    private void showMainMenu(Scanner scanner) {
        int choice;
        do {
            System.out.println("\nATM Main Menu:");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number (1-4):");
                scanner.next(); // Consume the invalid input
                System.out.print("Enter your choice: ");
            }
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    withdraw(scanner);
                    break;
                case 2:
                    deposit(scanner);
                    break;
                case 3:
                    checkBalance();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);
    }


    private void withdraw(Scanner scanner) {
        System.out.print("Enter amount to withdraw: $");

        while (!scanner.hasNextDouble()) {
            System.out.println("Invalid input. Please enter a valid amount:");
            scanner.next();
            System.out.print("Enter amount to withdraw: $");
        }
        double amount = scanner.nextDouble();
        if (currentAccount != null) {
            currentAccount.withdraw(amount);
        } else {
            System.out.println("No account logged in.");
        }
    }

    private void deposit(Scanner scanner) {
        System.out.print("Enter amount to deposit: $");
        while (!scanner.hasNextDouble()) {
            System.out.println("Invalid input. Please enter a valid amount:");
            scanner.next();
            System.out.print("Enter amount to deposit: $");
        }
        double amount = scanner.nextDouble();
        if (currentAccount != null) {
            currentAccount.deposit(amount);
        } else {
            System.out.println("No account logged in.");
        }
    }

    private void checkBalance() {
        if (currentAccount != null) {
            String patten="#,##,###.00";
            DecimalFormat format=new DecimalFormat(patten);
            System.out.println("Your current balance is: $" +format.format(currentAccount.getBalance()));
        } else {
            System.out.println("No account logged in.");
        }
    }

    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.start();
    }
}
