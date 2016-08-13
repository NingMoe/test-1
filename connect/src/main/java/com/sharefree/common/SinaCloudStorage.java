/**
 * 
 */
package com.sharefree.common;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.alibaba.fastjson.JSONObject;
import com.sina.cloudstorage.auth.AWSCredentials;
import com.sina.cloudstorage.auth.BasicAWSCredentials;
import com.sina.cloudstorage.services.scs.SCS;
import com.sina.cloudstorage.services.scs.SCSClient;
import com.sina.cloudstorage.services.scs.model.AccessControlList;
import com.sina.cloudstorage.services.scs.model.Bucket;
import com.sina.cloudstorage.services.scs.model.ObjectListing;
import com.sina.cloudstorage.services.scs.model.ObjectMetadata;
import com.sina.cloudstorage.services.scs.model.Permission;
import com.sina.cloudstorage.services.scs.model.S3Object;
import com.sina.cloudstorage.services.scs.model.UserIdGrantee;

/**
 * @author luopan
 *
 */
public class SinaCloudStorage {
	private String accessKey = "2jm0l84YxuyXu5JJAAAg";
	private String userId = "SINA0000000002JM0L84";
	private String secretKey = "c31fea277f52a1e4e08521be3e16a4947f9b5797";

	// ����������
	private SCS conn;

	// ��ʼ��
	public void init() {
		// ��������
		AWSCredentials credentials = new BasicAWSCredentials(accessKey,
				secretKey);
		conn = new SCSClient(credentials);
	}

	/**
	 * ����bucket
	 */
	public void createBucket(String bucketName) {
		Bucket bucket = conn.createBucket(bucketName);
		System.out.println(bucket);
	}

	/**
	 * ��ȡbucket ACL
	 */
	public void getBucketAcl(String bucketName) {
		AccessControlList acl = conn.getBucketAcl(bucketName);
		System.out.println(acl);
	}

	/**
	 * ����bucket acl
	 */
	public void putBucketAcl(String bucketName) {
		AccessControlList acl = new AccessControlList();
//		acl.grantPermissions(UserIdGrantee.CANONICAL, Permission.Read,
//				Permission.ReadAcp, Permission.Write, Permission.WriteAcp);
//		acl.grantPermissions(UserIdGrantee.ANONYMOUSE, Permission.Read,
//				Permission.ReadAcp, Permission.Write, Permission.WriteAcp);
		acl.grantPermissions(UserIdGrantee.ANONYMOUSE, Permission.Read);
		acl.grantPermissions(new UserIdGrantee(userId), Permission.Read,
				Permission.ReadAcp, Permission.Write, Permission.WriteAcp);

		acl.revokeAllPermissions(UserIdGrantee.CANONICAL);
		acl.revokeAllPermissions(UserIdGrantee.ANONYMOUSE);
		conn.setBucketAcl(bucketName, acl);
	}

	/**
	 * ��bucket�������ļ�
	 */
	public void listObjects(String bucketName) {
		ObjectListing objectListing = conn.listObjects(bucketName);
		System.out.println(JSONObject.toJSONString(objectListing));
	}

	/**
	 * ɾ��bucket
	 */
	public void deleteBucket(String bucketName) {
		conn.deleteBucket(bucketName);
	}

	// 3.object ����:

	/**
	 * ��ȡ�ļ���Ϣ: ��ȡobject metadata
	 */
	public void getObjectMeta(String bucketName, String filePathName) {
		ObjectMetadata objectMetadata = conn.getObjectMetadata(bucketName,
				filePathName);
		System.out.println(objectMetadata.getUserMetadata());
		System.out.println(objectMetadata.getContentLength());
		System.out.println(objectMetadata.getRawMetadata());
		System.out.println(objectMetadata.getETag());
	}

	/**
	 * ����object //�ϵ����� GetObjectRequest rangeObjectRequest = new
	 * GetObjectRequest("test11", "/test/file.txt");
	 * rangeObjectRequest.setRange(0, 10); // retrieve 1st 10 bytes. S3Object
	 * objectPortion = conn.getObject(rangeObjectRequest);
	 * 
	 * InputStream objectData = objectPortion.getObjectContent(); // "Process
	 * the objectData stream. objectData.close();
	 */
	public void getObject(String bucketName, String filePathName) {
		// SDKGlobalConfiguration.setGlobalTimeOffset(-60*5);//�Զ���ȫ�ֳ�ʱʱ��5�����Ժ�(��ѡ��)
		S3Object s3Obj = conn.getObject(bucketName, filePathName);
		InputStream in = s3Obj.getObjectContent();
		byte[] buf = new byte[1024];
		OutputStream out = null;
		try {
			out = new FileOutputStream(new File("E:/dage1.jpg"));
			int count;
			while ((count = in.read(buf)) != -1) {
				if (Thread.interrupted()) {
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
		} finally {
			// SDKGlobalConfiguration.setGlobalTimeOffset(0);//��ԭ��ʱʱ��
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

}
