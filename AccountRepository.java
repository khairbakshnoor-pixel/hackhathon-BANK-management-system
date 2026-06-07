import java.util.*;
public class AccountRepository{
    private ArrayList<Account> accounts=new ArrayList<>();
    public ArrayList<Account> getAccounts(){ return accounts; }
    public void setAccounts(ArrayList<Account> a){ accounts=a; }
    public void add(Account a){ accounts.add(a); }
    public Account find(int no){
        for(Account a:accounts) if(a.getAccountNumber()==no) return a;
        return null;
    }
    public boolean delete(int no){
        Account a=find(no);
        if(a!=null){ accounts.remove(a); return true; }
        return false;
    }
}