package com.bwie.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bwie.dto.Leave;
import com.bwie.service.LeaveService;

@Controller
public class LeaveController {
	@Autowired
	private  LeaveService  leaveService;
	
	@Autowired
	  private RepositoryService repositoryService;

	  /**
	   * 启动流程注入
	   */
	  @Autowired
	  private RuntimeService runtimeService;

	  /**
	   * 启动任务注入
	   */
	  @Autowired
	  private TaskService taskService;
	  
	  @RequestMapping("leavelist")
	  public String leavelist(HttpServletRequest request) {
		  List<Leave> leavelist = leaveService.getLeavelist();
		  request.setAttribute("leavelist", leavelist);
		  
		  return "/manager/leaveManage";
	  }
	  
	  @RequestMapping("startApply")
	  public String startApply(HttpServletResponse response, Leave leave, String id) throws IOException {
		    // 1、部署流程文件
		    repositoryService.createDeployment().name("leaveProcess")
		      .addClasspathResource("process/leaveProcess.bpmn").deploy();
		    // 2、启动流程
		    ProcessInstance pi = runtimeService.startProcessInstanceByKey("leaveProcess");
		    // 根据流程实例Id查询任务
		    Task task =  taskService.createTaskQuery().processInstanceId(pi.getProcessInstanceId()).singleResult();
		    // 完成 学生填写请假单任务
		    taskService.complete(task.getId());
		    //修改状态
		    leave.setState("1");
		    leave.setProcessInstanceId(pi.getProcessInstanceId());
		    // 修改请假单状态
		    leaveService.updateLeave(leave);
		    response.getWriter().print(true);
		    return  null;
	  }

}
