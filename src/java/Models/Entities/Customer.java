
package Models.Entities;

/**
 *
 * @author Minh Le
 */
public class Customer {

    public String CustomerID;
    public String Password;
    public String ContactName;
    public String Address;
    public String Phone;

    public Customer() {
    }

    public Customer(String CustomerID, String Password, String ContactName, String Address, String Phone) {
        this.CustomerID = CustomerID;
        this.Password = Password;
        this.ContactName = ContactName;
        this.Address = Address;
        this.Phone = Phone;
    }

    public String getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(String CustomerID) {
        this.CustomerID = CustomerID;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getContactName() {
        return ContactName;
    }

    public void setContactName(String ContactName) {
        this.ContactName = ContactName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    @Override
    public String toString() {
        return String.format("%s|%s|%s|%s|%s", CustomerID, Password, ContactName, Address, Phone);
    }
    
}
