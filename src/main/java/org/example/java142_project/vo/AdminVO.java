package org.example.java142_project.vo;

import org.example.java142_project.entity.Admin;

public class AdminVO extends Admin {
    private String loginname;
    private String pass;
    private int roleid;
    private int islogin;

    @Override
    public String toString() {
        return "AdminVO{" +
                ", loginname='" + loginname + '\'' +
                ", pass='" + pass + '\'' +
                ", roleid=" + roleid +
                ", islogin=" + islogin +
                "} " + super.toString();
    }


    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getRoleid() {
        return roleid;
    }

    public void setRoleid(int roleid) {
        this.roleid = roleid;
    }

    public int getIslogin() {
        return islogin;
    }

    public void setIslogin(int islogin) {
        this.islogin = islogin;
    }
}
