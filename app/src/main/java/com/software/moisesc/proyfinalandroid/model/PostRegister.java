package com.software.moisesc.proyfinalandroid.model;

import com.orm.SugarRecord;

public class PostRegister extends SugarRecord {
    private String title;
    private String content;


    public PostRegister() {
        title = "";
        content = "";

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }



    @Override
    public String toString() {
        return title;
    }
}
