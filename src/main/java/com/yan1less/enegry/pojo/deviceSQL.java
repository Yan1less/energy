package com.yan1less.enegry.pojo;

import java.util.List;

public class deviceSQL {
    private Integer id;
    private String factory;
    private String device;
    private Integer total;
    private Integer failure;
    private String curDate;

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

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getFailure() {
        return failure;
    }

    public void setFailure(Integer failure) {
        this.failure = failure;
    }

    public String getCurDate() {
        return curDate;
    }

    public void setCurDate(String curDate) {
        this.curDate = curDate;
    }
}
