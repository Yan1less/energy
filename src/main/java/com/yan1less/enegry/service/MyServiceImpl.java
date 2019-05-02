package com.yan1less.enegry.service;

import com.google.gson.Gson;
import com.yan1less.enegry.mapper.MyMapper;
import com.yan1less.enegry.pojo.blogtext;
import com.yan1less.enegry.pojo.enegry;
import com.yan1less.enegry.pojo.humidity;
import com.yan1less.enegry.pojo.temperature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Yan1less
 * @Date 2019/5/2 9:56
 * @Description TODO
 **/
@Service
public class MyServiceImpl implements MyService {

    @Autowired
    private MyMapper myMapper;


    @Override
    public List<blogtext> myTest() {
        return myMapper.selectAll();
    }

    @Override
    public String selectEnegry() {
        List<enegry> enegries = myMapper.selectEnegry();
        Gson gson = new Gson();
        String res = "{\"RECORDS\":"+
                gson.toJson(enegries)+"}";
        return res;
    }

    @Override
    public String selectHumidity() {
        List<humidity> humidities = myMapper.selectHumidity();
        Gson gson = new Gson();
        String res = "{\"RECORDS\":"+
                gson.toJson(humidities)+"}";
        return res;
    }

    @Override
    public String selectTemperature() {
        List<temperature> temperatures = myMapper.selectTemperature();
        Gson gson = new Gson();
        String res = "{\"RECORDS\":"+
                gson.toJson(temperatures)+"}";
        return res;
    }
}
