import java.util.HashMap;
import java.util.Scanner;

public class BankingSystem {

    static class Account {
        String name;
        double balance;

        Account(String name, double initialDeposit) {
            this.name = name;
            this.balance = initialDeposit;
        }

        void deposit(double amount) {
            if (amount > 0) {
                balance += amount;
                System.out.println("Successfully deposited: RM" + amount);
            } else {
                System.out.println("Invalid deposit amount.");
            }
        }

        void withdraw(double amount) {
            if (amount > 0 && amount <= balance) {
                balance -= amount;
                System.out.println("Successfully withdrew: RM" + amount);
            } else if (amount > balance) {
                System.out.println("Insufficient balance.");
            } else {
                System.out.println("Invalid withdrawal amount.");
            }
        }

        void viewDetails() {
            System.out.println("Account Holder: " + name);
            System.out.println("Balance: RM" + balance);
        }
    }

    public static void main(String[] args) {
        HashMap<Integer, Account> accounts = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        int accountNumberCounter = 1;

        while (true) {
            System.out.println("\nBanking System");
            System.out.println("1. Create Account");
            System.out.println("2. View Account");
            System.out.println("3. Deposit Money");
            System.out.println("4. Withdraw Money");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter your name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter initial deposit: RM");
                    double initialDeposit = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline

                    Account newAccount = new Account(name, initialDeposit);
                    accounts.put(accountNumberCounter, newAccount);
                    System.out.println("Account created successfully! Your account number is: " + accountNumberCounter);
                    accountNumberCounter++;
                    break;

                case 2:
                    System.out.print("Enter account number: ");
                    int accountNumber = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    Account account = accounts.get(accountNumber);
                    if (account != null) {
                        account.viewDetails();
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter account number: ");
                    accountNumber = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    account = accounts.get(accountNumber);
                    if (account != null) {
                        System.out.print("Enter deposit amount: RM");
                        double depositAmount = scanner.nextDouble();
                        scanner.nextLine(); // Consume newline
                        account.deposit(depositAmount);
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter account number: ");
                    accountNumber = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    account = accounts.get(accountNumber);
                    if (account != null) {
                        System.out.print("Enter withdrawal amount: RM");
                        double withdrawalAmount = scanner.nextDouble();
                        scanner.nextLine(); // Consume newline
                        account.withdraw(withdrawalAmount);
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 5:
                    System.out.println("Thank you for using the Banking System. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
