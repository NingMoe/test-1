package per.suanmilk.connect.module.sina;

import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Fail;
import org.nutz.mvc.annotation.POST;

import per.suanmilk.connect.service.itf.sina.ISinaCloudStorageService;

/**
 * Title: CtripInterFlightModule
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
@At("/sina")
@Fail("http:404")
public class SCSModule {

    @Inject
    private ISinaCloudStorageService sinaCloudStorageService;

    @POST
    @At
    public void query() {
    	sinaCloudStorageService.getAllBuckets();
    }

}
