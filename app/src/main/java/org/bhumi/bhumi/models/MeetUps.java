package org.bhumi.bhumi.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class MeetUps {

    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("meetups")
    @Expose
    private List<Meetup> meetups = null;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public List<Meetup> getMeetups() {
        return meetups;
    }

    public void setMeetups(List<Meetup> meetups) {
        this.meetups = meetups;
    }

}