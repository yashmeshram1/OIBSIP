import java.util.Scanner;

class ATM {
    float Balance;
    int PIN = 73216;
    String transactionHistory = "";

    public void checkpin() {
        System.out.println("Welcome to ATM Machine ");
        System.out.println("Enter Your PIN :->  ");
        Scanner sc = new Scanner(System.in);
        int pin = sc.nextInt();
        if (pin == PIN) {
            menu();
        } else {
            System.out.println(" Incorrect Pin Please Enter Correct Pin ");
            checkpin();
        }
    }

    public void menu() {
        System.out.println("\n1. Check Account Balance");
        System.out.println("2. Withdraw Money");
        System.out.println("3. Deposit Money");
        System.out.println("4. Transaction History");
        System.out.println("5. Transfer Money to Another Account");
        System.out.println("6. Exit");
        Scanner sc = new Scanner(System.in);
        int ch = sc.nextInt();
        switch (ch) {
            case 1:
                checkbalance();
                break;
            case 2:
                withdraw();
                break;
            case 3:
                deposit();
                break;
            case 4:
                showTransactionHistory();
                break;
            case 5:
                transferMoney();
                break;
            case 6:
                System.out.println("Thank you for using our ATM.");
                break;
            default:
                System.out.println("Enter a Valid Choice");
                menu();
                break;
        }
    }

    public void checkbalance() {
        System.out.println("\nYour Account Balance is: " + Balance);
        menu();
    }

    public void withdraw() {
        System.out.println("\nEnter Amount to Withdraw: ");
        Scanner sc = new Scanner(System.in);
        float amt = sc.nextFloat();
        if (amt > Balance) {
            System.out.println("Insufficient Funds");
        } else {
            Balance -= amt;
            transactionHistory += "Withdrawal of " + amt + "\n";
            System.out.println("Money Withdrawn Successfully");
        }
        menu();
    }

    public void deposit() {
        System.out.println("\nEnter the Amount to Deposit: ");
        Scanner sc = new Scanner(System.in);
        float amt = sc.nextFloat();
        Balance += amt;
        transactionHistory += "Deposit of " + amt + "\n";
        System.out.println("Money Deposited Successfully");
        menu();
    }

    public void showTransactionHistory() {
        System.out.println("\nTransaction History:\n" + transactionHistory);
        menu();
    }

    public void transferMoney() {
        System.out.println("\nEnter the Account Number to Transfer Money:");
        Scanner sc = new Scanner(System.in);
        String accNo = sc.nextLine();
        System.out.println("Enter the Amount to Transfer:");
        float amt = sc.nextFloat();
        if (amt > Balance) {
            System.out.println("Insufficient Funds");
        } else {
            Balance -= amt;
            transactionHistory += "Transfer of " + amt + " to Account " + accNo + "\n";
            System.out.println("Money Transferred Successfully");
        }
        menu();
    }
}

public class ATMINterface {
    public static void main(String[] args) {
        ATM s1 = new ATM();
        s1.checkpin();
    }
}
