public class Item{
    private final int ItemId;
    private static int nextItemId = 100;
    private final String ItemName;
    private double Price;
    private int Quantity;

    public Item(String itemName, double price, int quantity){
        this.ItemId = nextItemId;
        nextItemId++;
        this.ItemName = itemName;
        this.Price = price;
        this.Quantity = quantity;
    }

    public int getItemId(){
        return ItemId;
    }

    public String getItemName() {
        return ItemName;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }
}