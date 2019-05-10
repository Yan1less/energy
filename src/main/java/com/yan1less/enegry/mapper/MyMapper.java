package com.yan1less.enegry.mapper;

import com.yan1less.enegry.annotation.DataSource;
import com.yan1less.enegry.pojo.*;
import org.apache.ibatis.annotations.Mapper;

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

    List<deviceSQL> selectDevice(String factory);

    List<eventSQL> selectEvent(String location);
}
