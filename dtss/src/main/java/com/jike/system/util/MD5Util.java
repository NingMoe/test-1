package com.jike.system.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * md5算法工具
 */
public class MD5Util {
	
	static Logger log = LoggerFactory.getLogger(MD5Util.class);
	
    static MessageDigest md = null;

    static {
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException ne) {
        	log.info("NoSuchAlgorithmException: md5", ne);
        }
    }

    /**
     * 对一个文件求他的md5值
     * @param f 要求md5值的文件
     * @return md5串
     */
    public static String md5(File f) {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(f);
            //100KB each time
            byte[] buffer = new byte[102400];
            int length;
            long loopCount = 0;
            while ((length = fis.read(buffer)) != -1) {
                md.update(buffer, 0, length);
                loopCount++;
            }
            
            log.debug("read file to buffer loopCount:"+loopCount);

            return new String(Hex.encodeHex(md.digest()));
        } catch (FileNotFoundException e) {
        	log.error("md5 file " + f.getAbsolutePath() + " failed:" + e.getMessage());
            return null;
        } catch (IOException e) {
        	log.error("md5 file " + f.getAbsolutePath() + " failed:" + e.getMessage());
            return null;
        } finally {
            try {
                if (fis != null) fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 求一个字符串的md5值
     * @param target 字符串
     * @return md5 value
     */
    public static String md5(String target) {
        return DigestUtils.md5Hex(target);
    }
    
    public static void main(String[] args) {
/*      long begin =System.currentTimeMillis();
        System.out.println(md5(new File("G:/BT/PremierePro_6_LS7.7z")));
        long end =System.currentTimeMillis();
        System.out.println("time:"+((end-begin)/1000)+"s");*/
        
//    	String a = "http://10.0.1.4:8009/api/employees/login";
//    	String b = "POST";
//    	String c = "{\"employeename\": \"1\",\"password\": \"1\"}";

    	String a = "http://www.jiketravel.com:8084/api/msgQueues";
    	String b = "GET";
    	String c = "isCollapsed=1&limit=5&no=1";
    	
        System.out.println(md5(a+b+c).toUpperCase());
    }

}