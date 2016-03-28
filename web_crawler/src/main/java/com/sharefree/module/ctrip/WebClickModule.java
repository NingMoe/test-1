package com.sharefree.module.ctrip;

import java.util.List;

import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Fail;

import com.sharefree.common.CommonException;
import com.sharefree.model.ctrip.WebClickModel;
import com.sharefree.service.itf.ctrip.IWebClickService;

/**
 * Title: WebClickModule
 *
 * Description:
 *
 * Company: LuoPan
 *
 * @author pfxu
 *
 * @date Feb 17, 2016
 *
 */
@IocBean
@At("/click")
@Fail("http:404")
public class WebClickModule {

    @Inject
    private IWebClickService webClickService;

    /**
     * 查询所有账户信息
     * @return
     * @throws Exception
     */
    @At
    public List<WebClickModel> query() throws Exception {
    	if(true){
    		throw new CommonException("测试报错");
    	}
        return webClickService.query(null);
    }

}
