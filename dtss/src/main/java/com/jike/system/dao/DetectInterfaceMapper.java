package com.jike.system.dao;

import com.jike.system.bean.DetectInterface;
import com.jike.system.bean.DetectInterfaceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DetectInterfaceMapper {
    int countByExample(DetectInterfaceExample example);

    int deleteByExample(DetectInterfaceExample example);

    int deleteByPrimaryKey(String taskId);

    int insert(DetectInterface record);

    int insertSelective(DetectInterface record);

    List<DetectInterface> selectByExample(DetectInterfaceExample example);

    DetectInterface selectByPrimaryKey(String taskId);

    int updateByExampleSelective(@Param("record") DetectInterface record, @Param("example") DetectInterfaceExample example);

    int updateByExample(@Param("record") DetectInterface record, @Param("example") DetectInterfaceExample example);

    int updateByPrimaryKeySelective(DetectInterface record);

    int updateByPrimaryKey(DetectInterface record);
}