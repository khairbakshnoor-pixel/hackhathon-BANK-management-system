public class Admin{
    public boolean login(String u,String p){
        return "admin".equals(u) && "12345".equals(p);
    }
}