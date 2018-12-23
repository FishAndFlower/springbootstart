package com.ly.mapper;

import com.ly.pojo.SysUser;

import java.util.List;

public interface SysUserMapperCustom {
	
	List<SysUser> queryUserSimplyInfoById(String id);
}