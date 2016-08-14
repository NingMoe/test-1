package per.suanmilk.connect.init;

import org.nutz.dao.Dao;
import org.nutz.ioc.Ioc;
import org.nutz.mvc.NutConfig;
import org.nutz.mvc.Setup;

public class MainSetup implements Setup {

    public void init(NutConfig conf) {
        Ioc ioc = conf.getIoc();
        Dao dao = ioc.get(Dao.class);
        // 初始化默认根用户
        if (dao != null) {

        	System.out.println("app已成功启动");
        }
        
    }

    public void destroy(NutConfig conf) {
    	System.out.println("app已成功关闭");
    }

}
