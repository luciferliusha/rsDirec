package com.zjcds.xa.controller.datarsdir;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.zjcds.xa.service.IDataRsDirService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;

import com.zjcds.xa.bean.ExpenseBudgetBean;
import com.zjcds.xa.bean.UserInfoBean;
import com.zjcds.xa.service.IExpenseBudgetService;

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
	public ModelAndView addService(@RequestBody Map<String,String> param){//��ѯ������Դ�ſ�

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
		int currentPage=Integer.parseInt(param.get("currentPage"));
		int pageSize=Integer.parseInt(param.get("pageSize"));
		int start=(currentPage-1)*pageSize+1;
		int end=currentPage*pageSize;
		String username=param.get("username");

		Map parm=new HashMap();
		parm.put("start",start);
		parm.put("end",end);
		parm.put("tree_id",tree_id);

		MappingJacksonJsonView mpjson=new MappingJacksonJsonView();
		HashMap<String, Object> msgmap=new HashMap<String, Object>();
		List treeDataList = null;
		if(isdatatree.equals("yes")){//������Դ����
			treeDataList=datarsdirService.getTreeDataByParam(parm);
		}else {
			treeDataList=datarsdirService.getTreeServiceByParam(parm);
		}

		ModelAndView mv=new ModelAndView(mpjson);
		msgmap.put("data", treeDataList);
		mpjson.setAttributesMap(msgmap);
		return mv;
	}
}
