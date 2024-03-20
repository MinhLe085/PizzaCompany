/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.Entities;

public class Supplier {

    private String SupplierID, CompanyName, Address, Phone;

    public Supplier() {
    }

    public Supplier(String SupplierID, String CompanyName, String Address, String Phone) {
        this.SupplierID = SupplierID;
        this.CompanyName = CompanyName;
        this.Address = Address;
        this.Phone = Phone;
    }

    public String getSupplierID() {
        return SupplierID;
    }

    public void setSupplierID(String SupplierID) {
        this.SupplierID = SupplierID;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String CompanyName) {
        this.CompanyName = CompanyName;
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
        return "Supplier{" + "SupplierID=" + SupplierID + ", CompanyName=" + CompanyName + ", Address=" + Address + ", Phone=" + Phone + '}';
    }

}
