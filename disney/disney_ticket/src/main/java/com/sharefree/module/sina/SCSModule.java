package com.sharefree.module.sina;

import java.io.File;

import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.AdaptBy;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Fail;
import org.nutz.mvc.annotation.POST;
import org.nutz.mvc.annotation.Param;
import org.nutz.mvc.upload.UploadAdaptor;

import com.sharefree.service.itf.sina.ISinaCloudStorageService;

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
	private ISinaCloudStorageService sCSService;

	@POST
	@At
	public void query() {
		sCSService.getAllBuckets();
	}

	@POST
	@At("/upload")
	@AdaptBy(type = UploadAdaptor.class, args = { "${app.root}/WEB-INF/tmp" })
	public void fileUpload(@Param("file") File file) {
		sCSService.putObject("sharefree", "bmw/456.jpg", file);
	}

}
