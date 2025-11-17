package org.example.java142_project.vo;

import org.example.java142_project.entity.Drugs;

public class DrugVO extends Drugs {
    private int cid;
    private String cname;
    private String cdescp;
    private String lastdate;
    private int suid;
    private String supname;
    private String tel;
    private String email;
    private String address;
    private String supdesc;

    @Override
    public String toString() {
        return "DrugVO{" +
                "cid=" + cid +
                ", cname='" + cname + '\'' +
                ", cdescp='" + cdescp + '\'' +
                ", lastdate='" + lastdate + '\'' +
                ", suid=" + suid +
                ", supname='" + supname + '\'' +
                ", tel='" + tel + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", supdesc='" + supdesc + '\'' +
                "} " + super.toString();
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCdescp() {
        return cdescp;
    }

    public void setCdescp(String cdescp) {
        this.cdescp = cdescp;
    }

    public String getLastdate() {
        return lastdate;
    }

    public void setLastdate(String lastdate) {
        this.lastdate = lastdate;
    }

    public int getSuid() {
        return suid;
    }

    public void setSuid(int suid) {
        this.suid = suid;
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
