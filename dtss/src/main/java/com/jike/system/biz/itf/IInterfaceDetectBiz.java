package com.jike.system.biz.itf;

import java.util.List;

import com.jike.system.bean.DetectInterface;
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

	DetectInterface selectById(String id) throws CommonException;
	
	List<DetectInterface> selectAll() throws CommonException;
	
	void execute(DetectInterface di) throws CommonException;

	List<DetectInterfaceModel> selectByExample(DetectInterfaceModel dim) throws CommonException;

	DetectInterfaceModel insert(DetectInterfaceModel dim) throws CommonException;

	DetectInterface updateByPrimaryKey(DetectInterface di) throws CommonException;

	DetectInterfaceModel switchState(DetectInterfaceModel dim, String toState) throws CommonException;
}
