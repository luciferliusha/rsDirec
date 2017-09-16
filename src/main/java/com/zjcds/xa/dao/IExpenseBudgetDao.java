package com.zjcds.xa.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.zjcds.xa.bean.ExpenseBudgetBean;

public interface IExpenseBudgetDao {
	public ExpenseBudgetBean getExpenseBudgetByParam(String param);
	public List<ExpenseBudgetBean>  getExpenseBudgetByParams(Map params);
	public List<Map>  getExpenseBudgetTongji(Map params);
	public int getExpenseBudgetCount();
	public void insertExpenseBudget(ExpenseBudgetBean expenseBudget);
	public void updateExpenseBudget(ExpenseBudgetBean expenseBudget);
	public Map getSfXm(String sf_xm_name);
    public Map getSfXsNx(String xs_nx);
    public Map getSfXsCd(String xs_cd);
    public List getLdByGroupid(String groupid);
}
