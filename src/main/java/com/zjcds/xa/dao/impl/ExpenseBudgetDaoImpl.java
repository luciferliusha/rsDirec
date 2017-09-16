package com.zjcds.xa.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.zjcds.xa.bean.ExpenseBudgetBean;
import com.zjcds.xa.dao.IExpenseBudgetDao;
import com.zjcds.xa.dao.base.MyBaseDao;

@Repository
public class ExpenseBudgetDaoImpl extends MyBaseDao implements IExpenseBudgetDao {

	public ExpenseBudgetBean getExpenseBudgetByParam(String param) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<ExpenseBudgetBean> getExpenseBudgetByParams(Map params) {
		
		return this.getSqlSession().selectList("getExpenseBudgetByParams", params);
	}
	
	public int getExpenseBudgetCount(){
		return this.getSqlSession().selectOne("getExpenseBudgetCount");
	}

	public void insertExpenseBudget(ExpenseBudgetBean expenseBudget) {
		this.getSqlSession().insert("insertExpenseBudget", expenseBudget);

	}

	public void updateExpenseBudget(ExpenseBudgetBean expenseBudget) {
		this.getSqlSession().update("updateExpenseBudget", expenseBudget);

	}

	public List getLdByGroupid(String groupid) {
		List ldlist=this.getSqlSession().selectList("getLdByGroupid",groupid);
		return ldlist;
	}

	public Map getSfXm(String sf_xm_name) {
		
		Map SfXmMap=this.getSqlSession().selectOne("getSfXmByLd",sf_xm_name);
		return SfXmMap;
	}

	public Map getSfXsCd(String xs_cd) {
		Map xs_cdMap=this.getSqlSession().selectOne("getSfXsCd",xs_cd);
		return xs_cdMap;
	}

	public Map getSfXsNx(String xs_nx) {
		Map SfXsNxMap=this.getSqlSession().selectOne("getSfXsNx",xs_nx);
		return SfXsNxMap;
	}

	public List<Map> getExpenseBudgetTongji(Map params) {
		List<Map> SfXsNxMap=this.getSqlSession().selectList("getExpenseBudgetTongji",params);
		return SfXsNxMap;
	}

}
