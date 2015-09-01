package com.jike.system.biz.itf;

import java.util.List;

import com.jike.system.model.DetectLogModel;
import com.jike.system.web.CommonException;

/**
 * 
 * Title: IDetectLogBiz
 *
 * Description:
 *
 * Company: LuoPan
 *
 * @author pfxu
 *
 * @date Aug 27, 2015
 *
 */
public interface IDetectLogBiz {

	DetectLogModel deleteByExample(DetectLogModel dlm) throws CommonException;
	
	List<DetectLogModel> selectByExample(DetectLogModel dlm) throws CommonException;

	int countByExample(DetectLogModel dlm) throws CommonException;
}
