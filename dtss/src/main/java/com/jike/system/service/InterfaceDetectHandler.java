package com.jike.system.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jike.system.bean.DetectInterface;

public class InterfaceDetectHandler {

	private static final Logger log = LoggerFactory.getLogger(InterfaceDetectHandler.class);
	
	private DetectInterface detectInterface;
	
	private InterfaceDetectHandler(DetectInterface detectInterface){
		
	}
	
	
	
	
	
	
	
	
	
	public DetectInterface getDetectInterface() {
		return detectInterface;
	}

	public void setDetectInterface(DetectInterface detectInterface) {
		this.detectInterface = detectInterface;
	}






	public static void main(String[] args) {
	}
	
}

