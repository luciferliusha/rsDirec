package com.zjcds.xa.service;

import org.springframework.stereotype.Service;

import com.zjcds.xa.bean.UserInfoBean;

public interface IUserInfoService {
	
	public UserInfoBean getUserInfo(String name);

}
