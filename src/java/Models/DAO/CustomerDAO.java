/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.DAO;

import Models.Entities.Customer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {

    // connect database
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

    // getCustomerList
    public List<Customer> getCustomerList() throws Exception {
        String CustomerID, Password, ContactName, Address, Phone;
        Connection cnn = null;
        PreparedStatement preStm = null;
        ResultSet rs = null;
        List<Customer> customerList = new ArrayList<>();
        try {
            cnn = getConnection();
            String sql = "Select CustomerID, Password, ContactName, Address, Phone From Customers";
            preStm = cnn.prepareStatement(sql);
            rs = preStm.executeQuery();
            while (rs.next()) {
                CustomerID = rs.getString(1);
                Password = rs.getString(2);
                ContactName = rs.getString(3);
                Address = rs.getString(4);
                Phone = rs.getString(5);
                Customer newCustomer = new Customer(CustomerID, Password, ContactName, Address, Phone);
                customerList.add(newCustomer);
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
        return customerList;
    }

    // updateCustomer
    public boolean updateCustomer(Customer customer) throws Exception {
        PreparedStatement preStm = null;
        Connection cnn = null;
        try {
            cnn = getConnection();
            String sql = "Update Customers Set Password=?, ContactName= ?, Address=?, Phone=? Where CustomerID=?";
            preStm = cnn.prepareStatement(sql);
            preStm.setString(1, customer.getPassword());
            preStm.setString(2, customer.getContactName());
            preStm.setString(3, customer.getAddress());
            preStm.setString(4, customer.getPhone());
            preStm.setString(5, customer.getCustomerID());
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

    // addCustomer
    public boolean addCustomer(Customer customer) throws Exception {
        PreparedStatement preStm = null;
        Connection cnn = null;
        try {
            cnn = getConnection();
            String sql = "Insert Customers Values (?,?,?,?,?)";
            preStm = cnn.prepareStatement(sql);
            preStm.setString(1, customer.getCustomerID());
            preStm.setString(2, customer.getPassword());
            preStm.setString(3, customer.getContactName());
            preStm.setString(4, customer.getAddress());
            preStm.setString(5, customer.getPhone());
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

    // deleteCustomer
    public boolean deleteCustomer(String CustomerID) throws Exception {
        PreparedStatement preStm = null;
        Connection cnn = null;
        try {
            cnn = getConnection();
            String sql = "Delete Customers Where CustomerID=?";
            preStm = cnn.prepareStatement(sql);
            preStm.setString(1, CustomerID);
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
