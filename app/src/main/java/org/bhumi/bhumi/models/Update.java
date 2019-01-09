package org.bhumi.bhumi.models;

import java.util.Date;

public class Update {

    int id;
    String title;
    Date time;
    String info;

    public Update(int id, String title, Date time, String info) {
        this.id = id;
        this.title = title;
        this.time = time;
        this.info = info;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
