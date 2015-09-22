package com.example.habibi.listviewexample;

/**
 * Created by habibi on 2015-09-22.
 */
public class CoffeeShops {
    private String tel;
    private String address;
    private String name;
    private int iconID;


    public CoffeeShops(String tel, String address, String name, int iconID) {
        this.tel = tel;
        this.address = address;
        this.name = name;
        this.iconID = iconID;

    }

    public String getTel() {
        return tel;
    }

    public String getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIconID() {
        return iconID;
    }

    public void setIconID(int iconID) {
        this.iconID = iconID;
    }
}