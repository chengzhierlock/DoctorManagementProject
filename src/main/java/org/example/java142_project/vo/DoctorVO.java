package org.example.java142_project.vo;

import org.example.java142_project.entity.Doctor;

public class DoctorVO extends Doctor {
    private String loginName;
    private String pass;
    private int roleid;
    private int islogin;
    private String jobname;
    private String departname;
    private String edname;
    private String iconimg;
    public DoctorVO() {}

    @Override
    public String toString() {
        return "DoctorVO{" +
                "loginName='" + loginName + '\'' +
                ", pass='" + pass + '\'' +
                ", roleid=" + roleid +
                ", islogin=" + islogin +
                ", jobname='" + jobname + '\'' +
                ", departname='" + departname + '\'' +
                ", edname='" + edname + '\'' +
                ", iconimg='" + iconimg + '\'' +
                "} " + super.toString();
    }

    public String getLoginName() {
        return loginName;
    }


    public void setLoginName(String loginName) {
        this.loginName = loginName;
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

    public String getJobname() {
        return jobname;
    }

    public void setJobname(String jobname) {
        this.jobname = jobname;
    }

    public String getDepartname() {
        return departname;
    }

    public void setDepartname(String departname) {
        this.departname = departname;
    }

    public String getEdname() {
        return edname;
    }

    public void setEdname(String edname) {
        this.edname = edname;
    }

    @Override
    public String getIconimg() {
        return iconimg;
    }

    @Override
    public void setIconimg(String iconimg) {
        this.iconimg = iconimg;
    }
}
