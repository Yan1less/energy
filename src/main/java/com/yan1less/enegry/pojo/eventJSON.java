package com.yan1less.enegry.pojo;

import java.util.List;

public class eventJSON {
    private Integer id;
    private String location;
    private String time;
    private List<eventInfo> event_info;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public List<eventInfo> getEvent_infp() {
        return event_info;
    }

    public void setEvent_info(List<eventInfo> event_info) {
        this.event_info = event_info;
    }
}
