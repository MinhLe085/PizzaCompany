package Models.DAO;

import Models.Entities.ProductItem;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductItemDAO {

    public Connection getConnection() throws Exception {
        try {
            //load driver cho sql server 
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //Connect to database Manager in localhost, using username: "sa" and pass: "12345"
            Connection cnn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;database=MyPizzaShop", "sa", "12345");
            return cnn;
        } catch (ClassNotFoundException | SQLException ex) {
            throw ex;
        }
    }

    //get List Pizza
    public List<ProductItem> getProductItem() throws Exception {
        String ProductID, ProductName, Description, ProductImage, CategoryName;
        float UnitPrice;
        Connection cnn = null;
        PreparedStatement preStm = null;
        ResultSet rs = null;
        List<ProductItem> itemProduct = new ArrayList();
        try {
            cnn = getConnection();
            String sql = "SELECT p.ProductID, p.ProductName, p.UnitPrice, c.Description, p.ProductImage, c.CategoryName FROM Products p "
                    + "JOIN Categories c ON p.CategoryID = c.CategoryID";
            preStm = cnn.prepareStatement(sql);
            rs = preStm.executeQuery();
            while (rs.next()) {
                ProductID = rs.getString(1);
                ProductName = rs.getString(2);
                UnitPrice = rs.getFloat(3);
                Description = rs.getString(4);
                ProductImage = rs.getString(5);
                CategoryName = rs.getString(6);
                ProductItem productList = new ProductItem(ProductID, ProductName, UnitPrice, Description, ProductImage, CategoryName);
                itemProduct.add(productList);
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (preStm != null) {
                preStm.close();
            }
            if (cnn != null) {
                cnn.close();
            }
        }
        return itemProduct;
    }

    public List<ProductItem> searchProductName(String searchValue) throws Exception {
        String ProductID, ProductName, ProductImage, CategoryName, Description;
        float UnitPrice;
        Connection cnn = null;
        PreparedStatement preStm = null;
        ResultSet rs = null;
        ArrayList<ProductItem> productItemList = new ArrayList();
        try {
            cnn = getConnection();
            String sql = "SELECT p.ProductID, p.ProductName, p.UnitPrice, c.Description, p.ProductImage, c.CategoryName FROM Products p JOIN Categories c "
                    + "ON p.CategoryID = c.CategoryID WHERE p.ProductName LIKE ?";
            preStm = cnn.prepareStatement(sql);
            preStm.setString(1, "%" + searchValue + "%");
            rs = preStm.executeQuery();
            while (rs.next()) {
                ProductID = rs.getString(1);
                ProductName = rs.getString(2);
                UnitPrice = rs.getFloat(3);
                Description = rs.getString(4);
                ProductImage = rs.getString(5);
                CategoryName = rs.getString(6);
                ProductItem productList = new ProductItem(ProductID, ProductName, UnitPrice, Description, ProductImage, CategoryName);
                productItemList.add(productList);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (preStm != null) {
                preStm.close();
            }
            if (cnn != null) {
                cnn.close();
            }
        }
        if (productItemList.isEmpty()) {
            return null;
        }
        return productItemList;
    }

    //get product item by ID
    public ProductItem getProductItemByID(String ProID) throws Exception {
        String ProductID, ProductName, Description, ProductImage, CategoryName;
        float UnitPrice;
        ProductItem productItem = null;
        Connection cnn = null;
        PreparedStatement preStm = null;
        ResultSet rs = null;
        try {
            cnn = getConnection();
            String sql = "SELECT p.ProductID, p.ProductName, p.UnitPrice, c.Description, p.ProductImage, c.CategoryName FROM Products p "
                    + "JOIN Categories c ON p.CategoryID = c.CategoryID WHERE p.ProductID=?";
            preStm = cnn.prepareStatement(sql);
            preStm.setString(1, ProID);
            rs = preStm.executeQuery();
            while (rs.next()) {
                ProductID = rs.getString(1);
                ProductName = rs.getString(2);
                UnitPrice = rs.getFloat(3);
                Description = rs.getString(4);
                ProductImage = rs.getString(5);
                CategoryName = rs.getString(6);
                productItem = new ProductItem(ProductID, ProductName, UnitPrice, Description, ProductImage, CategoryName);
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (preStm != null) {
                preStm.close();
            }
            if (cnn != null) {
                cnn.close();
            }
        }
        return productItem;
    }

    public List<ProductItem> searchPrice(float searchPrice) throws Exception {
        String ProductID, ProductName, Description, ProductImage, CategoryName;
        float UnitPrice;
        Connection cnn = null;
        PreparedStatement preStm = null;
        ResultSet rs = null;
        ArrayList<ProductItem> productItemList = new ArrayList();
        try {
            cnn = getConnection();
            String sql = "SELECT p.ProductID, p.ProductName, p.UnitPrice, c.Description, p.ProductImage, c.CategoryName FROM Products p "
                    + "JOIN Categories c ON p.CategoryID = c.CategoryID WHERE p.UnitPrice <= ?";
            preStm = cnn.prepareStatement(sql);
            preStm.setFloat(1, searchPrice);
            rs = preStm.executeQuery();
            while (rs.next()) {
                ProductID = rs.getString(1);
                ProductName = rs.getString(2);
                UnitPrice = rs.getFloat(3);
                Description = rs.getString(4);
                ProductImage = rs.getString(5);
                CategoryName = rs.getString(6);
                ProductItem productList = new ProductItem(ProductID, ProductName, UnitPrice, Description, ProductImage, CategoryName);
                productItemList.add(productList);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (preStm != null) {
                preStm.close();
            }
            if (cnn != null) {
                cnn.close();
            }
        }
        if (productItemList.isEmpty()) {
            return null;
        }
        return productItemList;
    }
}
