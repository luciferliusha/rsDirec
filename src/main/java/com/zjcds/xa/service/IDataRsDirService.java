package com.zjcds.xa.service;

import com.zjcds.xa.bean.DataScanBean;
import com.zjcds.xa.bean.DataTabBean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/9/10.
 */
public interface IDataRsDirService {
    public List<DataScanBean> getDataScan(Map params);
    public List<DataTabBean> getDataTabs(Map params);

    public void addData(Map parm);
    public void addService(Map parm);

    public List<HashMap> getTreeDataByParam(Map param);

    public List<HashMap> getTreeServiceByParam(Map param);
}
