package com.jike.system.biz.itf;

import java.util.List;

import com.jike.system.model.DetectAPIConfigModel;
import com.jike.system.model.DetectAPIModel;
import com.jike.system.web.CommonException;

/**
 * Title: IDetectAPIBiz
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
public interface IDetectAPIBiz {
	
	void execute() throws CommonException;
	
	List<DetectAPIModel> selectByExample(DetectAPIModel dapim) throws CommonException;

	int countByExample(DetectAPIModel dapim) throws CommonException;

	DetectAPIConfigModel configStrategy(DetectAPIConfigModel dapicm) throws CommonException;

	void startTask(DetectAPIModel dapim) throws CommonException;

	void stopTask() throws CommonException;

}
