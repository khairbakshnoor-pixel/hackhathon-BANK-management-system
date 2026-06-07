import java.util.*;
public class Main{
    public static void main(String[] args)throws Exception{
        Scanner sc=new Scanner(System.in);
        Admin admin=new Admin();
        System.out.print("Username: "); String u=sc.next();
        System.out.print("Password: "); String p=sc.next();
        if(!admin.login(u,p)){ System.out.println("Invalid Login"); return; }

        AccountRepository repo=new AccountRepository();
        repo.setAccounts(FileManager.load());
        AccountService service=new AccountService(repo);

        while(true){
            System.out.println("\n1.Create 2.Deposit 3.Withdraw 4.Search 5.Delete 6.ViewAll 7.Transfer 8.Save&Exit");
            int ch=sc.nextInt();
            switch(ch){
                case 1:
                    System.out.print("Acc No: "); int no=sc.nextInt();
                    sc.nextLine();
                    System.out.print("Name: "); String name=sc.nextLine();
                    System.out.print("Balance: "); double bal=sc.nextDouble();
                    System.out.print("1.Savings 2.Current: "); int t=sc.nextInt();
                    repo.add(t==1?new SavingsAccount(no,name,bal):new CurrentAccount(no,name,bal));
                    break;
                case 2:
                    System.out.print("Acc No: "); no=sc.nextInt();
                    System.out.print("Amount: "); service.deposit(no,sc.nextDouble());
                    break;
                case 3:
                    System.out.print("Acc No: "); no=sc.nextInt();
                    System.out.print("Amount: "); System.out.println(service.withdraw(no,sc.nextDouble()));
                    break;
                case 4:
                    System.out.print("Acc No: "); no=sc.nextInt();
                    Account a=repo.find(no);
                    if(a!=null) a.displayDetails(); else System.out.println("Not Found");
                    break;
                case 5:
                    System.out.print("Acc No: "); System.out.println(repo.delete(sc.nextInt()));
                    break;
                case 6:
                    for(Account acc:repo.getAccounts()) acc.displayDetails();
                    break;
                case 7:
                    System.out.print("From: "); int f=sc.nextInt();
                    System.out.print("To: "); int to=sc.nextInt();
                    System.out.print("Amount: "); System.out.println(service.transfer(f,to,sc.nextDouble()));
                    break;
                case 8:
                    FileManager.save(repo.getAccounts());
                    System.out.println("Saved"); return;
            }
        }
    }
}