package account;

public class Demo {
    public static void main(String[] args) {
        Demo demo = new Demo();

        demo.savingsDemo();
        demo.currentDemo();
    }

    private void savingsDemo(){
        Account sAccount = new Savings(50000);
        sAccount.deposit(1000);
        sAccount.printBalance();
        sAccount.withdraw(3000);
        sAccount.printBalance();
        System.out.println();
    }

    private void currentDemo(){
        Account sAccount = new Current(50000);
        sAccount.deposit(1000);
        sAccount.printBalance();
        sAccount.withdraw(3000);
        sAccount.printBalance();
        System.out.println();
    }
    
}
