package com.bwie.dao;

import java.util.List;
import java.util.Map;

import com.bwie.dto.Group;
import com.bwie.dto.MemberShip;

public interface LoginDAO {

	List<Group> findGroup();

	MemberShip userLogin(Map<String, Object> map);

}
