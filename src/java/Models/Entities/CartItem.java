
package Models.Entities;

public class CartItem {
    private String itemId;
    private String itemName;
    private int quantity;
    private float unitPrice;

    public CartItem() {
    }

    public CartItem(String itemId, String itemName, int quantity, float unitPrice) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public String getItemId() {
        return itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public float getUnitPrice() {
        return unitPrice;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
    }
    
    public double getSubTotal() {
        return quantity*unitPrice;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%d,%.2f", itemId, itemName, quantity, unitPrice);
    }
    
    
}
