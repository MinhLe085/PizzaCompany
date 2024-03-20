
package Models.DAO;

import Models.Entities.Supplier;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SupplierDAO {
    
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

    // getSupplierList
    public List<Supplier> getSupplierList() throws Exception {
        String SupplierID, CompanyName, Address, Phone;
        Connection cnn = null;
        PreparedStatement preStm = null;
        ResultSet rs = null;
        List<Supplier> supplierList = new ArrayList();
        try {
            cnn = getConnection();
            String sql = "Select SupplierID, CompanyName, Address, Phone From Suppliers";
            preStm = cnn.prepareStatement(sql);
            rs = preStm.executeQuery();
            while (rs.next()) {
                SupplierID = rs.getString(1);
                CompanyName = rs.getString(2);
                Address = rs.getString(3);
                Phone = rs.getString(4);
                Supplier newSupplier = new Supplier(SupplierID, CompanyName, Address, Phone);
                supplierList.add(newSupplier);
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
        return supplierList;
    }

    // updateSupplier
    public boolean updateSupplier(Supplier supplier) throws Exception {
        PreparedStatement preStm = null;
        Connection cnn = null;
        try {
            cnn = getConnection();
            String sql = "Update Suppliers Set CompanyName=?, Address=?, Phone=? Where SupplierID=?";
            preStm = cnn.prepareStatement(sql);
            preStm.setString(1, supplier.getCompanyName());
            preStm.setString(2, supplier.getAddress());
            preStm.setString(3, supplier.getPhone());
            preStm.setString(4, supplier.getSupplierID());
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

    // addSupplier
    public boolean addSupplier(Supplier supplier) throws Exception {
        PreparedStatement preStm = null;
        Connection cnn = null;
        try {
            cnn = getConnection();
            String sql = "Insert Suppliers Values (?,?,?,?)";
            preStm = cnn.prepareStatement(sql);
            preStm.setString(1, supplier.getSupplierID());
            preStm.setString(2, supplier.getCompanyName());
            preStm.setString(3, supplier.getAddress());
            preStm.setString(4, supplier.getPhone());
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

    // deleteSupplier
    public boolean deleteSupplier(String SupplierID) throws Exception {
        PreparedStatement preStm = null;
        Connection cnn = null;
        try {
            cnn = getConnection();
            String sql = "Delete Suppliers Where SupplierID=?";
            preStm = cnn.prepareStatement(sql);
            preStm.setString(1, SupplierID);
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

    // getSupplierByID
    public Supplier getSupplierByID(String SupplierID) throws Exception {
        String CompanyName, Address, Phone;      
        Connection cnn = null;
        PreparedStatement preStm = null;
        ResultSet rs = null;
        Supplier newSupplier = null;
        try {
            cnn = getConnection();
            String sql = "Select CompanyName, Address, Phone From Suppliers Where SupplierID = ?";
            preStm = cnn.prepareStatement(sql);
            preStm.setString(1, SupplierID);
            rs = preStm.executeQuery();
            while (rs.next()) {
                CompanyName = rs.getString(1);
                Address = rs.getString(2);
                Phone = rs.getString(3);
                newSupplier = new Supplier(SupplierID, CompanyName, Address, Phone);
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
        return newSupplier;
    }
 
}
