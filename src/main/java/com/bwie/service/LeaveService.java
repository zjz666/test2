package com.bwie.service;

import java.util.List;

import com.bwie.dto.Leave;

public interface LeaveService {

	List<Leave> getLeavelist();

	void updateLeave(Leave leave);

}
