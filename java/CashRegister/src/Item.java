public class Item{
    private final int ItemId;
    private static int nextItemId = 100;
    private final String ItemName;
    private float Price;
    private int Quantity;

    public Item(String itemName, float price, int quantity){
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

    public float getPrice() {
        return Price;
    }

    public void setPrice(float price) {
        this.Price = price;
    }

    public int getQuantity() {
        return Quantity;
    }

    // amount will be removed from the current stock
    public void setQuantity(int quantity) {
        this.Quantity -= quantity;
    }
}