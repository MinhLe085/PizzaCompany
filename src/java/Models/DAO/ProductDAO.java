package Models.DAO;

import Models.Entities.Product;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

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

    // getProductList
    public List<Product> getProductList() throws Exception {
        String ProductID, ProductName, SupplierID, CategoryID, ProductImage;
        int QuantityPerUnit;
        float UnitPrice;
        Connection cnn = null;
        PreparedStatement preStm = null;
        ResultSet rs = null;
        List<Product> productList = new ArrayList();
        try {
            cnn = getConnection();
            String sql = "Select ProductID, ProductName, SupplierID, CategoryID, ProductImage, QuantityPerUnit, UnitPrice From Products";
            preStm = cnn.prepareStatement(sql);
            rs = preStm.executeQuery();
            while (rs.next()) {
                ProductID = rs.getString(1);
                ProductName = rs.getString(2);
                SupplierID = rs.getString(3);
                CategoryID = rs.getString(4);
                ProductImage = rs.getString(5);
                QuantityPerUnit = rs.getInt(6);
                UnitPrice = rs.getFloat(7);
                Product newProduct = new Product(ProductID, ProductName, SupplierID, CategoryID, ProductImage, QuantityPerUnit, UnitPrice);
                productList.add(newProduct);
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (cnn != null) {
                cnn.close();
            }
            if (preStm != null) {
                preStm.close();
            }
            if (rs != null) {
                rs.close();
            }
        }
        return productList;
    }

    // updateProduct
    public boolean updateProduct(Product product) throws Exception {
        PreparedStatement preStm = null;
        Connection cnn = null;
        try {
            cnn = getConnection();
            String sql = "Update Products Set ProductName=?, SupplierID=?, CategoryID = ?, QuantityPerUnit=?,UnitPrice=?, ProductImage=? Where ProductID=?";
            preStm = cnn.prepareStatement(sql);
            preStm.setString(1, product.getProductName());
            preStm.setString(2, product.getSupplierID());
            preStm.setString(3, product.getCategoryID());
            preStm.setInt(4, product.getQuantityPerUnit());
            preStm.setFloat(5, product.getUnitPrice());
            preStm.setString(6, product.getProductImage());
            preStm.setString(7, product.getProductID());
            return preStm.executeUpdate() > 0;
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (preStm != null) {
                preStm.close();
            }
            if (cnn != null) {
                cnn.close();
            }
        }
    }

    // addProduct
    public boolean addProduct(Product product) throws Exception {
        PreparedStatement preStm = null;
        Connection cnn = null;
        try {
            cnn = getConnection();
            String sql = "Insert Products Values (?,?,?,?,?,?,?)";
            preStm = cnn.prepareStatement(sql);
            preStm.setString(1, product.getProductID());
            preStm.setString(2, product.getProductName());
            preStm.setString(3, product.getSupplierID());
            preStm.setString(4, product.getCategoryID());
            preStm.setInt(5, product.getQuantityPerUnit());
            preStm.setFloat(6, product.getUnitPrice());
            preStm.setString(7, product.getProductImage());
            return preStm.executeUpdate() > 0;
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (preStm != null) {
                preStm.close();
            }
            if (cnn != null) {
                cnn.close();
            }
        }
    }

    // deleteProduct
    public boolean deleteProduct(String ProductID) throws Exception {
        PreparedStatement preStm = null;
        Connection cnn = null;
        try {
            cnn = getConnection();
            String sql = "Delete Products Where ProductID=?";
            preStm = cnn.prepareStatement(sql);
            preStm.setString(1, ProductID);
            return preStm.executeUpdate() > 0;
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (preStm != null) {
                preStm.close();
            }
            if (cnn != null) {
                cnn.close();
            }
        }
    }
    
    //view Detail
    public Product viewDetail(String ProductID) throws Exception {
        String ProductName, SupplierID, CategoryID;
        int QuantityPerUnit;
        float UnitPrice;
        String ProductImage;
        Connection cnn = null;
        ResultSet rs = null;
        PreparedStatement preStm = null;
        Product product = null;
        try {
            cnn = getConnection();
            String sql
                    = "Select ProductName, SupplierID, CategoryID, ProductImage, QuantityPerUnit, UnitPrice "
                    + "From Products WHERE ProductID=?";
            preStm = cnn.prepareStatement(sql);
            preStm.setString(1, ProductID);
            rs = preStm.executeQuery();
            while (rs.next()) {
                ProductName = rs.getString(1);
                SupplierID = rs.getString(2);
                CategoryID = rs.getString(3);
                ProductImage = rs.getString(4);
                QuantityPerUnit = rs.getInt(5);
                UnitPrice = rs.getFloat(6);
                product = new Product(ProductID, ProductName, SupplierID, CategoryID, ProductImage, QuantityPerUnit, UnitPrice);
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
        return product;
    }

    // getProductByID
    public Product getProductByID(String ProductID) throws Exception {
        String ProductName, SupplierID, CategoryID, ProductImage;
        int QuantityPerUnit;
        float UnitPrice;
        Connection cnn = null;
        PreparedStatement preStm = null;
        ResultSet rs = null;
        Product newProduct = null;
        try {
            cnn = getConnection();
            String sql = "Select ProductName, SupplierID, CategoryID, ProductImage, QuantityPerUnit, UnitPrice From Products Where ProductID = ?";
            preStm = cnn.prepareStatement(sql);
            preStm.setString(1, ProductID);
            rs = preStm.executeQuery();
            while (rs.next()) {
                ProductName = rs.getString(1);
                SupplierID = rs.getString(2);
                CategoryID = rs.getString(3);
                ProductImage = rs.getString(4);
                QuantityPerUnit = rs.getInt(5);
                UnitPrice = rs.getFloat(6);
                newProduct = new Product(ProductID, ProductName, SupplierID, CategoryID, ProductImage, QuantityPerUnit, UnitPrice);
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
        return newProduct;
    }

    //getProductByName
    public List<Product> getProductByName(String searchValue) throws Exception {
        String ProductID, ProductName, SupplierID, CategoryID, ProductImage;
        int QuantityPerUnit;
        float UnitPrice;
        List<Product> productList = new ArrayList();
        Connection cnn = null;
        PreparedStatement preStm = null;
        ResultSet rs = null;
        try {
            cnn = getConnection();
            String sql
                    = "SELECT ProductID, ProductName, SupplierID, CategoryID, ProductImage, QuantityPerUnit, UnitPrice "
                    + "FROM Products WHERE ProductName like ?";
            preStm = cnn.prepareStatement(sql);
            preStm.setString(1, "%" + searchValue + "%");
            rs = preStm.executeQuery();
            while (rs.next()) {
                ProductID = rs.getString(1);
                ProductName = rs.getString(2);
                SupplierID = rs.getString(3);
                CategoryID = rs.getString(4);
                ProductImage = rs.getString(5);
                QuantityPerUnit = rs.getInt(6);
                UnitPrice = rs.getFloat(7);
                Product product = new Product(ProductID, ProductName, SupplierID, CategoryID, ProductImage, QuantityPerUnit, UnitPrice);
                productList.add(product);
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
        if (productList.isEmpty()) {
            return null;
        }
        return productList;
    }

    //getProductByUnitPrice
    public Product getProductByUnitPrice(float UnitPrice) throws Exception {
        String ProductID, ProductName, SupplierID, CategoryID, ProductImage;
        int QuantityPerUnit;
        Connection cnn = null;
        PreparedStatement preStm = null;
        ResultSet rs = null;
        Product newProduct = null;
        try {
            cnn = getConnection();
            String sql = "Select ProductID, ProductName, SupplierID, CategoryID, ProductImage, QuantityPerUnit From Products Where UnitPrice = ?";
            preStm = cnn.prepareStatement(sql);
            preStm.setFloat(1, UnitPrice);
            rs = preStm.executeQuery();
            while (rs.next()) {
                ProductID = rs.getString(1);
                ProductName = rs.getString(2);
                SupplierID = rs.getString(3);
                CategoryID = rs.getString(4);
                ProductImage = rs.getString(5);
                QuantityPerUnit = rs.getInt(6);
                newProduct = new Product(ProductID, ProductName, SupplierID, CategoryID, ProductImage, QuantityPerUnit, UnitPrice);
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
        return newProduct;
    }

}
