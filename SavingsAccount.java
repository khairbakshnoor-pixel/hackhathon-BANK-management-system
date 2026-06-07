public class SavingsAccount extends Account{
    public SavingsAccount(int n,String h,double b){ super(n,h,b); }
    @Override public void displayDetails(){
        System.out.println("Savings Account: "+getAccountNumber()+" "+getAccountHolderName()+" Balance="+getBalance());
    }
}