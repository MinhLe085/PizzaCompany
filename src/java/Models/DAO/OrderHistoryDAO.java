package Models.DAO;

import Models.Entities.OrderHistory;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderHistoryDAO {

    //get connection to database
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

    public List<OrderHistory> getOrderHistoryList(String CusID) throws Exception {
        String OrderID, CustomerID, OrderDate, RequiredDate, ShippedDdate, ShipAddress, ProductID;
        int Freight, Quantity;
        float UnitPrice;
        Connection cnn = null;
        PreparedStatement preStm = null;
        ResultSet rs = null;
        List<OrderHistory> orderHistoryList = new ArrayList();
        try {
            cnn = getConnection();
            String sql
                    = "SELECT o.OrderID, o.CustomerID, o.OrderDate, o.RequiredDate, o.ShippedDate, "
                    + "o.Freight, o.ShipAddress, od.ProductID, od.Quantity, od.UnitPrice FROM Orders o JOIN [Order Details] od "
                    + "ON o.OrderID = od.OrderID "
                    + "WHERE o.CustomerID = ?";
            preStm = cnn.prepareStatement(sql);
            preStm.setString(1, CusID);
            rs = preStm.executeQuery();
            while (rs.next()) {
                OrderID = rs.getString(1);
                CustomerID = rs.getString(2);
                OrderDate = rs.getString(3);
                RequiredDate = rs.getString(4);
                ShippedDdate = rs.getString(5);
                Freight = rs.getInt(6);
                ShipAddress = rs.getString(7);
                ProductID = rs.getString(8);
                Quantity = rs.getInt(9);
                UnitPrice = rs.getFloat(10);
                OrderHistory order = new OrderHistory(OrderID, CustomerID, OrderDate, RequiredDate, ShippedDdate, Freight, ShipAddress, ProductID, Quantity, UnitPrice);
                orderHistoryList.add(order);
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
        if (orderHistoryList.isEmpty()) {
            return null;
        }
        return orderHistoryList;
    }
}
