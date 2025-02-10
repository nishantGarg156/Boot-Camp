package Java2;

public abstract class BankAccount {
    private String accountNumber;
    private String accountHolder;
    protected double balance;
    public BankAccount() {}
    public BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }
    public void deposit(double amount) {
        this.balance += amount;
    }
    public void withdraw(double amount) {
        if(amount >0) {
            this.balance -= amount;
        }else{
            System.out.println("Insufficient balance");
        }

    }
    public void getBalance() {
        System.out.println("Balance: " + this.balance);
    }
    public abstract void calculateInterest();

}
