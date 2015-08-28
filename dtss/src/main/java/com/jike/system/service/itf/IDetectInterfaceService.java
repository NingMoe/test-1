package com.jike.system.service.itf;

import java.util.List;

import com.jike.system.model.DetectInterfaceModel;
import com.jike.system.web.CommonException;


public interface IDetectInterfaceService {

	DetectInterfaceModel selectById(String id) throws CommonException;

	List<DetectInterfaceModel> selectAll() throws CommonException;

	List<DetectInterfaceModel> selectByExample(DetectInterfaceModel dim) throws CommonException;

	int countByExample(DetectInterfaceModel dim) throws CommonException;

	DetectInterfaceModel insert(DetectInterfaceModel dim) throws CommonException;
	
	DetectInterfaceModel updateByPrimaryKey(DetectInterfaceModel dim) throws CommonException;
	
	DetectInterfaceModel updateByPrimaryKeySelective(DetectInterfaceModel dim) throws CommonException;

	String getNextTaskId(String taskIdHead) throws CommonException;
}

