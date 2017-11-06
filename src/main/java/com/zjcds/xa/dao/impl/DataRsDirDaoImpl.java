package com.zjcds.xa.dao.impl;

import com.zjcds.xa.bean.DataTabBean;
import com.zjcds.xa.dao.IDataRsDirDao;
import com.zjcds.xa.dao.base.MyBaseDao;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/9/10.
 */
@Repository
public class DataRsDirDaoImpl  extends MyBaseDao implements IDataRsDirDao{

    public List<HashMap> getDataScanByParam(Map params){
        List datascanlst=new ArrayList<HashMap>();
        datascanlst=this.getSqlSession().selectList("getDataScan",params);
        return datascanlst;
    }

    public List<DataTabBean> getDataTabs(Map params){
        List datatabslst=new ArrayList<DataTabBean>();
        //DataTabBean datastabs=null;
        datatabslst=this.getSqlSession().selectList("getDataTabs",params);

        //datatabslst.add(datastabs);
        return datatabslst;
    }

    public void addData(Map params) {
        String data_gettype= params.get("data_gettype").toString();
        String[] data_gettypes=data_gettype.split(";");
        for(int i=0;i<data_gettypes.length;i++){
            Map  paramap=new HashMap();
            paramap.put("data_gettype",data_gettypes[i]);
            paramap.put("data_dept",params.get("data_dept"));
            paramap.put("data_group",params.get("data_group"));
            paramap.put("data_name",params.get("data_name"));
            this.getSqlSession().insert("addData",paramap);
        }

    }

    public void addService(Map params){
        this.getSqlSession().insert("addService",params);
    }

    public List<HashMap> getcols(Map params) {
        List coldatalst=new ArrayList<HashMap>();
        coldatalst=this.getSqlSession().selectList("getcols",params);

        return coldatalst;
    }

    public List<HashMap> getTreeDataByParam(Map param){
        List treedatalst=new ArrayList<HashMap>();
        treedatalst=this.getSqlSession().selectList("getTreeData",param);

        return treedatalst;
    }
    public List<HashMap> getTreeServiceByParam(Map param){
        List treeservicelst=new ArrayList<HashMap>();

        treeservicelst=this.getSqlSession().selectList("getTreeService",param);

        return treeservicelst;
    }


}
