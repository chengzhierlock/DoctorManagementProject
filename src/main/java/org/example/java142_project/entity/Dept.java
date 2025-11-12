package org.example.java142_project.entity;

public class Dept {
    private int deptid;
    private String deptname;
    private String deptdescp;

    public Dept() {

    }

    @Override
    public String toString() {
        return this.deptname;
    }

    public int getDeptid() {
        return deptid;
    }

    public void setDeptid(int deptid) {
        this.deptid = deptid;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    public String getDeptdescp() {
        return deptdescp;
    }

    public void setDeptdescp(String deptdescp) {
        this.deptdescp = deptdescp;
    }
}
