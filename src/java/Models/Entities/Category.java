package Models.Entities;

public class Category {

    private String CategoryID, CategoryName, Description;

    public Category() {
    }

    public Category(String CategoryID, String CategoryName, String Description) {
        this.CategoryID = CategoryID;
        this.CategoryName = CategoryName;
        this.Description = Description;
    }

    public String getCategoryID() {
        return CategoryID;
    }

    public void setCategoryID(String CategoryID) {
        this.CategoryID = CategoryID;
    }

    public String getCategoryName() {
        return CategoryName;
    }

    public void setCategoryName(String CategoryName) {
        this.CategoryName = CategoryName;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    @Override
    public String toString() {
        return "Category{" + "CategoryID=" + CategoryID + ", CategoryName=" + CategoryName + ", Description=" + Description + '}';
    }

}
