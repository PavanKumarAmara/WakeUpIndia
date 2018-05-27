package com.example.pavan_6860.wakeupindia.model;

import java.sql.Blob;
import java.util.List;

public class Record {
    private String userName;
    private String password;

    public Blob getImage() {
        return image;
    }

    public void setImage(Blob image) {
        this.image = image;
    }

    private Blob image;


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
