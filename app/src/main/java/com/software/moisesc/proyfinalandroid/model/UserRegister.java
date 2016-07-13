package com.software.moisesc.proyfinalandroid.model;

import com.orm.SugarRecord;

public class UserRegister extends SugarRecord {
    private String user;
    private String email;


    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserRegister() {
        user = "";
        email = "";

    }

}
