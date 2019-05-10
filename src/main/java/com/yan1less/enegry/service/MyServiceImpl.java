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
        List<String> date = myMapper.selectDates();
        List<String> factorys = myMapper.selectFactories();
        int num = 1;
        StringBuffer res = new StringBuffer();
        for(int i=0;i<date.size();i++){
            for(int j =0;j<factorys.size();j++){
                if(i==date.size()-1 && j==factorys.size()-1)
                    res.append(DeviceTools(num++,date.get(i),factorys.get(j)));
                else
                    res.append(DeviceTools(num++,date.get(i),factorys.get(j))+",");
            }
        }

        return "["+res.toString()+"]";

    }



    @Override
    public String selectEvent() {

        List<String> date = myMapper.selectEventDates();
        List<String> locations = myMapper.selectEventLocations();
        int num = 1;
        StringBuffer res = new StringBuffer();
        for(int i=0;i<date.size();i++){
            for(int j =0;j<locations.size();j++){
                if(i==date.size()-1 && j==locations.size()-1)
                    res.append(EventTools(num++,date.get(i),locations.get(j)));
                else
                    res.append(EventTools(num++,date.get(i),locations.get(j))+",");
            }
        }

        return "["+res.toString()+"]";

    }




    private String DeviceTools(Integer id,String curDate,String factory){
        List<deviceSQL> deviceSQLS = myMapper.selectDevice(curDate,factory);
        deviceJSON json = new deviceJSON();
        json.setFactory(factory);
        json.setId(id);
        json.setTime(curDate);
        List<deviceInfo> deviceInfos = new ArrayList<>();
        for(deviceSQL i:deviceSQLS){
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

    private String EventTools(Integer id,String curDate,String location){
        List<eventSQL> list = myMapper.selectEvent(location,curDate);
        eventJSON json = new eventJSON();
        json.setTime(curDate);
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
