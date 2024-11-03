public class Cashier{
    private final int CashierNumber;
    private final String Username;
    private static int nextIdNumber = 100;

    public Cashier(String username){
        this.CashierNumber = nextIdNumber;
        nextIdNumber ++;
        this.Username = username;
    }

    public int getCashierNumber() {
        return CashierNumber;
    }

    public String getUsername() {
        return Username;
    }
}