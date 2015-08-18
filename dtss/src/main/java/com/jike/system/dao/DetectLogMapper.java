package com.jike.system.dao;

import com.jike.system.bean.DetectLog;
import com.jike.system.bean.DetectLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DetectLogMapper {
    int countByExample(DetectLogExample example);

    int deleteByExample(DetectLogExample example);

    int deleteByPrimaryKey(String logId);

    int insert(DetectLog record);

    int insertSelective(DetectLog record);

    List<DetectLog> selectByExample(DetectLogExample example);

    DetectLog selectByPrimaryKey(String logId);

    int updateByExampleSelective(@Param("record") DetectLog record, @Param("example") DetectLogExample example);

    int updateByExample(@Param("record") DetectLog record, @Param("example") DetectLogExample example);

    int updateByPrimaryKeySelective(DetectLog record);

    int updateByPrimaryKey(DetectLog record);
}