package Java2;

public class AccountManager {
    public static void main(String[] args) {
        SavingAccount accounts = new SavingAccount("123456", "John Doe", 1000.0, 5.0);
        accounts.deposit(100.0);
        accounts.withdraw(5.0);
        accounts.getBalance();
        accounts.withdraw(500.0);
        accounts.getBalance();
    }
}
