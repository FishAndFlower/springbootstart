package com.ly.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ly.pojo.JSONResult;
import com.ly.pojo.User;

//@Controller
@RestController
@RequestMapping("/user")
public class UserController {
	
	@RequestMapping("/getUser")
	//@ResponseBody
	public User getUser(){
		//创建生日字符串
		String dateStr = "1991-07-04";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date birthDate = null;
		try {
			birthDate = simpleDateFormat.parse(dateStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("日期转换出错");
		}
		System.out.println(birthDate);
		User user = new User();
		user.setName("陈林霄");
		user.setPassword("pwd");
		user.setAge(18);
		user.setBirthday(birthDate);
		return user;
	}
	
	@RequestMapping("/getUserJson")
	//@ResponseBody
	public JSONResult gerUserJson(){
		//创建生日字符串
		String dateStr = "1991-07-04";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date birthDate = null;
		try {
			birthDate = simpleDateFormat.parse(dateStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("日期转换出错");
		}
		System.out.println(birthDate);
		User user = new User();
		user.setName("陈林霄");
		user.setPassword("pwd");
		user.setAge(18);
		user.setBirthday(birthDate);
		user.setDesc("spencial girl");
		
		return JSONResult.ok(user);
	}

}
