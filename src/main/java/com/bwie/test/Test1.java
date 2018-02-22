package com.bwie.test;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.repository.DeploymentBuilder;
import org.junit.Test;

public class Test1 {
	@Test
	public void  test1(){
		ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
	    DeploymentBuilder deploymentBuilder = processEngine.getRepositoryService().createDeployment();
	    deploymentBuilder.addClasspathResource("process/leaveProcess.bpmn");
	    deploymentBuilder.addClasspathResource("process/leaveProcess.png");
	    deploymentBuilder.deploy();
	}
}
