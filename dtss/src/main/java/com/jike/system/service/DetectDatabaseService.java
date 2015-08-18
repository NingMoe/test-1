package com.jike.system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jike.system.bean.DetectDatabase;
import com.jike.system.dao.DetectDatabaseMapper;
import com.jike.system.service.itf.IDetectDatabaseService;
import com.jike.system.web.CommonException;


@Service("detectDatabaseService")
public class DetectDatabaseService implements IDetectDatabaseService {

	@Autowired
	private DetectDatabaseMapper detectDatabaseMapper;
	
	@Override
	public DetectDatabase selectById(String id) throws CommonException {
		return detectDatabaseMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<DetectDatabase> selectAll() throws CommonException {
		List<DetectDatabase> dis = detectDatabaseMapper.selectByExample(null);
		return dis;
	}

	@Override
	public DetectDatabase updateByPrimaryKey(DetectDatabase dd) throws CommonException {
		detectDatabaseMapper.updateByPrimaryKey(dd);
		return dd;
	}
	
}

