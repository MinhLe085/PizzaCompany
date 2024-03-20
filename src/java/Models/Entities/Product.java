package Models.Entities;

public class Product {

    private String ProductID, ProductName, SupplierID, CategoryID, ProductImage;
    private int QuantityPerUnit;
    private float UnitPrice;

    public Product() {
    }

    public Product(String ProductID, String ProductName, String SupplierID, String CategoryID, String ProductImage, int QuantityPerUnit, float UnitPrice) {
        this.ProductID = ProductID;
        this.ProductName = ProductName;
        this.SupplierID = SupplierID;
        this.CategoryID = CategoryID;
        this.ProductImage = ProductImage;
        this.QuantityPerUnit = QuantityPerUnit;
        this.UnitPrice = UnitPrice;
    }

    public String getProductID() {
        return ProductID;
    }

    public void setProductID(String ProductID) {
        this.ProductID = ProductID;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String ProductName) {
        this.ProductName = ProductName;
    }

    public String getSupplierID() {
        return SupplierID;
    }

    public void setSupplierID(String SupplierID) {
        this.SupplierID = SupplierID;
    }

    public String getCategoryID() {
        return CategoryID;
    }

    public void setCategoryID(String CategoryID) {
        this.CategoryID = CategoryID;
    }

    public String getProductImage() {
        return ProductImage;
    }

    public void setProductImage(String ProductImage) {
        this.ProductImage = ProductImage;
    }

    public int getQuantityPerUnit() {
        return QuantityPerUnit;
    }

    public void setQuantityPerUnit(int QuantityPerUnit) {
        this.QuantityPerUnit = QuantityPerUnit;
    }

    public float getUnitPrice() {
        return UnitPrice;
    }

    public void setUnitPrice(float UnitPrice) {
        this.UnitPrice = UnitPrice;
    }

    @Override
    public String toString() {
        return "Product{" + "ProductID=" + ProductID + ", ProductName=" + ProductName + ", SupplierID=" + SupplierID + ", CategoryID=" + CategoryID + ", ProductImage=" + ProductImage + ", QuantityPerUnit=" + QuantityPerUnit + ", UnitPrice=" + UnitPrice + '}';
    }

}
