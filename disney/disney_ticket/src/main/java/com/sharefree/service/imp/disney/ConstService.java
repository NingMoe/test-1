package com.sharefree.service.imp.disney;

import org.nutz.ioc.loader.annotation.IocBean;

import com.sharefree.bean.disney.Const;
import com.sharefree.model.disney.ConstModel;
import com.sharefree.service.imp.BaseService;
import com.sharefree.service.itf.disney.IConstService;

/**
 * Title: ConstService
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
public class ConstService extends BaseService<ConstModel, Const, Long> implements IConstService {

}
