package per.suanmilk.connect.module.sina;

import java.io.File;

import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.AdaptBy;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Fail;
import org.nutz.mvc.annotation.POST;
import org.nutz.mvc.annotation.Param;
import org.nutz.mvc.upload.TempFile;
import org.nutz.mvc.upload.UploadAdaptor;

import per.suanmilk.connect.service.itf.sina.ISinaCloudStorageService;

/**
 * 
 * @author Administrator
 *
 */
@IocBean
@At("/file")
@Fail("http:404")
public class FileTransferModule {

    @Inject
    private ISinaCloudStorageService sCSService;

    @POST
    @At("/fileUpload")
    @AdaptBy(type = UploadAdaptor.class, args = { "${app.root}/WEB-INF/tmp" })
    public void fileUpload(@Param("file") TempFile[] tfs) {
    	for(TempFile tf : tfs){
    		@SuppressWarnings("deprecation")
			File f = tf.getFile();
//    		InputStream in = tf.getInputStream();
    		sCSService.putObject("sharefree", "bmw/456.jpg", f);
    	}
//    	sCSService.getAllBuckets();
    }

    @POST
    @At("/fileDownload")
    public void fileDownload() {
    	sCSService.getAllBuckets();
    }

}
