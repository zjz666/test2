package com.bwie.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bwie.dto.Group;
import com.bwie.dto.MemberShip;
import com.bwie.service.LoginService;
import com.bwie.test.ResponseUtil;

@Controller
public class LoginController {
		@Autowired
		private  LoginService  loginService;
		
		@RequestMapping("findGroup")
		public String findGroup(HttpServletResponse response) throws IOException{
			List<Group> groupList = loginService.findGroup();
			
			Object obj = JSON.toJSON(groupList);
			
			response.setContentType("text/html;charset=UTF-8");
			
			response.getWriter().print(obj);
			return null;
		}
		
		@RequestMapping("userLogin")
		public String userLogin(HttpServletResponse response,HttpServletRequest request) throws Exception{
			 Map<String, Object> map = new HashMap<String, Object>();
			    map.put("userName", request.getParameter("userName"));
			    map.put("password", request.getParameter("password"));
			    map.put("groupId", request.getParameter("groupId"));
			    MemberShip memberShip = loginService.userLogin(map);
			    JSONObject result=new JSONObject();
				if(memberShip==null){
					result.put("success", false);
					result.put("errorInfo", "用户名或者密码错误！");
				}else{
					result.put("success", true);
					request.getSession().setAttribute("currentMemberShip", memberShip);
				}
				ResponseUtil.write(response, result);
			    return null;
		}
}
