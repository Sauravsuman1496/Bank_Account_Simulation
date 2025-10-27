import java.util.ArrayList;
import java.util.Scanner;


class Account {
    private String accountHolderName;
    private String accountNumber;
    private double balance;
    private ArrayList<String> transactionHistory;

    
    public Account(String accountHolderName, String accountNumber, double initialBalance) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
        transactionHistory.add("Account created with initial balance: ₹" + initialBalance);
    }

    
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactionHistory.add("Deposited: ₹" + amount + " | Current Balance: ₹" + balance);
            System.out.println("✅ Successfully deposited ₹" + amount);
        } else {
            System.out.println("❌ Invalid deposit amount!");
        }
    }

    
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactionHistory.add("Withdrawn: ₹" + amount + " | Current Balance: ₹" + balance);
            System.out.println("✅ Successfully withdrawn ₹" + amount);
        } else if (amount > balance) {
            System.out.println("❌ Insufficient balance!");
        } else {
            System.out.println("❌ Invalid withdrawal amount!");
        }
    }

    
    public void checkBalance() {
        System.out.println("💰 Current balance: ₹" + balance);
    }

    
    public void showTransactionHistory() {
        System.out.println("\n📜 Transaction History:");
        for (String transaction : transactionHistory) {
            System.out.println("- " + transaction);
        }
    }
}


public class BankSimulation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("🏦 Welcome to Java Bank Simulation!");
        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        System.out.print("Enter account number: ");
        String accNo = sc.nextLine();

        System.out.print("Enter initial balance: ₹");
        double balance = sc.nextDouble();

        Account userAccount = new Account(name, accNo, balance);
        int choice;

        do {
            System.out.println("\n------ MENU ------");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Transaction History");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit: ₹");
                    double depositAmt = sc.nextDouble();
                    userAccount.deposit(depositAmt);
                    break;

                case 2:
                    System.out.print("Enter amount to withdraw: ₹");
                    double withdrawAmt = sc.nextDouble();
                    userAccount.withdraw(withdrawAmt);
                    break;

                case 3:
                    userAccount.checkBalance();
                    break;

                case 4:
                    userAccount.showTransactionHistory();
                    break;

                case 5:
                    System.out.println("👋 Thank you for banking with us!");
                    break;

                default:
                    System.out.println("❌ Invalid choice! Try again.");
            }

        } while (choice != 5);

        sc.close();
    }
}
