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
	   * ��������ע��
	   */
	  @Autowired
	  private RuntimeService runtimeService;

	  /**
	   * ��������ע��
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
		    // 1�����������ļ�
		    repositoryService.createDeployment().name("leaveProcess")
		      .addClasspathResource("process/leaveProcess.bpmn").deploy();
		    // 2����������
		    ProcessInstance pi = runtimeService.startProcessInstanceByKey("leaveProcess");
		    // ��������ʵ��Id��ѯ����
		    Task task =  taskService.createTaskQuery().processInstanceId(pi.getProcessInstanceId()).singleResult();
		    // ��� ѧ����д��ٵ�����
		    taskService.complete(task.getId());
		    //�޸�״̬
		    leave.setState("1");
		    leave.setProcessInstanceId(pi.getProcessInstanceId());
		    // �޸���ٵ�״̬
		    leaveService.updateLeave(leave);
		    response.getWriter().print(true);
		    return  null;
	  }

}
