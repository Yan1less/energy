package com.yan1less.enegry.pojo;

import java.util.List;

public class deviceJSON {
    private Integer id;
    private String factory;
    private String time;
    private List<deviceInfo> device_info;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFactory() {
        return factory;
    }

    public void setFactory(String factory) {
        this.factory = factory;
    }

    public String getTime() {
        return time;
    }



    public void setTime(String time) {
        this.time = time;
    }

    public List<deviceInfo> getDevice_info() {
        return device_info;
    }

    public void setDevice_info(List<deviceInfo> device_info) {
        this.device_info = device_info;
    }



}
