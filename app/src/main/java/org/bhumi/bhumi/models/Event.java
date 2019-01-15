package org.bhumi.bhumi.models;

public class Event extends Update{

    String title;
    String content;
    String image_url;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Event(int id, String title, String content, String city, long date, String contact, String register_url, String image_url) {
        super(id, city, date, contact, register_url);
        this.title = title;
        this.content = content;
        this.image_url = image_url;
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

    public String getImageUrl() {
        return image_url;
    }

}
