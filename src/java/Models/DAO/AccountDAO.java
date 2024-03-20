package Models.DAO;

import Models.Entities.Account;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AccountDAO {

    // connect database
    public Connection getConnection() throws Exception {
        try {
            //load driver cho sql server 
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //Connect to database Manager in localhost, using username: "sa" and pass: "12345"
            Connection cnn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;database=MyPizzaShop", "sa", "12345");
            return cnn;
        } catch (Exception ex) {
            throw ex;
        }
    }

    // getAccountList
    public List<Account> getAccountList() throws Exception {
        String AccountID, UserName, Password, FullName;
        int Type;
        Connection cnn = null;
        PreparedStatement preStm = null;
        ResultSet rs = null;
        List<Account> accountList = new ArrayList();
        try {
            cnn = getConnection();
            String sql = "Select AccountID, UserName, Password, FullName, Type From Account";
            preStm = cnn.prepareStatement(sql);
            rs = preStm.executeQuery();
            while (rs.next()) {
                AccountID = rs.getString(1);
                UserName = rs.getString(2);
                Password = rs.getString(3);
                FullName = rs.getString(4);
                Type = rs.getInt(5);
                Account newAccount = new Account(AccountID, UserName, Password, FullName, Type);
                accountList.add(newAccount);
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
        return accountList;
    }

    // updateAccount
    public boolean updateAccount(Account account) throws Exception {
        PreparedStatement preStm = null;
        Connection cnn = null;
        try {
            cnn = getConnection();
            String sql = "Update Account Set UserName=?, Password=?, FullName = ?, Type=?, Where AccountID=?";
            preStm = cnn.prepareStatement(sql);
            preStm.setString(1, account.getUserName());
            preStm.setString(2, account.getPassword());
            preStm.setString(3, account.getFullName());
            preStm.setInt(4, account.getType());
            preStm.setString(5, account.getAccountID());
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

    // addAccount
    public boolean addAccount(Account account) throws Exception {
        PreparedStatement preStm = null;
        Connection cnn = null;
        try {
            cnn = getConnection();
            String sql = "Insert Account Values (?,?,?,?,?)";
            preStm = cnn.prepareStatement(sql);
            preStm.setString(1, account.getAccountID());
            preStm.setString(2, account.getUserName());
            preStm.setString(3,  account.getPassword());
            preStm.setString(4, account.getFullName());
            preStm.setInt(5, account.getType());
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

    // deleteAccount
    public boolean deleteAccount(String AccountID) throws Exception {
        PreparedStatement preStm = null;
        Connection cnn = null;
        try {
            cnn = getConnection();
            String sql = "Delete Account Where AccountID=?";
            preStm = cnn.prepareStatement(sql);
            preStm.setString(1, AccountID);
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

    // getAccountByID
    public Account getAccountByID(String AccountID) throws Exception {
        String UserName, Password, FullName;
        int Type;
        Connection cnn = null;
        PreparedStatement preStm = null;
        ResultSet rs = null;
        Account newAccount = null;
        try {
            cnn = getConnection();
            String sql = "Select UserName, Password, FullName, Type  From Account Where AccountID = ?";
            preStm = cnn.prepareStatement(sql);
            preStm.setString(1, AccountID);
            rs = preStm.executeQuery();
            while (rs.next()) {
                UserName = rs.getString(1);
                Password = rs.getString(2);
                FullName = rs.getString(3);
                Type = rs.getInt(4);
                newAccount = new Account(AccountID, UserName, Password, FullName, Type);
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
        return newAccount;
    }
    // login
    public Account Login(String AccountID, String Password) throws Exception {
        Account account = null;
        Connection cnn = null;
        PreparedStatement preStm = null;
        ResultSet rs = null;
        String UserName;
        String FullName;
        int Type;
        try {
            cnn = getConnection();
            String sql = "select UserName, FullName, Type from Account where [AccountID] = ? and [Password] = ?";
            preStm = cnn.prepareStatement(sql);
            preStm.setString(1, AccountID);
            preStm.setString(2, Password);
            rs = preStm.executeQuery();
            while (rs.next()) {
                UserName = rs.getString(1);
                FullName = rs.getString(2);
                Type = rs.getInt(3);
                account = new Account(AccountID, UserName, Password, FullName, Type);
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
        return account;
    }
}
