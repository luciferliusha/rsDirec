package com.zjcds.xa.controller.userlogin;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;

import com.zjcds.xa.bean.UserInfoBean;
import com.zjcds.xa.service.IUserInfoService;
 
@Controller
//@RequestMapping("/login")
public class ValidationController {
	
    @Autowired
    private IUserInfoService userInfoService;
    
    /**
     * 
     * @param request
     * @param response
     * @param command
     * @param errors
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/login/login.do",method=RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    protected ModelAndView onSubmit(@RequestBody UserInfoBean userinfo,HttpSession session)
           throws Exception { 
       	
       UserInfoBean dbUser=getDbUser(userinfo.getLogin_name());
       if(dbUser==null){
    	   HashMap<String, String> msgmap=new HashMap<String, String>();
    	   msgmap.put("vstatus", "false");
    	   msgmap.put("messages", "用户不存在！");
    	   MappingJacksonJsonView mpjson=new MappingJacksonJsonView();
    	   ModelAndView mv=new ModelAndView(mpjson,msgmap);    	  
    	   return mv;
       }else{
    	   if (userinfo.getLogin_name().equals(dbUser.getLogin_name()) && userinfo.getPassword().equals(dbUser.getPassword())){
               HashMap<String, String> msgmap=new HashMap<String, String>();
               msgmap.put("vstatus", "true");
               MappingJacksonJsonView mpjson=new MappingJacksonJsonView();
               ModelAndView mv=new ModelAndView(mpjson,msgmap);
               session.setAttribute("loginuserinfo", dbUser);
               return mv;
           }else{
        	   HashMap<String, String> msgmap=new HashMap<String, String>();
        	   msgmap.put("vstatus", "false");
        	   msgmap.put("messages", "用户名或密码错误！");
        	   MappingJacksonJsonView mpjson=new MappingJacksonJsonView();
        	   ModelAndView mv=new ModelAndView(mpjson,msgmap);    	  
        	   return mv;
       }
       
       }
      
    }
    /**
     * 
     * @param name
     * @return
     */
    private UserInfoBean getDbUser(String name){
    	return userInfoService.getUserInfo(name);
    }
   
   
}