package com.bwie.dao;

import java.util.Map;

import com.bwie.dto.MemberShip;

public interface MemberShipDAO {

	MemberShip userLogin(Map<String, Object> map);

}
