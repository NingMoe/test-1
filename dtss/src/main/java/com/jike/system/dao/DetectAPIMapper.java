package com.jike.system.dao;

import com.jike.system.bean.DetectAPI;
import com.jike.system.bean.DetectAPIExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DetectAPIMapper {
    int countByExample(DetectAPIExample example);

    int deleteByExample(DetectAPIExample example);

    int deleteByPrimaryKey(String taskId);

    int insert(DetectAPI record);

    int insertSelective(DetectAPI record);

    List<DetectAPI> selectByExample(DetectAPIExample example);

    DetectAPI selectByPrimaryKey(String taskId);

    int updateByExampleSelective(@Param("record") DetectAPI record, @Param("example") DetectAPIExample example);

    int updateByExample(@Param("record") DetectAPI record, @Param("example") DetectAPIExample example);

    int updateByPrimaryKeySelective(DetectAPI record);

    int updateByPrimaryKey(DetectAPI record);
}