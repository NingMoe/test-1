package com.jike.system.dao;

import com.jike.system.bean.DetectDatabase;
import com.jike.system.bean.DetectDatabaseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DetectDatabaseMapper {
    int countByExample(DetectDatabaseExample example);

    int deleteByExample(DetectDatabaseExample example);

    int deleteByPrimaryKey(String taskId);

    int insert(DetectDatabase record);

    int insertSelective(DetectDatabase record);

    List<DetectDatabase> selectByExample(DetectDatabaseExample example);

    DetectDatabase selectByPrimaryKey(String taskId);

    int updateByExampleSelective(@Param("record") DetectDatabase record, @Param("example") DetectDatabaseExample example);

    int updateByExample(@Param("record") DetectDatabase record, @Param("example") DetectDatabaseExample example);

    int updateByPrimaryKeySelective(DetectDatabase record);

    int updateByPrimaryKey(DetectDatabase record);
}