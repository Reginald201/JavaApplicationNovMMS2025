// SavingsAccount.java
// SavingsAccount class with a static annualInterestRate shared by all accounts.
public class SavingsAccount {
    private double savingsBalance;
    private static double annualInterestRate;

    // constructor
    public SavingsAccount(double savingsBalance) {
        this.savingsBalance = savingsBalance;
    }

    // calculate monthly interest and add it to savingsBalance
    public double calculateMonthlyInterest() {
        double monthlyInterest = savingsBalance * (annualInterestRate / 12);
        savingsBalance += monthlyInterest;
        return monthlyInterest;
    }

    // static method to set the annualInterestRate for all accounts
    public static void modifyInterestRate(double newRate) {
        annualInterestRate = newRate;
    }

    public double getSavingsBalance() {
        return savingsBalance;
    }
}
