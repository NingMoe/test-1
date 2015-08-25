package com.jike.system.service.itf;

import java.util.List;

import com.jike.system.bean.DetectInterface;
import com.jike.system.model.DetectInterfaceModel;
import com.jike.system.web.CommonException;


public interface IDetectInterfaceService {

	DetectInterface selectById(String id) throws CommonException;

	List<DetectInterface> selectAll() throws CommonException;

	List<DetectInterfaceModel> selectByExample(DetectInterfaceModel dim) throws CommonException;

	DetectInterfaceModel insert(DetectInterfaceModel dim) throws CommonException;
	
	DetectInterface updateByPrimaryKey(DetectInterface di) throws CommonException;

	String getNextTaskId(String taskIdHead) throws CommonException;
}

