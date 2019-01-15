package org.bhumi.bhumi.models;

public class Orientation extends Update {

    String address;

    public Orientation(int id, String address,String city, long date, String contact, String register_url) {
        super(id, city, date, contact, register_url);
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
