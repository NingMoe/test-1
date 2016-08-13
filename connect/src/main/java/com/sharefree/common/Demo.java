package com.sharefree.common;

public class Demo {

	public static void main(String[] args) {
		SinaCloudStorage storage = new SinaCloudStorage();
		storage.init();
//		storage.listObjects("sharefree");
		storage.getBucketAcl("sharefree");
		storage.putBucketAcl("sharefree");
		storage.getBucketAcl("sharefree");
//		storage.getObjectMeta("sharefree", "/bmw/1118211101.jpg");
//		storage.getObject("sharefree", "/bmw/1118211101.jpg");
	}

}
