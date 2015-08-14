package com.jike.system.service.itf;

import java.util.List;

import com.jike.system.bean.DetectInterface;


public interface IDetectInterfaceService {

	DetectInterface selectById(String id) throws Exception;

	List<DetectInterface> selectAll() throws Exception;
}

