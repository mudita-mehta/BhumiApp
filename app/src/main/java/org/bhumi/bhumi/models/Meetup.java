 package org.bhumi.bhumi.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Meetup {

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("contact")
    @Expose
    private Integer contact;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("info")
    @Expose
    private String info;
    @SerializedName("imageUrl")
    @Expose
    private String imageUrl;

    public interface OnListFragmentInteractionListener {
        void onListFragmentInteraction(Meetup meetup);
        void onRegisterFragmentInteraction(Meetup meetup);
        void onContactButtonClickedFragmentInteraction(Meetup meetup);
        void onShareButtonClickedFragmentInteracton(Meetup meetup);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getContact() {
        return contact;
    }

    public void setContact(Integer contact) {
        this.contact = contact;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

}
