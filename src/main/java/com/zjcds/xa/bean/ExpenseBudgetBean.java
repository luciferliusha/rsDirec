package com.zjcds.xa.bean;

import org.springframework.stereotype.Component;

@Component("expenseBudget")
public class ExpenseBudgetBean {
	
	private String id;
	private String ld;//·������
	private String xmmc;//��Ŀ����
	private String shuliang;//����
	private float qd_zh;//���׮��
	private float zd_zh;//ֹ��׮��
	private float wh_lc;//ά�����
	private String tr_yxsj;//Ͷ������shijian
	private String nx;//����
	private String nx_tzxs;//���޵���ϵ����ϵ�����id��
	private String sd_jkxs;//�����ص���ϵ����ϵ�����id��
	private String tbr;//���
	private String beizhu;
	private String tbsj;//�ʱ�� 
	private String xtmc;//ϵͳ����
	private String fyxj;//����С��
	private String update_flag;//0��ʾ�����޸ģ�1��ʾ���޸�
	private String sh_zt;;//0:δ��ˣ�1:���ͨ����2:���δͨ��
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
	public float getQd_zh() {
		return qd_zh;
	}
	public void setQd_zh(float qd_zh) {
		this.qd_zh = qd_zh;
	}
	public float getZd_zh() {
		return zd_zh;
	}
	public void setZd_zh(float zd_zh) {
		this.zd_zh = zd_zh;
	}
	public float getWh_lc() {
		return wh_lc;
	}
	public void setWh_lc(float wh_lc) {
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
	public void setXmmc(String xmmc) {
		this.xmmc = xmmc;
	}
	public String getXmmc() {
		return xmmc;
	}
	public void setFyxj(String fyxj) {
		this.fyxj = fyxj;
	}
	public String getFyxj() {
		return fyxj;
	}
	public void setXtmc(String xtmc) {
		this.xtmc = xtmc;
	}
	public String getXtmc() {
		return xtmc;
	}
	public void setUpdate_flag(String update_flag) {
		this.update_flag = update_flag;
	}
	public String getUpdate_flag() {
		return update_flag;
	}
	public void setSh_zt(String sh_zt) {
		this.sh_zt = sh_zt;
	}
	public String getSh_zt() {
		return sh_zt;
	}


}
