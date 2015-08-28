package com.jike.system.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jike.system.biz.itf.IDetectLogBiz;
import com.jike.system.model.DetectLogModel;
import com.jike.system.service.itf.IDetectLogService;
import com.jike.system.web.CommonException;

@Service("detectLogBiz")
@Transactional
public class DetectLogBiz implements IDetectLogBiz {

	@Autowired
	private IDetectLogService dlService;

	@Override
	public DetectLogModel deleteByExample(DetectLogModel dlm)
			throws CommonException {
		return dlService.deleteByExample(dlm);
	}

	@Override
	public List<DetectLogModel> selectByExample(DetectLogModel dlm)
			throws CommonException {
		return dlService.selectByExample(dlm);
	}

	@Override
	public int countByExample(DetectLogModel dlm) throws CommonException {
		return dlService.countByExample(dlm);
	}

	
}

