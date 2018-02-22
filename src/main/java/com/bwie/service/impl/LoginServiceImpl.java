package com.bwie.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bwie.dao.LoginDAO;
import com.bwie.dao.MemberShipDAO;
import com.bwie.dto.Group;
import com.bwie.dto.MemberShip;
import com.bwie.service.LoginService;
@Service
public class LoginServiceImpl implements LoginService{
	 @Autowired
	 private  LoginDAO   loginDAO;
	 @Autowired
	 private  MemberShipDAO   memberShipDAO;

	@Override
	public List<Group> findGroup() {
		// TODO Auto-generated method stub
		return loginDAO.findGroup();
	}

	@Override
	public MemberShip userLogin(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return memberShipDAO.userLogin(map);
	}
}
