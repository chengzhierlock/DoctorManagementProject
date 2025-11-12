package org.example.java142_project.entity;

public class Doctor {
    private int did;
    private String name;
    private String gender;
    private String birthday;
    private int joid;
    private int deid;
    private int edid;
    private String iconimg;
    public Doctor() {}

    @Override
    public String toString() {
        return "Doctor{" +
                "did=" + did +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", birthday='" + birthday + '\'' +
                ", joid=" + joid +
                ", deid=" + deid +
                ", edid=" + edid +
                ", iconimg='" + iconimg + '\'' +
                '}';
    }

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public int getJoid() {
        return joid;
    }

    public void setJoid(int joid) {
        this.joid = joid;
    }

    public int getDeid() {
        return deid;
    }

    public void setDeid(int deid) {
        this.deid = deid;
    }

    public int getEdid() {
        return edid;
    }

    public void setEdid(int edid) {
        this.edid = edid;
    }

    public String getIconimg() {
        return iconimg;
    }

    public void setIconimg(String iconimg) {
        this.iconimg = iconimg;
    }
}
