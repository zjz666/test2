package com.bwie.dao;

import java.util.List;

import com.bwie.dto.Leave;

public interface LeaveDAO {

	List<Leave> getLeavelist();

	void updateLeave(Leave leave);

}
