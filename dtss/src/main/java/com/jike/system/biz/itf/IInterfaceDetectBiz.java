package com.jike.system.biz.itf;

import java.util.List;

import com.jike.system.model.DetectInterfaceModel;
import com.jike.system.web.CommonException;

/**
 * Title: IInterfaceDetectBiz
 *
 * Description:
 *
 * Company: LuoPan
 *
 * @author pfxu
 *
 * @date Aug 25, 2015
 *
 */
public interface IInterfaceDetectBiz {

	DetectInterfaceModel selectById(String id) throws CommonException;
	
	List<DetectInterfaceModel> selectAll() throws CommonException;
	
	void execute(DetectInterfaceModel dim) throws CommonException;

	List<DetectInterfaceModel> selectByExample(DetectInterfaceModel dim) throws CommonException;

	int countByExample(DetectInterfaceModel dim) throws CommonException;

	DetectInterfaceModel insert(DetectInterfaceModel dim) throws CommonException;

	DetectInterfaceModel updateByPrimaryKey(DetectInterfaceModel dim) throws CommonException;

	DetectInterfaceModel updateByPrimaryKeySelective(DetectInterfaceModel dim) throws CommonException;

	DetectInterfaceModel switchState(DetectInterfaceModel dim) throws CommonException;

	void reset(String id) throws CommonException;

	void closeAllTask() throws CommonException;
}
