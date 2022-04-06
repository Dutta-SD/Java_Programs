package account;
public class Savings extends Account {
    private final double interestRate = 0.8;

    Savings(double amount){
        balance = amount;
    }

    @Override
    public void withdraw(double amount) {
        balance -= amount + (this.interestRate * amount);
                    
    }

    @Override
    public void deposit(double amount) {
        balance += amount + (this.interestRate * amount);
    }

    @Override
    void printBalance() {
        System.out.println(this.balance);
    }
}