package Models.DAO;

import Models.Entities.Order;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO {

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

    //get Order List
    public List<Order> getOrderList() throws Exception {
        String OrderID, CustomerID, OrderDate, RequiredDate, ShippedDate, ShipAddress;
        int Freight;
        List<Order> orderList = new ArrayList();
        Connection cnn = null;
        PreparedStatement preStm = null;
        ResultSet rs = null;
        try {
            cnn = getConnection();
            String sql
                    = "SELECT OrderID, CustomerID, OrderDate, RequiredDate, ShippedDate, "
                    + "Freight, ShipAddress FROM Orders";
            preStm = cnn.prepareStatement(sql);
            rs = preStm.executeQuery();
            while (rs.next()) {
                OrderID = rs.getString(1);
                CustomerID = rs.getString(2);
                OrderDate = rs.getString(3);
                RequiredDate = rs.getString(4);
                ShippedDate = rs.getString(5);
                Freight = rs.getInt(6);
                ShipAddress = rs.getString(7);
                Order order = new Order(OrderID, CustomerID, OrderDate, RequiredDate, ShippedDate, Freight, ShipAddress);
                orderList.add(order);
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
        return orderList;
    }

    //add Order
    public boolean addOrder(Order order) throws Exception {
        Connection cnn = null;
        PreparedStatement preStm = null;
        try {
            cnn = getConnection();
            String sql
                    = "INSERT INTO Orders (OrderID, CustomerID, OrderDate, RequiredDate, ShippedDate, Freight, ShipAddress) VALUES(?,?,?,?,?,?,?)";
            preStm = cnn.prepareStatement(sql);
            preStm.setString(1, order.getOrderID());
            preStm.setString(2, order.getCustomerID());
            preStm.setString(3, order.getOrderDate());
            preStm.setString(4, order.getRequiredDate());
            preStm.setString(5, order.getShippedDate());
            preStm.setInt(6, order.getFreight());
            preStm.setString(7, order.getShipAddress());
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
    public void deleteOrder(String OrderID) throws Exception {
        Connection cnn = null;
        PreparedStatement preStm = null;
        try {
            cnn = getConnection();
            String sql
                    = "DELETE from Orders WHERE OrderID=?";
            preStm = cnn.prepareStatement(sql);
            preStm.setString(1, OrderID);
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
    public boolean updateOrder(Order order) throws Exception {
        Connection cnn = null;
        PreparedStatement preStm = null;
        try {
            cnn = getConnection();
            String sql
                    = "UPDATE Orders SET CustomerID=?, OrderDate=?, RequiredDate=?, ShippedDate=?, Freight=?, ShipAddress=? WHERE OrderID=?";
            preStm = cnn.prepareStatement(sql);
            preStm.setString(1, order.getCustomerID());
            preStm.setString(2, order.getOrderDate());
            preStm.setString(3, order.getRequiredDate());
            preStm.setString(4, order.getShippedDate());
            preStm.setInt(5, order.getFreight());
            preStm.setString(6, order.getShipAddress());
            preStm.setString(7, order.getOrderID());
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
    
    //get recent order
    public String getRecentOrderID() {
        String mostRecentOrderID = "O000";
        try {
            List<Order> orderList = new ArrayList<>(new OrderDAO().getOrderList());
            for (Order order : orderList) {
                if (order.getOrderID().compareTo(mostRecentOrderID) > 0) {
                    mostRecentOrderID = order.getOrderID();
                }
            }
            int numPart = Integer.parseInt(mostRecentOrderID.substring(1)) + 1;
            int numPartSize = Integer.toString(numPart).length();
            mostRecentOrderID = mostRecentOrderID.substring(0, mostRecentOrderID.length() - numPartSize).concat(Integer.toString(numPart));
        } catch (Exception e) {
        }
        return mostRecentOrderID;
    }
}
