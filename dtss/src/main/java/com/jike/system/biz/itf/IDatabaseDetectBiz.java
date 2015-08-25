package com.jike.system.biz.itf;

import java.util.List;

import com.jike.system.model.DetectDatabaseModel;
import com.jike.system.web.CommonException;

/**
 * Title: IDatabaseDetectBiz
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
public interface IDatabaseDetectBiz {

	void execute(DetectDatabaseModel dd) throws CommonException;
	
	List<DetectDatabaseModel> selectByExample(DetectDatabaseModel ddm) throws CommonException;

	DetectDatabaseModel add(DetectDatabaseModel ddm) throws CommonException;
	
	void switchState(String taskId, String toState) throws CommonException;
	
}
