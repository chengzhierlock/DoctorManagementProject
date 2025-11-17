package org.example.java142_project.entity;

public class Support {
    private int supportid;
    private String supname;
    private String tel;
    private String email;
    private String address;
    private String supdesc;

    @Override
    public String toString() {
        return supname;
    }

    public int getSupportid() {
        return supportid;
    }

    public void setSupportid(int supportid) {
        this.supportid = supportid;
    }

    public String getSupname() {
        return supname;
    }

    public void setSupname(String supname) {
        this.supname = supname;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSupdesc() {
        return supdesc;
    }

    public void setSupdesc(String supdesc) {
        this.supdesc = supdesc;
    }
}
