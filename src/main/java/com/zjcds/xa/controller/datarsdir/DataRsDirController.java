package com.zjcds.xa.controller.datarsdir;

import com.zjcds.xa.common.utils.ComboTreeModel;
import com.zjcds.xa.common.utils.CombotreeTool;
import com.zjcds.xa.common.utils.JdbcTool;
import com.zjcds.xa.service.IDataRsDirService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class DataRsDirController {
	@Autowired
	private IDataRsDirService datarsdirService;


	@RequestMapping(value="/datarsdir/sjzygk.do",method=RequestMethod.POST, consumes = "application/json")
    @ResponseBody
	public ModelAndView selectsjgk(@RequestBody Map<String,String> param){//
		String username=param.get("username");
		Map parm=new HashMap();
		MappingJacksonJsonView mpjson=new MappingJacksonJsonView();
		HashMap<String, Object> msgmap=new HashMap<String, Object>();
		List datascanList = null;
		datascanList=datarsdirService.getDataScan(parm);
		ModelAndView mv=new ModelAndView(mpjson);
        msgmap.put("data", datascanList);
        mpjson.setAttributesMap(msgmap);  
		return mv;
	}


	@RequestMapping(value="/main/selectDataTabs.do",method=RequestMethod.POST, consumes = "application/json")
	@ResponseBody
	public ModelAndView selectDataTabs(@RequestBody Map<String,String> param){//

		int currentPage=Integer.parseInt(param.get("currentPage"));
		int pageSize=Integer.parseInt(param.get("pageSize"));
		int start=(currentPage-1)*pageSize+1;
		int end=currentPage*pageSize;
		String username=param.get("username");

		Map parm=new HashMap();
		parm.put("start",start);
		parm.put("end",end);
		MappingJacksonJsonView mpjson=new MappingJacksonJsonView();
		HashMap<String, Object> msgmap=new HashMap<String, Object>();
		List datascanList = null;
		datascanList=datarsdirService.getDataTabs(parm);
		ModelAndView mv=new ModelAndView(mpjson);
		msgmap.put("data", datascanList);
		mpjson.setAttributesMap(msgmap);
		return mv;
	}


	@RequestMapping(value="/datarsdir/adddata.do",method=RequestMethod.POST, consumes = "application/json")
	@ResponseBody
	public ModelAndView addData(@RequestBody Map<String,String> param){//

		String data_dept=param.get("data_dept");
		String data_group=param.get("data_group");
		String data_name=param.get("data_name");
		String data_gettype=param.get("data_gettype");

		Map parm=new HashMap();
		parm.put("data_dept",data_dept);
		parm.put("data_group",data_group);
		parm.put("data_name",data_name);
		parm.put("data_gettype",data_gettype);
		MappingJacksonJsonView mpjson=new MappingJacksonJsonView();
		HashMap<String, Object> msgmap=new HashMap<String, Object>();
		List datascanList = null;
		datarsdirService.addData(parm);
		ModelAndView mv=new ModelAndView(mpjson);
		msgmap.put("data", datascanList);
		mpjson.setAttributesMap(msgmap);
		return mv;
	}

	@RequestMapping(value="/datarsdir/addservice.do",method=RequestMethod.POST, consumes = "application/json")
	@ResponseBody
	public ModelAndView addService(@RequestBody Map<String,String> param){//

		String service_dept=param.get("service_dept");
		String service_group=param.get("service_group");
		String service_name=param.get("service_name");
		String service_gettype=param.get("service_gettype");
		String service_description=param.get("service_description");

		Map parm=new HashMap();
		parm.put("service_dept",service_dept);
		parm.put("service_group",service_group);
		parm.put("service_name",service_name);
		parm.put("service_gettype",service_gettype);
		parm.put("service_description",service_description);
		MappingJacksonJsonView mpjson=new MappingJacksonJsonView();
		HashMap<String, Object> msgmap=new HashMap<String, Object>();
		List datascanList = null;
		datarsdirService.addService(parm);
		ModelAndView mv=new ModelAndView(mpjson);
		msgmap.put("data", datascanList);
		mpjson.setAttributesMap(msgmap);
		return mv;
	}


	@RequestMapping(value="/datarsdir/gettreedata.do",method=RequestMethod.POST, consumes = "application/json")
	@ResponseBody
	public ModelAndView getTreeData(@RequestBody Map<String,String> param){//

		String isdatatree=param.get("isdatatree");
		String tree_id=param.get("tree_id");
		String TAB_COMMENT_Q=param.get("TAB_COMMENT_Q");
		String TAB_UPDATE_TIME_Q=param.get("TAB_UPDATE_TIME_Q");
		String TAB_RG_TIME_Q=param.get("TAB_RG_TIME_Q");
		String SERVICE_NAME_Q=param.get("SERVICE_NAME_Q");
		String SERVICE_DEPT_Q=param.get("SERVICE_DEPT_Q");
		String SERVICE_GROUP_Q=param.get("SERVICE_GROUP_Q");
		String SERVICE_RG_TIME_Q=param.get("SERVICE_RG_TIME_Q");
		int currentPage=Integer.parseInt(param.get("currentPage"));
		int pageSize=Integer.parseInt(param.get("pageSize"));
		int start=(currentPage-1)*pageSize+1;
		int end=currentPage*pageSize;
		String username=param.get("username");

		Map parm=new HashMap();
		parm.put("start",start);
		parm.put("end",end);
		parm.put("tree_id",tree_id);
		parm.put("TAB_COMMENT",TAB_COMMENT_Q);
		parm.put("TAB_UPDATE_TIME",TAB_UPDATE_TIME_Q);
		parm.put("TAB_RG_TIME",TAB_RG_TIME_Q);
		parm.put("SERVICE_NAME",SERVICE_NAME_Q);
		parm.put("SERVICE_DEPT",SERVICE_DEPT_Q);
		parm.put("SERVICE_GROUP",SERVICE_GROUP_Q);
		parm.put("SERVICE_RG_TIME",SERVICE_RG_TIME_Q);

		MappingJacksonJsonView mpjson=new MappingJacksonJsonView();
		HashMap<String, Object> msgmap=new HashMap<String, Object>();
		List treeDataList = null;
		if(isdatatree.equals("yes")){//
			treeDataList=datarsdirService.getTreeDataByParam(parm);
		}else {
			treeDataList=datarsdirService.getTreeServiceByParam(parm);
		}

		ModelAndView mv=new ModelAndView(mpjson);
		msgmap.put("data", treeDataList);
		mpjson.setAttributesMap(msgmap);
		return mv;
	}

	@RequestMapping(value="/datarsdir/getcols.do",method=RequestMethod.POST, consumes = "application/json")
	@ResponseBody
	public ModelAndView getcolsByTabname(@RequestBody Map<String,String> param){//

		String TAB_NAME=param.get("TAB_NAME");
		String username=param.get("username");

		MappingJacksonJsonView mpjson=new MappingJacksonJsonView();
		HashMap<String, Object> msgmap=new HashMap<String, Object>();
		List colDataList = null;
		colDataList=datarsdirService.getcols(param);

		ModelAndView mv=new ModelAndView(mpjson);
		msgmap.put("data", colDataList);
		mpjson.setAttributesMap(msgmap);
		return mv;
	}

	@RequestMapping(value="/datarsdir/loadTableByDept.do",method=RequestMethod.POST, consumes = "application/json")
	@ResponseBody
	public ModelAndView getTableByDept(@RequestBody Map<String,String> param){//
		List<Map<String,Object>> treeDatalst;
		String data_dept=param.get("data_dept");
		String db_url=param.get("db_url");
		String db_username=param.get("db_username");
		String db_password=param.get("db_password");
//	systemId--->>		  <option value="2">交通建设管理局</option>
//                        <option value="1">公路管理局</option>
//                        <option value="4">道路运输管理局</option>
//                        <option value="3">路政管理局</option>
//                        <option value="8">地方海事局</option>
//                        <option value="6">厅农村公路处</option>
//                        <option value="7">厅路网中心</option>
		String sqlstr="select (CASE   \n" +
				"when substr(t.TABLE_NAME,1,4)='T_11'   then '11'  \n" +
				"when substr(t.TABLE_NAME,1,4)='T_12'      then '12'\n" +
				"when substr(t.TABLE_NAME,1,4)='T_21'     then '21'\n" +
				"when substr(t.TABLE_NAME,1,4)='T_31'      then '31'\n" +
				"when substr(t.TABLE_NAME,1,4)='T_32'      then '32'\n" +
				"when substr(t.TABLE_NAME,1,4)='T_41'      then '41'\n" +
				"when substr(t.TABLE_NAME,1,4)='T_42'      then '42'\n" +
				"when substr(t.TABLE_NAME,1,4)='T_51'      then '51'\n" +
				"when substr(t.TABLE_NAME,1,4)='T_61'      then '61'  \n" +
				"when substr(t.TABLE_NAME,1,4)='T_71'      then '71'\n" +
				"end)fid, t.TABLE_NAME,tt.comments\n" +
				"  from user_tables t left join user_tab_comments tt\n" +
				"    on t.TABLE_NAME = tt.table_name\n" +
				" where t.table_name like '%T_"+data_dept+"%'";



		MappingJacksonJsonView mpjson=new MappingJacksonJsonView();
		HashMap<String, Object> msgmap=new HashMap<String, Object>();
		List<Map<String, Object>> datalist;
		JdbcTool jdbcTool=new JdbcTool();
		datalist=jdbcTool.getDataByJdbc(db_url,db_username,db_password,sqlstr);
		List<ComboTreeModel> comboTreedatalist=new ArrayList();
		if("1".equals(data_dept)||"5".equals(data_dept)){
			ComboTreeModel comboTree=new ComboTreeModel();
			comboTree.setId("11");
			comboTree.setFatherId("0");
			comboTree.setName("公路日常养护管理信息系统");
			comboTreedatalist.add(comboTree);

			comboTree.setId("12");
			comboTree.setFatherId("0");
			comboTree.setName("交通量调查统计系统");
			comboTreedatalist.add(comboTree);

			comboTree.setId("51");
			comboTree.setFatherId("0");
			comboTree.setName("公路统计年报");
			comboTreedatalist.add(comboTree);

			//设置父节点
		}else if("2".equals(data_dept)){
			ComboTreeModel comboTree=new ComboTreeModel();
			comboTree.setId("21");
			comboTree.setFatherId("0");
			comboTree.setName("公路建设项目管理平台");
			comboTreedatalist.add(comboTree);

		}else if("3".equals(data_dept)){
			ComboTreeModel comboTree=new ComboTreeModel();
			comboTree.setId("31");
			comboTree.setFatherId("0");
			comboTree.setName("路政综合管理信息系统");
			comboTreedatalist.add(comboTree);

			comboTree.setId("32");
			comboTree.setFatherId("0");
			comboTree.setName("治超联网信息系统");
			comboTreedatalist.add(comboTree);

		}else if("4".equals(data_dept)){
			ComboTreeModel comboTree=new ComboTreeModel();
			comboTree.setId("41");
			comboTree.setFatherId("0");
			comboTree.setName("道路运输管理信息系统（前置机）");
			comboTreedatalist.add(comboTree);

			comboTree.setId("42");
			comboTree.setFatherId("0");
			comboTree.setName("客运微机售票系统");
			comboTreedatalist.add(comboTree);

			comboTree.setId("43");
			comboTree.setFatherId("0");
			comboTree.setName("道路运输综合统计信息管理平台");
			comboTreedatalist.add(comboTree);

		}else if("6".equals(data_dept)){
			ComboTreeModel comboTree=new ComboTreeModel();
			comboTree.setId("61");
			comboTree.setFatherId("0");
			comboTree.setName("省级交通运输投资计划管理信息系统");
			comboTreedatalist.add(comboTree);

		}else if("7".equals(data_dept)){
			ComboTreeModel comboTree=new ComboTreeModel();
			comboTree.setId("71");
			comboTree.setFatherId("0");
			comboTree.setName("应急指挥系统");
			comboTreedatalist.add(comboTree);

		}

		for(int i=0;i<datalist.size();i++){//用查询到的表数据填充树的各叶子节点
			ComboTreeModel comboTree=new ComboTreeModel();
			comboTree.setId("0000"+i);
			Map dataMap=datalist.get(i);
			comboTree.setFatherId(dataMap.get("FID").toString());
			comboTree.setName(dataMap.get("TABLE_NAME")+":"+dataMap.get("COMMENTS"));
			comboTreedatalist.add(comboTree);
		}
		CombotreeTool combtree=new CombotreeTool();
		treeDatalst=combtree.createComboTreeTree(comboTreedatalist,"0");

		ModelAndView mv=new ModelAndView(mpjson);
		msgmap.put("data", treeDatalst);
		mpjson.setAttributesMap(msgmap);
		return mv;
	}

}
