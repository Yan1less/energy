package com.yan1less.enegry.service;

import com.google.gson.Gson;
import com.yan1less.enegry.mapper.MyMapper;
import com.yan1less.enegry.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Override
    public String selectDevice() {
        Map<Integer,String> map =  new HashMap<>();
        map.put(1,"厂区A");
        map.put(2,"厂区B");
        map.put(3,"厂区C");
        map.put(4,"厂区D");
        map.put(5,"厂区E");
//        map.put(1,"厂区A");
        StringBuffer result = new StringBuffer();
        for (int i =1;i<=5;i++) {
            result.append(DeviceTools(i, map.get(i)));
            if(i!=5)
                result.append(",");
        }
        return "["+result.toString()+"]";
    }

    @Override
    public String selectEvent() {
        Map<Integer,String> map =  new HashMap<>();
        map.put(1,"数据中心A");
        map.put(2,"数据中心B");
        map.put(3,"数据中心C");
        map.put(4,"数据中心D");
        map.put(5,"数据中心E");

        StringBuffer result = new StringBuffer();
        for (int i =1;i<=5;i++) {
            result.append(EventTools(i, map.get(i)));
            if(i!=5)
                result.append(",");
        }
        return "["+result.toString()+"]";
    }

    private String DeviceTools(Integer id,String factory){
        List<deviceSQL> list = myMapper.selectDevice(factory);
        deviceJSON json = new deviceJSON();
        json.setFactory(factory);
        json.setId(id);
        json.setTime(list.get(0).getCurDate());
        List<deviceInfo> deviceInfos = new ArrayList<>();
        for(deviceSQL i:list){
            deviceInfo deviceInfo = new deviceInfo();
            deviceInfo.setDevice_name(i.getDevice());
            deviceInfo.setError_number(i.getFailure());
            deviceInfo.setTotal_number(i.getTotal());
            deviceInfos.add(deviceInfo);
        }
        json.setDevice_info(deviceInfos);
        Gson gson = new Gson();
        String s = gson.toJson(json);
        return s;
    }



    private String EventTools(Integer id,String location){
        List<eventSQL> list = myMapper.selectEvent(location);
        eventJSON json = new eventJSON();
        json.setTime(list.get(0).getCurDate());
        json.setLocation(location);
        json.setId(id);
        List<eventInfo> eventInfos = new ArrayList<>();
        for(eventSQL i:list){
            eventInfo info = new eventInfo();
            info.setEvent_type(i.getEventtype());
            info.setWarning_info(i.getEventmessage());
            info.setWarning_number(i.getError_num());
            eventInfos.add(info);
        }
        json.setEvent_info(eventInfos);
        Gson gson = new Gson();
        String s = gson.toJson(json);
        return s;
    }



}
