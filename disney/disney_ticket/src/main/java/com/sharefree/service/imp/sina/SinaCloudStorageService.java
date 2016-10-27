package com.sharefree.service.imp.sina;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;

import com.sharefree.service.itf.sina.ISinaCloudStorageService;

import com.alibaba.fastjson.JSONObject;
import com.sina.cloudstorage.services.scs.SCS;
import com.sina.cloudstorage.services.scs.model.AccessControlList;
import com.sina.cloudstorage.services.scs.model.Bucket;
import com.sina.cloudstorage.services.scs.model.ObjectListing;
import com.sina.cloudstorage.services.scs.model.ObjectMetadata;
import com.sina.cloudstorage.services.scs.model.PutObjectResult;
import com.sina.cloudstorage.services.scs.model.S3Object;

@IocBean(name="sCSService")
public class SinaCloudStorageService implements ISinaCloudStorageService {

	@Inject
	private SCS scs;

	@Override
	public List<Bucket> getAllBuckets() {
	    List<Bucket> list = scs.listBuckets();
	    System.out.println(JSONObject.toJSONString(list));
		return list;
	}

	@Override
	public Bucket createBucket(String bucketName) {
		Bucket bucket = scs.createBucket(bucketName);
		return bucket;
	}

	@Override
	public void deleteBucket(String bucketName) {
		scs.deleteBucket(bucketName);
	}

	@Override
	public AccessControlList getBucketAcl(String bucketName) {
		AccessControlList acl = scs.getBucketAcl(bucketName);
		return acl;
	}

	@Override
	public void putBucketAcl(String bucketName, AccessControlList acl) {
		scs.setBucketAcl(bucketName, acl);
	}

	@Override
	public ObjectListing listObjects(String bucketName) {
		ObjectListing objectListing = scs.listObjects(bucketName);
		return objectListing;
	}

	@Override
	public ObjectMetadata getObjectMeta(String bucketName, String filePath) {
		ObjectMetadata objectMetadata = scs.getObjectMetadata(bucketName,
				filePath);
		return objectMetadata;
	}

	@Override
	public PutObjectResult putObject(String bucketName, String filePath,
			File file) {
		PutObjectResult putObjectResult = scs.putObject(bucketName,
				filePath, file);
		return putObjectResult;
	}

	@Override
	public PutObjectResult putObjectWithHeader(String bucketName,
			String filePath, File file, Map<String, String> requestHeader) {
	    PutObjectResult putObjectResult = scs.putObject(bucketName, filePath, 
                file, requestHeader);
		return putObjectResult;
	}

	@Override
	public void putObjectRelax(String bucketName, String filePath,
			String fileShaValue, long fileLength) {
		scs.putObjectRelax(bucketName, filePath, fileShaValue, fileLength);
	}

	@Override
	public void getObject(String bucketName, String filePath,
			OutputStream out) {
		//SDKGlobalConfiguration.setGlobalTimeOffset(-60*5);//自定义全局超时时间5分钟以后(可选项)
	    S3Object s3Obj = scs.getObject(bucketName, filePath);
	    InputStream in = s3Obj.getObjectContent();
	    byte[] buf = new byte[1024];
	    try {
	        int count;
	        while( (count = in.read(buf)) != -1)
	        {
	           if( Thread.interrupted() )
	           {
	               throw new InterruptedException();
	           }
	           out.write(buf, 0, count);
	        }
	    } catch (FileNotFoundException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }finally{
	        //SDKGlobalConfiguration.setGlobalTimeOffset(0);//还原超时时间
	        try {
	            out.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        try {
	            in.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	}

	@Override
	public void copyObject(String orgBucketName, String oldFilePath,
			String desBucketName, String newFilePath) {
		 scs.copyObject(orgBucketName, oldFilePath, desBucketName, newFilePath);
	}

	@Override
	public void deleteObject(String bucketName, String filePath) {
		scs.deleteObject(bucketName, filePath);
	}

}
