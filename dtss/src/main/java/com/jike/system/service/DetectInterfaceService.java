package com.jike.system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jike.system.bean.DetectInterface;
import com.jike.system.dao.DetectInterfaceMapper;
import com.jike.system.service.itf.IDetectInterfaceService;


@Service("detectInterfaceService")
public class DetectInterfaceService implements IDetectInterfaceService {

	@Autowired
	private DetectInterfaceMapper detectInterfaceMapper;
	
	@Override
	public DetectInterface selectById(String id) throws Exception {
		return detectInterfaceMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<DetectInterface> selectAll() throws Exception {
		List<DetectInterface> dis = detectInterfaceMapper.selectByExample(null);
		return dis;
	}
	
}

