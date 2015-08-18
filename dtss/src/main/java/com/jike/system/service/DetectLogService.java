package com.jike.system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jike.system.bean.DetectLog;
import com.jike.system.dao.DetectLogMapper;
import com.jike.system.service.itf.IDetectLogService;
import com.jike.system.web.CommonException;


@Service("detectLogService")
public class DetectLogService implements IDetectLogService {

	@Autowired
	private DetectLogMapper detectLogMapper;

	@Override
	public DetectLog selectById(String id) throws CommonException {
		return detectLogMapper.selectByPrimaryKey(id);
	}

	@Override
	public DetectLog insert(DetectLog dl) throws CommonException {
		detectLogMapper.insert(dl);
		return dl;
	}
	
}

