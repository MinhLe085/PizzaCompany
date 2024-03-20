
package Models.Entities;

public class Account {
    public String AccountID;
    public String UserName;
    public String Password;
    public String FullName;
    public int Type;

    public Account() {
    }

    public Account(String AccountID, String UserName, String Password, String FullName, int Type) {
        this.AccountID = AccountID;
        this.UserName = UserName;
        this.Password = Password;
        this.FullName = FullName;
        this.Type = Type;
    }

    public String getAccountID() {
        return AccountID;
    }

    public void setAccountID(String AccountID) {
        this.AccountID = AccountID;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String FullName) {
        this.FullName = FullName;
    }

    public int getType() {
        return Type;
    }

    public void setType(int Type) {
        this.Type = Type;
    }

    @Override
    public String toString() {
        return String.format("%s|%s|%s|%s|%d", AccountID, UserName, Password, FullName, FullName, Type);
    }
    
    
}