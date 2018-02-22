package com.bwie.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bwie.dao.LeaveDAO;
import com.bwie.dto.Leave;
import com.bwie.service.LeaveService;
@Service
public class LeaveServiceImpl implements LeaveService{
	@Autowired
	private  LeaveDAO  leaveDAO;

	@Override
	public List<Leave> getLeavelist() {
		// TODO Auto-generated method stub
		return leaveDAO.getLeavelist();
	}

	@Override
	public void updateLeave(Leave leave) {
		// TODO Auto-generated method stub
		leaveDAO.updateLeave(leave);
	}
	
}
