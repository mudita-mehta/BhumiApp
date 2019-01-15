package org.bhumi.bhumi.models;

import java.util.Date;

public class Update {

    int id;
    String city;
    long date;
    String contact;
    String register_url;

    public Update(int id, String city, long date, String contact, String register_url) {
        this.id = id;
        this.city = city;
        this.date = date;
        this.contact = contact;
        this.register_url = register_url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public interface OnListFragmentInteractionListener {
        void onListFragmentInteraction(Update update);
        void onRegisterFragmentInteraction(Update update);
        void onContactButtonClickedFragmentInteraction(Update update);
        void onShareButtonClickedFragmentInteracton(Update update);
    }
}
