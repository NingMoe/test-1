package com.jike.system.service.itf;

import java.util.List;

import com.jike.system.bean.DetectDatabase;
import com.jike.system.web.CommonException;


public interface IDetectDatabaseService {

	DetectDatabase selectById(String id) throws CommonException;

	List<DetectDatabase> selectAll() throws CommonException;

	DetectDatabase updateByPrimaryKey(DetectDatabase di) throws CommonException;
}

