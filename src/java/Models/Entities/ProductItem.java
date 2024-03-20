package Models.Entities;

public class ProductItem {

    private String ProductID,ProductName;
    private float unitPrice;
    private String Description, ProductImage, CategoryName;

    public ProductItem(String ProductID, String ProductName, float unitPrice, String Description, String ProductImage, String CategoryName) {
        this.ProductID = ProductID;
        this.ProductName = ProductName;
        this.unitPrice = unitPrice;
        this.Description = Description;
        this.ProductImage = ProductImage;
        this.CategoryName = CategoryName;
    }

    public ProductItem() {
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

    public String getDescription() {
        return Description;
    }

    public String getProductImage() {
        return ProductImage;
    }

    public String getCategoryName() {
        return CategoryName;
    }

    public float getUnitPrice() {
        return unitPrice;
    }

    public void setProductName(String ProductName) {
        this.ProductName = ProductName;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public void setProductImage(String ProductImage) {
        this.ProductImage = ProductImage;
    }

    public void setCategoryName(String CategoryName) {
        this.CategoryName = CategoryName;
    }

    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public String toString() {
        return "ProductList{" + "ProductName=" + ProductName + ", Description=" + Description + ", ProductImage=" + ProductImage + ", CategoryName=" + CategoryName + ", unitPrice=" + unitPrice + '}';
    }

}
