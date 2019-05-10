package com.yan1less.enegry.service;

import com.yan1less.enegry.pojo.blogtext;
import com.yan1less.enegry.pojo.enegry;

import java.util.List;

/**
 * @Author Yan1less
 * @Date 2019/5/2 9:56
 * @Description TODO
 **/
public interface MyService {
    public List<blogtext> myTest();


    String selectEnegry();

    String selectHumidity();

    String selectTemperature();

    String selectDevice();

    String selectEvent();
}
