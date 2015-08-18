package com.jike.system.service.itf;

import com.jike.system.bean.DetectLog;
import com.jike.system.web.CommonException;


public interface IDetectLogService {

	DetectLog selectById(String id) throws CommonException;

	DetectLog insert(DetectLog dl) throws CommonException;
	
}

