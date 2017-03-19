package com.hyulib.gate.domain;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class UserEntryLogRowMapper implements RowMapper<UserEntryLog>{
	@Override
	public UserEntryLog mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserEntryLog entryLog = new UserEntryLog();
		entryLog.setCollege(rs.getString("COLLEGENM"));
		entryLog.setGate(rs.getString("GATENAME"));
		entryLog.setEntryDate(rs.getString("DATE1"));		
		entryLog.setEntryTime(rs.getString("TIME"));		
		entryLog.setUserId(rs.getString("USER_ID"));
		entryLog.setUserName(rs.getString("USER_NAME"));
		entryLog.setUserPosition(rs.getString("USER_POSITION"));			
		entryLog.setCompany(rs.getString("COMPANY"));	
		entryLog.setDept(rs.getString("DEPT"));	
		return entryLog;
		
	}

}

