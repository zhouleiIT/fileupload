package com.zhoulei.controller;

import com.zhoulei.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@Controller
public class FileuploadApplication {

	@Autowired
	private UploadService uploadService;
	@RequestMapping("/")
	public String index(){
		return "index";
	}
	@RequestMapping("upload")
	public String upload(@RequestParam("file") MultipartFile file) throws IOException {
		boolean upload = uploadService.upload(file.getInputStream(), file.getOriginalFilename());
		System.out.println(upload);
		return "/";
	}



}
