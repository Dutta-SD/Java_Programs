package account;
public class Current extends Account {

    Current(double amount){
        balance = amount;
    }

    @Override
    public void withdraw(double amount) {
        double finalAmount = balance - amount;
        if(finalAmount >= 0) balance = finalAmount;        
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
    }

    @Override
    void printBalance() {
        System.out.println(this.balance);
    }
}