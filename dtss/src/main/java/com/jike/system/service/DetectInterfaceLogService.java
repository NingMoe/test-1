package com.jike.system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jike.system.bean.DetectInterfaceLog;
import com.jike.system.dao.DetectInterfaceLogMapper;
import com.jike.system.service.itf.IDetectInterfaceLogService;
import com.jike.system.web.CommonException;


@Service("detectInterfaceLogService")
public class DetectInterfaceLogService implements IDetectInterfaceLogService {

	@Autowired
	private DetectInterfaceLogMapper detectInterfaceLogMapper;

	@Override
	public DetectInterfaceLog selectById(String id) throws CommonException {
		return detectInterfaceLogMapper.selectByPrimaryKey(id);
	}

	@Override
	public DetectInterfaceLog insert(DetectInterfaceLog dil) throws CommonException {
		detectInterfaceLogMapper.insert(dil);
		return dil;
	}
	
}

