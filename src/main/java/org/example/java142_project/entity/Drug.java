package org.example.java142_project.entity;

public class Drug {
    private int cid;
    private String cname;
    private String cdescp;
    private String lastdate;

    @Override
    public String toString() {
        return cname;
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
}
