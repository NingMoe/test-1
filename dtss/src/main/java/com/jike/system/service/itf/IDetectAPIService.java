package com.jike.system.service.itf;

import java.util.List;

import com.jike.system.model.DetectAPIModel;
import com.jike.system.web.CommonException;

/**
 * Title: IDetectAPIService
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
public interface IDetectAPIService {

	DetectAPIModel insert(DetectAPIModel dapim) throws CommonException;

	DetectAPIModel updateByPrimaryKey(DetectAPIModel dapim) throws CommonException;
	
	List<DetectAPIModel> selectByExample(DetectAPIModel dapim) throws CommonException;

	int countByExample(DetectAPIModel dapim) throws CommonException;

}
