public class AccountService{
    private AccountRepository repo;
    public AccountService(AccountRepository r){ repo=r; }
    public void deposit(int no,double amt){ Account a=repo.find(no); if(a!=null) a.deposit(amt); }
    public boolean withdraw(int no,double amt){ Account a=repo.find(no); return a!=null && a.withdraw(amt); }
    public boolean transfer(int from,int to,double amt){
        Account f=repo.find(from); Account t=repo.find(to);
        if(f!=null && t!=null && f.withdraw(amt)){ t.deposit(amt); return true; }
        return false;
    }
}