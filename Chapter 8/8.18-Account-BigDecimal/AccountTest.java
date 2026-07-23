// AccountTest.java
import java.math.BigDecimal;

public class AccountTest {
    public static void main(String[] args) {
        Account account1 = new Account("Jane Green", new BigDecimal("50.00"));
        Account account2 = new Account("John Blue");

        System.out.printf("%s balance: $%s%n", account1.getName(), account1.getBalance());
        System.out.printf("%s balance: $%s%n%n", account2.getName(), account2.getBalance());

        account1.deposit(new BigDecimal("25.53"));
        account2.deposit(new BigDecimal("123.45"));

        System.out.printf("%s balance after deposit: $%s%n", account1.getName(), account1.getBalance());
        System.out.printf("%s balance after deposit: $%s%n%n", account2.getName(), account2.getBalance());

        account1.withdraw(new BigDecimal("2000.00")); // exceeds balance
        account2.withdraw(new BigDecimal("100.00"));

        System.out.printf("%s balance after withdrawal attempt: $%s%n", account1.getName(), account1.getBalance());
        System.out.printf("%s balance after withdrawal: $%s%n", account2.getName(), account2.getBalance());
    }
}
