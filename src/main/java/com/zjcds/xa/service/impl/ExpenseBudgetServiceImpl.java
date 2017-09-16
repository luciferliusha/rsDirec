package com.zjcds.xa.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zjcds.xa.bean.ExpenseBudgetBean;
import com.zjcds.xa.dao.IExpenseBudgetDao;
import com.zjcds.xa.service.IExpenseBudgetService;

@Service
public class ExpenseBudgetServiceImpl implements IExpenseBudgetService {
    
	@Autowired 
	private IExpenseBudgetDao expenseBudgetDao;
	public ExpenseBudgetBean getExpenseBudgetByParam(String param) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<ExpenseBudgetBean> getExpenseBudgetByParams(Map params){
		// TODO Auto-generated method stub
		return expenseBudgetDao.getExpenseBudgetByParams(params);
	}

	public int getExpenseBudgetCount(){
		return expenseBudgetDao.getExpenseBudgetCount();
	}

	public void insertExpenseBudget(ExpenseBudgetBean expenseBudget) {
		expenseBudgetDao.insertExpenseBudget(expenseBudget);

	}

	public void updateExpenseBudget(ExpenseBudgetBean expenseBudget) {
		expenseBudgetDao.updateExpenseBudget(expenseBudget);

	}

	public List getLdByGroupid(String groupid) {
		// TODO Auto-generated method stub
		return expenseBudgetDao.getLdByGroupid(groupid);
	}

	public Map getSfXm(String sf_xm_name) {
		Map sfXmMap=expenseBudgetDao.getSfXm(sf_xm_name);
		return sfXmMap;
	}

	public Map getSfXsCd(String xs_cd) {
		// TODO Auto-generated method stub
		return expenseBudgetDao.getSfXsCd(xs_cd);
	}

	public Map getSfXsNx(String xs_nx) {
		// TODO Auto-generated method stub
		return expenseBudgetDao.getSfXsNx(xs_nx);
	}

	public List<Map> getExpenseBudgetTongji(Map params) {
		// TODO Auto-generated method stub
		List<Map> list = expenseBudgetDao.getExpenseBudgetTongji(params);
		return expenseBudgetDao.getExpenseBudgetTongji(params);
	}

}
