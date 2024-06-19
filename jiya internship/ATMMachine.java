import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }
}

class ATM {
    private BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }

    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== ATM Machine =====");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    depositMoney(scanner);
                    break;
                case 3:
                    withdrawMoney(scanner);
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }

    private void checkBalance() {
        System.out.println("Your current balance is: $" + account.getBalance());
    }

    private void depositMoney(Scanner scanner) {
        System.out.print("Enter the amount to deposit: ");
        double amount = scanner.nextDouble();
        if (amount > 0) {
            account.deposit(amount);
            System.out.println("Successfully deposited $" + amount);
            System.out.println("Your new balance is: $" + account.getBalance());
        } else {
            System.out.println("Invalid amount. Please enter a positive number.");
        }
    }

    private void withdrawMoney(Scanner scanner) {
        System.out.print("Enter the amount to withdraw: ");
        double amount = scanner.nextDouble();
        if (amount > 0 && account.withdraw(amount)) {
            System.out.println("Successfully withdrew $" + amount);
            System.out.println("Your new balance is: $" + account.getBalance());
        } else if (amount > account.getBalance()) {
            System.out.println("Insufficient funds. Your current balance is: $" + account.getBalance());
        } else {
            System.out.println("Invalid amount. Please enter a positive number.");
        }
    }
}

public class ATMMachine {
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(1000.0); // Initial balance
        ATM atm = new ATM(userAccount);
        atm.displayMenu();
    }
}
