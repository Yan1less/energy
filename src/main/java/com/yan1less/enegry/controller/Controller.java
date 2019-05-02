package com.yan1less.enegry.controller;

import com.yan1less.enegry.pojo.blogtext;
import com.yan1less.enegry.pojo.enegry;
import com.yan1less.enegry.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author Yan1less
 * @Date 2019/5/2 9:58
 * @Description TODO
 **/
@RestController
@RequestMapping("/other")
public class Controller {

    @Autowired
    private MyService myService;

    @RequestMapping("/test")
    public List<blogtext> myTest(){
        return  myService.myTest();
    }

    @RequestMapping("/energy")
    public String selectEnegry(){
        return  myService.selectEnegry();
    }

    @RequestMapping("/humidity")
    public String selectHumidity(){
        return  myService.selectHumidity();
    }

    @RequestMapping("/temperature")
    public String selectTemperature(){
        return  myService.selectTemperature();
    }



}
