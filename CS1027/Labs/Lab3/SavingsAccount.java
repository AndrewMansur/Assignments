public class SavingsAccount extends BankAccount{
    private double  interestRate;

    public SavingsAccount(double initialAmount, double rate){
        super(initialAmount);
        interestRate = rate;
    }

    public double getInterestRate(){
        return interestRate;
    }

    public void calculateInterest(){
        double interest = interestRate * getBalance();
        deposit(interest);

    }

    public String toString(){
        String stringRep = "SavingsAccount: balance $" + getBalance() + ", interest rate" +interestRate + "%";
        return stringRep;
    }



    public static void main(String[] args) {
        SavingsAccount myAccount = new SavingsAccount(100.0,0.15);
        myAccount.calculateInterest();
        System.out.println(myAccount.toString());
    }
}
