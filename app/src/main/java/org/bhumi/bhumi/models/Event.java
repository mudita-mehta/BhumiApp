package org.bhumi.bhumi.models;

import java.util.Date;

public class Event {
    int id;
    String title;
    String text;
    String city;
    long date;
    String contact;
    String register_url;
    String image_url;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Event(int id, String title, String text, String city, long date, String contact, String register_url, String image_url) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.city = city;
        this.date = date;
        this.contact = contact;
        this.register_url = register_url;
        this.image_url = image_url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getRegister_url() {
        return register_url;
    }

    public void setRegister_url(String register_url) {
        this.register_url = register_url;
    }

    public String getImageUrl() {
        return image_url;
    }

    public void setImageUrl(String image_url) {
        this.image_url = image_url;
    }
}
