import java.io.*;import java.util.*;
public class FileManager{
    private static final String FILE="accounts.dat";
    public static void save(ArrayList<Account> accounts)throws Exception{
        ObjectOutputStream o=new ObjectOutputStream(new FileOutputStream(FILE));
        o.writeObject(accounts); o.close();
    }
    @SuppressWarnings("unchecked")
    public static ArrayList<Account> load(){
        try{
            ObjectInputStream i=new ObjectInputStream(new FileInputStream(FILE));
            ArrayList<Account> a=(ArrayList<Account>)i.readObject();
            i.close(); return a;
        }catch(Exception e){ return new ArrayList<>(); }
    }
}