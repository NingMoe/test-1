package com.jike.system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jike.system.bean.DetectAPI;
import com.jike.system.dao.DetectAPIMapper;
import com.jike.system.model.DetectAPIModel;
import com.jike.system.service.itf.IDetectAPIService;
import com.jike.system.web.CommonException;

/**
 * Title: DetectAPIService
 *
 * Description:
 *
 * Company: LuoPan
 *
 * @author pfxu
 *
 * @date Nov 6, 2015
 *
 */
@Service("detectAPIService")
public class DetectAPIService extends BaseService implements IDetectAPIService {

	@Autowired
	private DetectAPIMapper detectAPIMapper;

	private DetectAPI copyModelToBean(DetectAPIModel dapim) throws CommonException {
		DetectAPI dapi = (DetectAPI) super.copyProperties(dapim, DetectAPI.class);
		return dapi;
	}
	
/*	private DetectAPIModel copyBeanToModel(DetectAPI dapi) throws CommonException {
		DetectAPIModel dapim = (DetectAPIModel) super.copyProperties(dapi, DetectAPIModel.class);
		return dapim;
	}*/

	@Override
	public DetectAPIModel insert(DetectAPIModel dapim) throws CommonException {
		DetectAPI dapi = copyModelToBean(dapim);
		detectAPIMapper.insert(dapi);
		return dapim;
	}

	@Override
	public DetectAPIModel updateByPrimaryKey(DetectAPIModel dldapimm)
			throws CommonException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DetectAPIModel> selectByExample(DetectAPIModel dapim)
			throws CommonException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countByExample(DetectAPIModel dapim) throws CommonException {
		// TODO Auto-generated method stub
		return 0;
	}

}
