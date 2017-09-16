package com.zjcds.xa.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.zjcds.xa.bean.UserInfoBean;

public interface IUserInfoDao {
	
	public UserInfoBean getUserByName(String name);

}
