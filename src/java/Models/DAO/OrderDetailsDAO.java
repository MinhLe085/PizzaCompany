package Models.DAO;

import Models.Entities.OrderDetails;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class OrderDetailsDAO {
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
    
    //get order details List
    public List<OrderDetails> getOrderDetailsList() throws Exception {
        String OrderID, ProductID;
        float UnitPrice;
        int Quantity;
        List<OrderDetails> orderDetailsList = new ArrayList();
        Connection cnn = null;
        PreparedStatement preStm = null;
        ResultSet rs = null;
        try {
            cnn = getConnection();
            String sql
                    = "SELECT OrderID, ProductID, UnitPrice, Quantity FROM [Order Details]";
            preStm = cnn.prepareStatement(sql);
            rs = preStm.executeQuery();
            while (rs.next()) {
                OrderID = rs.getString(1);
                ProductID = rs.getString(2);
                UnitPrice = rs.getFloat(3);
                Quantity = rs.getInt(4);
                OrderDetails orderDetails = new OrderDetails(OrderID, ProductID, UnitPrice, Quantity);
                orderDetailsList.add(orderDetails);
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
        return orderDetailsList;
    }

    //add Order
    public boolean addOrderDetails(OrderDetails orderDetails) throws Exception {
        Connection cnn = null;
        PreparedStatement preStm = null;
        try {
            cnn = getConnection();
            String sql
                    = "INSERT INTO [Order Details] (OrderID, ProductID, UnitPrice, Quantity) VALUES(?,?,?,?)";
            preStm = cnn.prepareStatement(sql);
            preStm.setString(1, orderDetails.getOrderID());
            preStm.setString(2, orderDetails.getProductID());
            preStm.setFloat(3, orderDetails.getUnitPrice());
            preStm.setInt(4, orderDetails.getQuantity());
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

    //delete Order
    public void deleteOrderDetails(String OrderID, String ProductID) throws Exception {
        Connection cnn = null;
        PreparedStatement preStm = null;
        try {
            cnn = getConnection();
            String sql
                    = "DELETE from [Order Details] WHERE OrderID=? AND ProductID=?";
            preStm = cnn.prepareStatement(sql);
            preStm.setString(1, OrderID);
            preStm.setString(2, ProductID);
            preStm.executeUpdate();
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

    //update Order
    public boolean updateOrderDetails(OrderDetails orderDetails) throws Exception {
        Connection cnn = null;
        PreparedStatement preStm = null;
        try {
            cnn = getConnection();
            String sql
                    = "UPDATE [Order Details] SET UnitPrice=?, Quantity=? WHERE OrderID=? AND ProductID=?";
            preStm = cnn.prepareStatement(sql);
            preStm.setFloat(1, orderDetails.getUnitPrice());
            preStm.setInt(2, orderDetails.getQuantity());
            preStm.setString(3, orderDetails.getOrderID());
            preStm.setString(4, orderDetails.getProductID());
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
