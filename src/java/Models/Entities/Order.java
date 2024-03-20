
package Models.Entities;

public class Order {
    private String OrderID;
    private String CustomerID;
    private String OrderDate;
    private String RequiredDate;
    private String ShippedDate;
    private int Freight;
    private String ShipAddress;

    public Order(String OrderID, String CustomerID, String OrderDate, String RequiredDate, String ShippedDate, int Freight, String ShipAddress) {
        this.OrderID = OrderID;
        this.CustomerID = CustomerID;
        this.OrderDate = OrderDate;
        this.RequiredDate = RequiredDate;
        this.ShippedDate = ShippedDate;
        this.Freight = Freight;
        this.ShipAddress = ShipAddress;
    }

    public String getOrderID() {
        return OrderID;
    }

    public String getCustomerID() {
        return CustomerID;
    }

    public String getOrderDate() {
        return OrderDate;
    }

    public String getRequiredDate() {
        return RequiredDate;
    }

    public String getShippedDate() {
        return ShippedDate;
    }

    public int getFreight() {
        return Freight;
    }

    public String getShipAddress() {
        return ShipAddress;
    }

    public void setOrderID(String OrderID) {
        this.OrderID = OrderID;
    }

    public void setCustomerID(String CustomerID) {
        this.CustomerID = CustomerID;
    }

    public void setOrderDate(String OrderDate) {
        this.OrderDate = OrderDate;
    }

    public void setRequiredDate(String RequiredDate) {
        this.RequiredDate = RequiredDate;
    }

    public void setShippedDate(String ShippedDate) {
        this.ShippedDate = ShippedDate;
    }

    public void setFreight(int Freight) {
        this.Freight = Freight;
    }

    public void setShipAddress(String ShipAddress) {
        this.ShipAddress = ShipAddress;
    }

    @Override
    public String toString() {
        return "Orders{" + "OrderID=" + OrderID + ", CustomerID=" + CustomerID + ", OrderDate=" + OrderDate + ", RequiredDate=" + RequiredDate + ", ShippedDate=" + ShippedDate + ", Freight=" + Freight + ", ShipAddress=" + ShipAddress + '}';
    }
    
}
