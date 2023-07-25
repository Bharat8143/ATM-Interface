import java.util.Scanner;
import java.util.ArrayList;

public class ATMInterface {
    public static Scanner sc = new Scanner(System.in);
    public static ArrayList<String> list = new ArrayList<>();
    public static int balance = 5000;

    public static void main(String[] args) {
        System.out.println("----------------");
        System.out.println("-Welcome to ATM-");
        System.out.println("----------------");
        System.out.println("---Login!---");
        login();
    }
    public static void login() {
        System.out.print("Enter Your Username : ");
        String username = sc.next();
        System.out.print("Enter Your PIN : ");
        int pin = sc.nextInt();

        if (username.equals("Bharat") && pin == 9876) {
            System.out.println("Successfully Logged In");
            showOptions();
        } else {
            System.out.println("Sorry you Entered Invalid Username or PIN. Try again!");
            login();
        }
    }
    public static void showOptions() {
        System.out.println("1.Withdraw");
        System.out.println("2.Deposit");
        System.out.println("3.Transfer");
        System.out.println("4.Transaction History");
        System.out.println("5.Quit");
        System.out.print("Choose any action: ");
        int ourchoice = sc.nextInt();
        System.out.println();

        switch (ourchoice) {
            case 1 -> Withdraw();
            case 2 -> Deposit();
            case 3 -> Transfer();
            case 4 -> TransactionHistory();
            case 5 -> Quit();
            default -> {
                System.out.println("Invalid choice. Try again!");
                showOptions();
            }
        }
    }
    public static void Withdraw() {
        System.out.print("Enter amount to be withdrawn: ");
        int amount = sc.nextInt();

        if (amount > 0 && amount <= balance) {
            balance -= amount;
            list.add(amount + " Rupees Withdrawn.");
            System.out.println("Transaction successful. Current balance is " + balance);
        } else {
            System.out.println("Invalid amount. Try again!");
        }
        System.out.println();
        showOptions();
    }
    public static void Deposit() {
        System.out.print("Enter Your Amount to be Deposited: ");
        int amount = sc.nextInt();

        if (amount > 0) {
            balance += amount;
            list.add(amount + " Rupees Deposited.");
            System.out.println("Transaction successful. Current balance is " + balance);
        } else {
            System.out.println("Invalid amount. Try again!");
        }
        System.out.println();
        showOptions();
    }
    public static void Transfer() {
        System.out.print("Enter Recipient's Username: ");
        String recipient = sc.next();
        System.out.print("Enter Amount to be Transferred: ");
        int amount = sc.nextInt();

        if (amount > 0 && amount <= balance) {
            balance -= amount;
            list.add(amount + " Rupees transferred to account " + recipient);
            System.out.println(amount + " Rupees sent to " + recipient);
            System.out.println("Transaction successful. Current balance is " + balance);
        } else {
            System.out.println("Invalid amount. Try again!");
        }
        System.out.println();
        showOptions();
    }
    public static void TransactionHistory() {
        System.out.println("---Transaction History!---");
        for (String transaction : list) {
            System.out.println(transaction);
        }
        System.out.println();
        showOptions();
    }
    public static void Quit() {
        System.out.print("Do you want to exit? (YES/NO): ");
        String response = sc.next();

        if (response.equalsIgnoreCase("YES")) {
            System.out.println("---------------Logged out---------------");
            System.exit(0);
        } else {
            System.out.println();
            showOptions();
        }
    }
}
