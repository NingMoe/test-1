package com.jike.system.dao;

import com.jike.system.bean.DetectInterfaceLog;
import com.jike.system.bean.DetectInterfaceLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DetectInterfaceLogMapper {
    int countByExample(DetectInterfaceLogExample example);

    int deleteByExample(DetectInterfaceLogExample example);

    int deleteByPrimaryKey(String itfLogId);

    int insert(DetectInterfaceLog record);

    int insertSelective(DetectInterfaceLog record);

    List<DetectInterfaceLog> selectByExample(DetectInterfaceLogExample example);

    DetectInterfaceLog selectByPrimaryKey(String itfLogId);

    int updateByExampleSelective(@Param("record") DetectInterfaceLog record, @Param("example") DetectInterfaceLogExample example);

    int updateByExample(@Param("record") DetectInterfaceLog record, @Param("example") DetectInterfaceLogExample example);

    int updateByPrimaryKeySelective(DetectInterfaceLog record);

    int updateByPrimaryKey(DetectInterfaceLog record);
}