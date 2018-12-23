package com.ly.controller;

import com.ly.pojo.JSONResult;
import com.ly.pojo.SysUser;
import com.ly.service.UserService;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("mybatis")
public class MyBatisCRUDController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private Sid sid;
	
	@RequestMapping("/saveUser")
	public JSONResult saveUser() throws Exception {
		
		String userId = sid.nextShort();
		
		SysUser user = new SysUser();
		user.setId(userId);
		user.setUsername("陈林霄");
		user.setNickname("烟头TWO");
		user.setPassword("abc123");
		user.setIsDelete(0);
		user.setRegistTime(new Date());
		
		userService.saveUser(user);
		
		return JSONResult.ok("保存成功");
	}
	
	@RequestMapping("/updateUser")
	public JSONResult updateUser() {
		
		SysUser user = new SysUser();
		user.setId("0000000000");
		user.setUsername("陈林霄");
		user.setNickname("烟头TWO");
		user.setPassword("0000000000");
		user.setIsDelete(0);
		user.setRegistTime(new Date());
		user.setAge(18);
		user.setSex(2);
		
		userService.updateUser(user);
		
		return JSONResult.ok("保存成功");
	}
	
	@RequestMapping("/deleteUser")
	public JSONResult deleteUser(String userId) {
		
		userService.deleteUser(userId);
		
		return JSONResult.ok("删除成功");
	}
	
	@RequestMapping("/queryUserById")
	public JSONResult queryUserById(String userId) {
		
		return JSONResult.ok(userService.queryUserById(userId));
	}
	
	@RequestMapping("/queryUserList")
	public JSONResult queryUserList() {
		
		SysUser user = new SysUser();
		user.setUsername("陈林霄");
		
		List<SysUser> userList = userService.queryUserList(user);
		
		return JSONResult.ok(userList);
	}
	
	@RequestMapping("/queryUserListPaged")
	public JSONResult queryUserListPaged(Integer page) {
		
		if (page == null) {
			page = 1;
		}

		int pageSize = 6;
		
		SysUser user = new SysUser();
//		user.setNickname("lee");
		
		List<SysUser> userList = userService.queryUserListPaged(user, page, pageSize);
		
		return JSONResult.ok(userList);
	}
	
	@RequestMapping("/queryUserByIdCustom")
	public JSONResult queryUserByIdCustom(String userId) {
		
		return JSONResult.ok(userService.queryUserByIdCustom(userId));
	}
	
	@RequestMapping("/saveUserTransactional")
	public JSONResult saveUserTransactional() {
		
		String userId = sid.nextShort();
		
		SysUser user = new SysUser();
		user.setId(userId);
		user.setUsername("陈林霄" + new Date());
		user.setNickname("烟头TWO" + new Date());
		user.setPassword("abc123");
		user.setIsDelete(0);
		user.setRegistTime(new Date());
		
		userService.saveUserTransactional(user);
		
		return JSONResult.ok("保存成功");
	}
}
