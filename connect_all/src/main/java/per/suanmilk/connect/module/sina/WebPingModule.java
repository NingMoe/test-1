package per.suanmilk.connect.module.sina;

import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Fail;

/**
 * 
 * Title: WebPingModule
 *
 * Description:
 *
 * Company: LuoPan
 *
 * @author pfxu
 *
 * @date Jul 22, 2016
 *
 */
@IocBean
@At("/ping")
@Fail("http:404")
public class WebPingModule {

    /**
     * 
     * @return
     * @throws Exception
     */
    @At("")
    public String resp() throws Exception {
		return "OK";
    }

}
