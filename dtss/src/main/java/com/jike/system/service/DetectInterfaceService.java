package com.jike.system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jike.system.bean.DetectInterface;
import com.jike.system.bean.DetectInterfaceExample;
import com.jike.system.bean.DetectInterfaceExample.Criteria;
import com.jike.system.consts.InterfaceConsts;
import com.jike.system.consts.SysConsts;
import com.jike.system.dao.DetectInterfaceMapper;
import com.jike.system.model.DetectInterfaceModel;
import com.jike.system.service.itf.IDetectInterfaceService;
import com.jike.system.util.StringUtil;
import com.jike.system.web.CommonException;


@Service("detectInterfaceService")
public class DetectInterfaceService extends BaseService implements IDetectInterfaceService {

	@Autowired
	private DetectInterfaceMapper detectInterfaceMapper;

	private DetectInterface copyModelToBean(DetectInterfaceModel dim) throws CommonException {
		DetectInterface di = (DetectInterface) super.copyProperties(dim, DetectInterface.class);
		return di;
	}
	
	private DetectInterfaceModel copyBeanToModel(DetectInterface di) throws CommonException {
		DetectInterfaceModel dim = (DetectInterfaceModel) super.copyProperties(di, DetectInterfaceModel.class);
		return dim;
	}
	
	@Override
	public DetectInterfaceModel selectById(String id) throws CommonException {
		DetectInterface di = detectInterfaceMapper.selectByPrimaryKey(id);
		return copyBeanToModel(di);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DetectInterfaceModel> selectByExample(DetectInterfaceModel dim) throws CommonException {
		DetectInterfaceExample diex = null;
		if (dim != null) {
			diex = (DetectInterfaceExample) getExample(DetectInterfaceExample.class, dim.getPage());
			this.createExample(dim, diex);
			if(StringUtil.isNotEmpty(dim.getOrderByClause())){
				diex.setOrderByClause(dim.getOrderByClause());
			}else{
				diex.setOrderByClause("UPDATE_TIME DESC");
			}
		}
		List<DetectInterface> dis = detectInterfaceMapper.selectByExample(diex);
		List<DetectInterfaceModel> dims = (List<DetectInterfaceModel>) copyListProperties(dis, DetectInterfaceModel.class);
		if(dims != null){
			for(DetectInterfaceModel dima : dims){
				dima.setCurrentFailureNum(InterfaceConsts.FAILURE_TIME.get(dima.getTaskId()));
				dima.setCurrentIsNotice(SysConsts.CURRENT_IS_NOTICE.contains(dima.getTaskId()));
			}
		}
		return dims;
	}

	@Override
	public int countByExample(DetectInterfaceModel dim) throws CommonException {
		DetectInterfaceExample diex = null;
		if (dim != null) {
			diex = (DetectInterfaceExample) getExample(DetectInterfaceExample.class, dim.getPage());
			this.createExample(dim, diex);
		}
		return detectInterfaceMapper.countByExample(diex);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DetectInterfaceModel> selectAll() throws CommonException {
		List<DetectInterface> dis = detectInterfaceMapper.selectByExample(null);
		List<DetectInterfaceModel> dims = 
				(List<DetectInterfaceModel>) copyListProperties(dis,
						DetectInterfaceModel.class);
		return dims;
	}

	@Override
	public DetectInterfaceModel insert(DetectInterfaceModel dim) throws CommonException {
		DetectInterface di = copyModelToBean(dim);
		detectInterfaceMapper.insert(di);
		return dim;
	}

	@Override
	public DetectInterfaceModel updateByPrimaryKey(DetectInterfaceModel dim) throws CommonException {
		DetectInterface di = copyModelToBean(dim);
		detectInterfaceMapper.updateByPrimaryKey(di);
		return dim;
	}

	@Override
	public DetectInterfaceModel updateByPrimaryKeySelective(DetectInterfaceModel dim) throws CommonException {
		DetectInterface di = copyModelToBean(dim);
		detectInterfaceMapper.updateByPrimaryKeySelective(di);
		return dim;
	}

	@Override
	public String getNextTaskId(String taskIdHead) throws CommonException {
		int nextNo = detectInterfaceMapper.getNextTaskId(taskIdHead);
		String nextTaskId = taskIdHead + StringUtil.fillString(String.valueOf(nextNo), '0', 4, false);
		return nextTaskId;
	}
	
	private void createExample(DetectInterfaceModel dim, DetectInterfaceExample diex){
		Criteria c = diex.createCriteria();
		if(StringUtil.isNotEmpty(dim.getTaskId())){
			c.andTaskIdEqualTo(dim.getTaskId());
		}
		if(StringUtil.isNotEmpty(dim.getState())){
			c.andStateEqualTo(dim.getState());
		}
		if(dim.getCreateStartTime()!=null){
			c.andCreateTimeGreaterThanOrEqualTo(dim.getCreateStartTime());
		}
		if(dim.getCreateEndTime()!=null){
			c.andCreateTimeLessThan(dim.getCreateEndTime());
		}
		if(dim.getUpdateStartTime()!=null){
			c.andUpdateTimeGreaterThanOrEqualTo(dim.getUpdateStartTime());
		}
		if(dim.getUpdateEndTime()!=null){
			c.andUpdateTimeLessThan(dim.getUpdateEndTime());
		}
	}
	
}

