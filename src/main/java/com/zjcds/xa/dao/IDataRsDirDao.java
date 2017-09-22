package com.zjcds.xa.dao;

import com.zjcds.xa.bean.DataScanBean;
import com.zjcds.xa.bean.DataTabBean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/9/10.
 */
public interface IDataRsDirDao {
    public List<DataScanBean> getDataScanByParam(Map params);
    public List<DataTabBean> getDataTabs(Map params);
    public void addData(Map parm);

    public List<HashMap> getTreeDataByParam(Map param);
    public List<HashMap> getTreeServiceByParam(Map param);

    public void addService(Map params);

    public List<HashMap> getcols(Map params);
}
