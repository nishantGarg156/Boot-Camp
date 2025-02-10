package dummy1;

import java.util.Scanner;

public class AtmMachine {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int AccountBalance = 1000;
        int attempts = 3;

        System.out.println("Welcome to the ATM!");
        System.out.println("Your current balance: $" + AccountBalance);
        System.out.println("You have " + attempts + " withdrawal attempts.");
        while (attempts > 0) {
            System.out.print("\n Enter the amount to withdraw (must be a multiple of 50): ");
            int withdrawal = scanner.nextInt();
            if (withdrawal % 50 != 0) {
                System.out.println("Error: Withdrawal amount must be a multiple of 50.");
            } else if (withdrawal > AccountBalance) {
                System.out.println("Error: Insufficient funds! Your balance is $" + AccountBalance);
            } else {
                AccountBalance -= withdrawal;
                System.out.println("Withdrawal successful! Your new balance is $" + AccountBalance);
                break;
            }
            attempts--;
            if (attempts > 0) {
                System.out.println("You have " + attempts + " attempt(s) remaining.");
            } else  {
                System.out.println("You have exceeded the maximum number of attempts. Try again later.");
            }
        }

    }
}
