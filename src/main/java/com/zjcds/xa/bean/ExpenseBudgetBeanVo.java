package com.zjcds.xa.bean;

/*
 * 前台展示用的bean
 * 
 */

public class ExpenseBudgetBeanVo {

	private String id;
	private String ld;//路段名称
	private String xmmc;//项目名称
	private String shuliang;//数量
	private String qd_zh;//起点桩号
	private String zd_zh;//止点桩号
	private String wh_lc;//维护里程
	private String tr_yxsj;//投入运行shijian
	private String nx;//年限
	private String nx_tzxs;//年限调整系数（系数表的系数）
	private String sd_jkxs;//隧道监控调整系数（系数表的系数）
	private String tbr;//填报人
	private String beizhu;
	private String tbsj;//填报时间 
	private String jsgs;//计算公式
	private String fyxj;//费用小记
	private String xtmc;//系统名称
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLd() {
		return ld;
	}
	public void setLd(String ld) {
		this.ld = ld;
	}
	public String getShuliang() {
		return shuliang;
	}
	public void setShuliang(String shuliang) {
		this.shuliang = shuliang;
	}
	public String getQd_zh() {
		return qd_zh;
	}
	public void setQd_zh(String qd_zh) {
		this.qd_zh = qd_zh;
	}
	public String getZd_zh() {
		return zd_zh;
	}
	public void setZd_zh(String zd_zh) {
		this.zd_zh = zd_zh;
	}
	public String getWh_lc() {
		return wh_lc;
	}
	public void setWh_lc(String wh_lc) {
		this.wh_lc = wh_lc;
	}
	public String getTr_yxsj() {
		return tr_yxsj;
	}
	public void setTr_yxsj(String tr_yxsj) {
		this.tr_yxsj = tr_yxsj;
	}
	public String getNx() {
		return nx;
	}
	public void setNx(String nx) {
		this.nx = nx;
	}
	public String getNx_tzxs() {
		return nx_tzxs;
	}
	public void setNx_tzxs(String nx_tzxs) {
		this.nx_tzxs = nx_tzxs;
	}
	public String getSd_jkxs() {
		return sd_jkxs;
	}
	public void setSd_jkxs(String sd_jkxs) {
		this.sd_jkxs = sd_jkxs;
	}
	public String getTbr() {
		return tbr;
	}
	public void setTbr(String tbr) {
		this.tbr = tbr;
	}
	public String getBeizhu() {
		return beizhu;
	}
	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}
	public void setTbsj(String tbsj) {
		this.tbsj = tbsj;
	}
	public String getTbsj() {
		return tbsj;
	}
	public void setJsgs(String jsgs) {
		this.jsgs = jsgs;
	}
	public String getJsgs() {
		return jsgs;
	}
	public void setFyxj(String fyxj) {
		this.fyxj = fyxj;
	}
	public String getFyxj() {
		return fyxj;
	}
	public void setXmmc(String xmmc) {
		this.xmmc = xmmc;
	}
	public String getXmmc() {
		return xmmc;
	}
	public void setXtmc(String xtmc) {
		this.xtmc = xtmc;
	}
	public String getXtmc() {
		return xtmc;
	}
}
