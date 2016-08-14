/**
 * 
 */
package per.suanmilk.connect.service.itf.sina;

import java.io.File;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import com.sina.cloudstorage.services.scs.model.AccessControlList;
import com.sina.cloudstorage.services.scs.model.Bucket;
import com.sina.cloudstorage.services.scs.model.ObjectListing;
import com.sina.cloudstorage.services.scs.model.ObjectMetadata;
import com.sina.cloudstorage.services.scs.model.PutObjectResult;

/**
 * @author Administrator
 *
 */
public interface ISinaCloudStorageService {
	/**
	 * 获取所有bucket
	 */
	public List<Bucket> getAllBuckets();
	
	/**
	 * 创建bucket
	 */
	public Bucket createBucket(String bucketName);
	
	/**
	 * 删除bucket
	 */
	public void deleteBucket(String bucketName);
	
	/**
	 * 获取bucket ACL
	 */
	public AccessControlList getBucketAcl(String bucketName);
	
	/**
	 * 设置bucket acl
	 */
	public void putBucketAcl(String bucketName, AccessControlList acl);
	
	/**
	 * 列bucket中所有文件
	 */
	public ObjectListing listObjects(String bucketName);
	
	/**
	 * 获取object metadata
	 */
	public ObjectMetadata getObjectMeta(String bucketName, String filePath);
	
	/**
	 * 上传文件
	 */
	public PutObjectResult putObject(String bucketName, String filePath, File file);
	
	/**
	 * 上传文件 自定义请求头
	 */
	public PutObjectResult putObjectWithHeader(String bucketName, String filePath, File file, Map<String, String> requestHeader);
	
	/**
	 * 秒传文件
	 */
	public void putObjectRelax(String bucketName, String filePath, String fileShaValue, long fileLength);
	
	/**
	 * 下载object
	 */
	public void getObject(String bucketName, String filePath, OutputStream out);
	
	/**
	 * 拷贝object
	 */
	public void copyObject(String orgBucketName, String oldFilePath,String desBucketName, String newFilePath);
	
	/**
	 * 删除Object
	 */
	public void deleteObject(String bucketName, String filePath);
	
	
}
