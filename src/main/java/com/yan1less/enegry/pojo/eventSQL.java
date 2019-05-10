package com.yan1less.enegry.pojo;

public class eventSQL {
    private Integer id;
    private String location;
    private String eventtype;
    private String  eventmessage;
    private Integer eventlevel;
    private Integer error_num;
    private String curDate;

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

    public String getEventtype() {
        return eventtype;
    }

    public void setEventtype(String eventtype) {
        this.eventtype = eventtype;
    }

    public String getEventmessage() {
        return eventmessage;
    }

    public void setEventmessage(String eventmessage) {
        this.eventmessage = eventmessage;
    }

    public Integer getEventlevel() {
        return eventlevel;
    }

    public void setEventlevel(Integer eventlevel) {
        this.eventlevel = eventlevel;
    }

    public Integer getError_num() {
        return error_num;
    }

    public void setError_num(Integer error_num) {
        this.error_num = error_num;
    }

    public String getCurDate() {
        return curDate;
    }

    public void setCurDate(String curDate) {
        this.curDate = curDate;
    }
}
