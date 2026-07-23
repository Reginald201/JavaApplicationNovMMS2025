// Account.java
// Account class storing its balance as a BigDecimal, using BigDecimal
// for all calculations, to avoid the rounding errors of double.
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Account {
    private String name;
    private BigDecimal balance;

    // constructor: name only, balance defaults to 0.00
    public Account(String name) {
        this(name, BigDecimal.ZERO);
    }

    // constructor: name and initial balance
    public Account(String name, BigDecimal initialBalance) {
        this.name = name;
        if (initialBalance.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Initial balance cannot be negative.");
        }
        this.balance = initialBalance.setScale(2, RoundingMode.HALF_UP);
    }

    // credits (adds to) the account
    public void deposit(BigDecimal depositAmount) {
        if (depositAmount.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Deposit amount cannot be negative.");
        }
        balance = balance.add(depositAmount).setScale(2, RoundingMode.HALF_UP);
    }

    // debits (withdraws from) the account
    public void withdraw(BigDecimal withdrawAmount) {
        if (withdrawAmount.compareTo(balance) > 0) {
            System.out.println("Withdrawal amount exceeded account balance.");
            return;
        }
        balance = balance.subtract(withdrawAmount).setScale(2, RoundingMode.HALF_UP);
    }

    public String getName() {
        return name;
    }

    public BigDecimal getBalance() {
        return balance;
    }
}
