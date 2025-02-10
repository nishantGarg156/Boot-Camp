package Collection2;
import java.util.*;
class Transaction {
    int transactionID;
    double amount;
    Transaction(int transactionID, double amount) {
        this.transactionID = transactionID;
        this.amount = amount;
    }
    public String toString() {
        return "Transaction{" + "id=" + transactionID + ", amount=" + amount +  '}';
    }
}
public class BankingSystemFunction {
    private final Map<Integer, Deque<Transaction>> transactionMap = new HashMap<>();
    private static final int MAX_TRANSACTIONS = 10;
    public void addTransaction(int accountId, Transaction transaction) {
        transactionMap.putIfAbsent(accountId, new ArrayDeque<>());
        Deque<Transaction> transactions = transactionMap.get(accountId);
        if (transactions.size() == MAX_TRANSACTIONS) {
            transactions.pollFirst();
        }
        transactions.addLast(transaction);
    }
    public List<Transaction> getLastTransactions(int accountId) {
        return new ArrayList<>(transactionMap.getOrDefault(accountId, new ArrayDeque<>()));
    }
    public static void main(String[] args) {
        BankingSystemFunction bank = new BankingSystemFunction();
        for (int i = 1; i <= 12; i++) {
            bank.addTransaction(901, new Transaction(i, i * 1000.0));
        }
        System.out.println("Latest 10 Transactions: " + bank.getLastTransactions(901));
    }
}

