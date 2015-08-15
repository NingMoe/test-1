package com.jike.system.service.itf;

import com.jike.system.bean.DetectInterfaceLog;
import com.jike.system.web.CommonException;


public interface IDetectInterfaceLogService {

	DetectInterfaceLog selectById(String id) throws CommonException;

	DetectInterfaceLog insert(DetectInterfaceLog dil) throws CommonException;
	
}

