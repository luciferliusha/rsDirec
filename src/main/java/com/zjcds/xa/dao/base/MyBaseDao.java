package com.zjcds.xa.dao.base;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;

public class MyBaseDao extends SqlSessionDaoSupport{
	
	@Autowired
    public void setSqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

}
