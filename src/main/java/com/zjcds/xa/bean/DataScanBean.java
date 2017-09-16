package com.zjcds.xa.bean;

import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/9/10.
 */
@Component("datascan")
public class DataScanBean {
    private int id;
    private String data_from_dept	;
    private String data_from_system;
    private String data_etl_type;
    private String data_etl_freq;
    private long data_tab_rows;
    private long data_space_usage;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getData_from_dept() {
        return data_from_dept;
    }

    public void setData_from_dept(String data_from_dept) {
        this.data_from_dept = data_from_dept;
    }

    public String getData_from_system() {
        return data_from_system;
    }

    public void setData_from_system(String data_from_system) {
        this.data_from_system = data_from_system;
    }

    public String getData_etl_type() {
        return data_etl_type;
    }

    public void setData_etl_type(String data_etl_type) {
        this.data_etl_type = data_etl_type;
    }

    public String getData_etl_freq() {
        return data_etl_freq;
    }

    public void setData_etl_freq(String data_etl_freq) {
        this.data_etl_freq = data_etl_freq;
    }

    public long getData_tab_rows() {
        return data_tab_rows;
    }

    public void setData_tab_rows(long data_tab_rows) {
        this.data_tab_rows = data_tab_rows;
    }

    public long getData_space_usage() {
        return data_space_usage;
    }

    public void setData_space_usage(long data_space_usage) {
        this.data_space_usage = data_space_usage;
    }
}