package com.jike.system.service.itf;

import java.util.List;

import com.jike.system.bean.DetectLog;
import com.jike.system.model.DetectLogModel;
import com.jike.system.web.CommonException;

public interface IDetectLogService {

	DetectLog selectById(String id) throws CommonException;

	List<DetectLogModel> selectByExample(DetectLogModel dlm) throws CommonException;

	int countByExample(DetectLogModel dlm) throws CommonException;

	DetectLog insert(DetectLog dl) throws CommonException;
	
	DetectLogModel deleteByExample(DetectLogModel dlm) throws CommonException;
	
}

