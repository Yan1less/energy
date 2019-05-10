package com.yan1less.enegry.mapper;

import com.yan1less.enegry.annotation.DataSource;
import com.yan1less.enegry.pojo.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author Yan1less
 * @Date 2019/5/2 9:57
 * @Description TODO
 **/
@Mapper
public interface MyMapper {
    @DataSource("test")
    public List<blogtext> selectAll();


    List<enegry> selectEnegry();


    List<humidity> selectHumidity();

    List<temperature> selectTemperature();



    //    @Select("select device,total,failure from tb_devicefailure where factory=#{factory}")
//    @Results({
//            @Result(property = "device_name" ,column = "device"),
//            @Result(property = "total_number" ,column = "total"),
//            @Result(property = "error_number" ,column = "failure")
//    })
    List<deviceSQL> selectDevice(String curDate,String factory);

    List<String> selectDates();

    List<String> selectFactories();



    List<eventSQL> selectEvent(String location,String curDate);

    List<String> selectEventDates();

    List<String> selectEventLocations();
}
