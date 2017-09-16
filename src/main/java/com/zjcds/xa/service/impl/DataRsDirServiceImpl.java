package com.zjcds.xa.service.impl;

import com.zjcds.xa.bean.DataScanBean;
import com.zjcds.xa.bean.DataTabBean;
import com.zjcds.xa.dao.IDataRsDirDao;
import com.zjcds.xa.service.IDataRsDirService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/9/10.
 */
@Service
public class DataRsDirServiceImpl implements IDataRsDirService{

    @Autowired
    private IDataRsDirDao dataRsDirDao;
    public List<DataScanBean> getDataScan(Map params){
        return dataRsDirDao.getDataScanByParam(params);
    }
    public List<DataTabBean> getDataTabs(Map params){
        return dataRsDirDao.getDataTabs(params);
    }
    public void addData(Map params){
        dataRsDirDao.addData(params);
    }
    public void addService(Map params){
        dataRsDirDao.addService(params);
    }
    public List<HashMap> getTreeDataByParam(Map param){
        return dataRsDirDao.getTreeDataByParam(param);
    }
    public List<HashMap> getTreeServiceByParam(Map param){
        return dataRsDirDao.getTreeServiceByParam(param);
    }
}
