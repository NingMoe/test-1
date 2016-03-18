package com.sharefree.service.imp;

import java.util.Date;
import java.util.List;

import org.nutz.ioc.loader.annotation.IocBean;

import com.sharefree.model.CommonQueryModel;
import com.sharefree.service.itf.ISystemService;
import com.sharefree.utils.SqlCreateUtil;

/**
 * Title: SystemService
 *
 * Description:
 *
 * Company: LuoPan
 *
 * @author pfxu
 *
 * @date Mar 17, 2016
 *
 */
@IocBean
public class SystemService extends BaseService implements ISystemService {

	@Override
	public Date getTime() {
		// 定义返回数据库系统时间
        Date time = null;
    	// 定义查询条件
    	CommonQueryModel cqm = new CommonQueryModel("SELECT NOW()", null);
    	// 执行查询
    	cqm = SqlCreateUtil.complexQuery(dao, cqm);
    	// 获取查询结果
    	List<Object[]> results = cqm.getResults();
    	if(results != null && results.size() > 0){
    		time = (Date) results.get(0)[0];
    	}
		return time;
	}
	
}
