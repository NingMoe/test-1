package com.sharefree.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.sharefree.common.FileUpload;

@Controller
public class FlieController {

	@RequestMapping("login")
	// 用来处理前台的login请求
	private @ResponseBody String hello(
			@RequestParam(value = "username", required = false) String username,
			@RequestParam(value = "password", required = false) String password) {
		return "Hello " + username + ",Your password is: " + password;

	}

	@RequestMapping("upload")
	public void upload(@RequestParam("file") MultipartFile file,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		String filePath = FileUpload.uploadFile(file, request);
		response.setContentType("text/html;charset=utf8");
		response.getWriter().write("<img src='" + filePath + "'/>");
	}
/*
	@RequestMapping("download")
	public void download(String fileName, HttpServletResponse response)
			throws IOException {
		OutputStream os = response.getOutputStream();
		try {
			response.reset();
			response.setHeader("Content-Disposition", "attachment; filename="
					+ fileName);
			response.setContentType("image/jpeg; charset=utf-8");
			os.write(FileUtils.readFileToByteArray(FileUpload.getFile(fileName)));
			os.flush();
		} finally {
			if (os != null) {
				os.close();
			}
		}
	}*/
}
