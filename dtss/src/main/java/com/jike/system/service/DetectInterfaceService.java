package com.jike.system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jike.system.bean.DetectInterface;
import com.jike.system.dao.DetectInterfaceMapper;
import com.jike.system.service.itf.IDetectInterfaceService;
import com.jike.system.web.CommonException;


@Service("detectInterfaceService")
public class DetectInterfaceService implements IDetectInterfaceService {

	@Autowired
	private DetectInterfaceMapper detectInterfaceMapper;
	
	@Override
	public DetectInterface selectById(String id) throws CommonException {
		return detectInterfaceMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<DetectInterface> selectAll() throws CommonException {
		List<DetectInterface> dis = detectInterfaceMapper.selectByExample(null);
		return dis;
	}

	@Override
	public DetectInterface updateByPrimaryKey(DetectInterface di) throws CommonException {
		detectInterfaceMapper.updateByPrimaryKey(di);
		return di;
	}
	
}

