public class CurrentAccount extends Account{
    public CurrentAccount(int n,String h,double b){ super(n,h,b); }
    @Override public void displayDetails(){
        System.out.println("Current Account: "+getAccountNumber()+" "+getAccountHolderName()+" Balance="+getBalance());
    }
}