package com.jike.system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jike.system.bean.DetectAPI;
import com.jike.system.bean.DetectAPIExample;
import com.jike.system.bean.DetectAPIExample.Criteria;
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
	public DetectAPIModel updateByPrimaryKey(DetectAPIModel dapim)
			throws CommonException {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DetectAPIModel> selectByExample(DetectAPIModel dapim)
			throws CommonException {
		DetectAPIExample dapimex = null;
		if (dapim != null) {
			dapimex = (DetectAPIExample) getExample(DetectAPIExample.class, dapim.getPage());
			this.createExample(dapim, dapimex);
		}
		List<DetectAPI> dapis = detectAPIMapper.selectByExample(dapimex);

		List<DetectAPIModel> dapims = (List<DetectAPIModel>) copyListProperties(dapis, DetectAPIModel.class);
		return dapims;
	}

	@Override
	public int countByExample(DetectAPIModel dapim) throws CommonException {
		DetectAPIExample dapimex = null;
		if (dapim != null) {
			dapimex = (DetectAPIExample) getExample(DetectAPIExample.class, dapim.getPage());
			this.createExample(dapim, dapimex);
		}
		return detectAPIMapper.countByExample(dapimex);
	}
    
    private void createExample(DetectAPIModel dapim, DetectAPIExample dapimex){
        Criteria c = dapimex.createCriteria();
        if(dapim.getTaskRunStartTime()!=null){
            c.andTaskRunTimeGreaterThanOrEqualTo(dapim.getTaskRunStartTime());
        }
        if(dapim.getTaskRunEndTime()!=null){
            c.andTaskRunTimeLessThan(dapim.getTaskRunEndTime());
        }
    }

}
