package Models.DAO;

import Models.Entities.Category;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO {

    //get Connection to database
    public Connection getConnection() throws Exception {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=MyPizzaShop";
            Connection cnn = DriverManager.getConnection(url, "sa", "12345");
            return cnn;
        } catch (Exception e) {
            throw e;
        }
    }
    
    //get Category List
    public List<Category> getCategoryList() throws Exception {
        String CategoryID, CategoryName, Description;
        List<Category> categoryList = new ArrayList();
        Connection cnn = null;
        PreparedStatement preStm = null;
        ResultSet rs = null;
        try {
            cnn = getConnection();
            String sql
                    = "SELECT CategoryID, CategoryName, Description FROM Categories";
            preStm = cnn.prepareStatement(sql);
            rs = preStm.executeQuery();
            while (rs.next()) {
                CategoryID = rs.getString(1);
                CategoryName = rs.getString(2);
                Description = rs.getString(3);
                Category category = new Category(CategoryID, CategoryName, Description);
                categoryList.add(category);
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
        return categoryList;
    }
    
    //add category
    public boolean addCategory(Category category) throws Exception {
        PreparedStatement preStm = null;
        Connection cnn = null;
        try {
            cnn = getConnection();
            String sql = "Insert Categories Values (?,?,?)";
            preStm = cnn.prepareStatement(sql);
            preStm.setString(1, category.getCategoryID());
            preStm.setString(2, category.getCategoryName());
            preStm.setString(3, category.getDescription());
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
    
    //delete Category
    public boolean deleteCategory(String CategoryID) throws Exception {
        PreparedStatement preStm = null;
        Connection cnn = null;
        try {
            cnn = getConnection();
            String sql = "Delete Categories Where CategoryID=?";
            preStm = cnn.prepareStatement(sql);
            preStm.setString(1, CategoryID);
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
    
    // update Category
    public boolean updateCategory(Category category) throws Exception {
        PreparedStatement preStm = null;
        Connection cnn = null;
        try {
            cnn = getConnection();
            String sql = "Update Categories Set CategoryName=?, Description=? Where CategoryID=?";
            preStm = cnn.prepareStatement(sql);
            preStm.setString(1, category.getCategoryName());
            preStm.setString(2, category.getDescription());
            preStm.setString(3, category.getCategoryID());
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
}
