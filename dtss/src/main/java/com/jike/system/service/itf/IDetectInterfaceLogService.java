package com.jike.system.service.itf;

import com.jike.system.bean.DetectInterfaceLog;


public interface IDetectInterfaceLogService {

	DetectInterfaceLog selectById(String id) throws Exception;

	DetectInterfaceLog insert(DetectInterfaceLog dil) throws Exception;
	
}

