package org.example.java142_project.entity;

public class Education {
    private int eid;
    private String ename;
    private String edescp;
    public Education() {

    }

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getEdescp() {
        return edescp;
    }

    public void setEdescp(String edescp) {
        this.edescp = edescp;
    }

    @Override
    public String toString() {
        return this.ename;
    }
}
