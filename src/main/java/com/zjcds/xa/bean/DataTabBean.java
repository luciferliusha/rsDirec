package com.zjcds.xa.bean;

/**
 * Created by Administrator on 2017/9/10.
 */
public class DataTabBean {
    private int RN;
    private String tab_name;
    private int tab_rows;
    private String tab_comment;

    public int getRN() {
        return RN;
    }

    public void setRN(int RN) {
        this.RN = RN;
    }

    public String getTab_name() {
        return tab_name;
    }

    public void setTab_name(String tab_name) {
        this.tab_name = tab_name;
    }

    public int getTab_rows() {
        return tab_rows;
    }

    public void setTab_rows(int tab_rows) {
        this.tab_rows = tab_rows;
    }

    public String getTab_comment() {
        return tab_comment;
    }

    public void setTab_comment(String tab_comment) {
        this.tab_comment = tab_comment;
    }
}
