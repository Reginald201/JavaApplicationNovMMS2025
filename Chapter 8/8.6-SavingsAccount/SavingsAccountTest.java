// SavingsAccountTest.java
public class SavingsAccountTest {
    public static void main(String[] args) {
        SavingsAccount saver1 = new SavingsAccount(2000.00);
        SavingsAccount saver2 = new SavingsAccount(3000.00);

        SavingsAccount.modifyInterestRate(0.04); // 4%

        System.out.println("Annual interest rate: 4%");
        for (int month = 1; month <= 12; month++) {
            saver1.calculateMonthlyInterest();
            saver2.calculateMonthlyInterest();
        }
        System.out.printf("saver1 balance: $%.2f%n", saver1.getSavingsBalance());
        System.out.printf("saver2 balance: $%.2f%n%n", saver2.getSavingsBalance());

        SavingsAccount.modifyInterestRate(0.05); // 5%
        System.out.println("Annual interest rate: 5%");
        saver1.calculateMonthlyInterest();
        saver2.calculateMonthlyInterest();
        System.out.printf("saver1 balance: $%.2f%n", saver1.getSavingsBalance());
        System.out.printf("saver2 balance: $%.2f%n", saver2.getSavingsBalance());
    }
}
