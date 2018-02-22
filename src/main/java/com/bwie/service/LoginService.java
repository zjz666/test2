package com.bwie.service;

import java.util.List;
import java.util.Map;

import com.bwie.dto.Group;
import com.bwie.dto.MemberShip;

public interface LoginService {

	List<Group> findGroup();

	MemberShip userLogin(Map<String, Object> map);

}
