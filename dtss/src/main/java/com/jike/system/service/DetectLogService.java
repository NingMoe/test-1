package com.jike.system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jike.system.bean.DetectLog;
import com.jike.system.bean.DetectLogExample;
import com.jike.system.bean.DetectLogExample.Criteria;
import com.jike.system.dao.DetectLogMapper;
import com.jike.system.model.DetectLogModel;
import com.jike.system.service.itf.IDetectLogService;
import com.jike.system.util.StringUtil;
import com.jike.system.web.CommonException;

@Service("detectLogService")
public class DetectLogService extends BaseService implements IDetectLogService {

	@Autowired
	private DetectLogMapper detectLogMapper;

	@Override
	public DetectLog selectById(String id) throws CommonException {
		return detectLogMapper.selectByPrimaryKey(id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DetectLogModel> selectByExample(DetectLogModel dlm) throws CommonException {
		DetectLogExample dlex = null;
		if (dlm != null) {
			dlex = (DetectLogExample) getExample(DetectLogExample.class, dlm.getPage());
			this.createExample(dlm, dlex);
			if(StringUtil.isNotEmpty(dlm.getOrderByClause())){
				dlex.setOrderByClause(dlm.getOrderByClause());
			}else{
				dlex.setOrderByClause("LOG_ID DESC");
			}
		}
		List<DetectLog> dls = detectLogMapper.selectByExample(dlex);
		List<DetectLogModel> dlms = (List<DetectLogModel>) copyListProperties(dls, DetectLogModel.class);
		return dlms;
	}

	@Override
	public int countByExample(DetectLogModel dlm) throws CommonException {
		DetectLogExample dlex = null;
		if (dlm != null) {
			dlex = (DetectLogExample) getExample(DetectLogExample.class, dlm.getPage());
			this.createExample(dlm, dlex);
		}
		return detectLogMapper.countByExample(dlex);
	}

	@Override
	public DetectLog insert(DetectLog dl) throws CommonException {
		detectLogMapper.insert(dl);
		return dl;
	}

	@Override
	public DetectLogModel deleteByExample(DetectLogModel dlm) throws CommonException {
		DetectLogExample dlex = null;
		if (dlm != null) {
			dlex = (DetectLogExample) getExample(DetectLogExample.class, dlm.getPage());
			this.createExample(dlm, dlex);
		}
		detectLogMapper.deleteByExample(dlex);
		return dlm;
	}
	
	private void createExample(DetectLogModel dlm, DetectLogExample dlex){
		Criteria c = dlex.createCriteria();
		if(StringUtil.isNotEmpty(dlm.getLogId())){
			c.andLogIdEqualTo(dlm.getLogId());
		}
		if(StringUtil.isNotEmpty(dlm.getLogType())){
			c.andLogTypeEqualTo(dlm.getLogType());
		}
		if(StringUtil.isNotEmpty(dlm.getTaskId())){
			c.andTaskIdEqualTo(dlm.getTaskId());
		}
		if(StringUtil.isNotEmpty(dlm.getDetectResult())){
			c.andDetectResultEqualTo(dlm.getDetectResult());
		}
		if(dlm.getLogStartTime()!=null){
			c.andLogTimeGreaterThanOrEqualTo(dlm.getLogStartTime());
		}
		if(dlm.getLogEndTime()!=null){
			c.andLogTimeLessThan(dlm.getLogEndTime());
		}
		if(dlm.getExpireDate()!=null){
			c.andLogTimeLessThan(dlm.getExpireDate());
		}
	}
	
}

