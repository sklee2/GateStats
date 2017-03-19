package com.hyulib.gate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hyulib.gate.dao.GateDao;
import com.hyulib.gate.domain.MonthlyStats;
import com.hyulib.gate.domain.UserEntryLog;

@CrossOrigin

@RestController
@RequestMapping("gate")
public class GateController {
	@Autowired
	private GateDao gateDao;
	
	@RequestMapping(method = RequestMethod.GET, value = {"/userentrylog/{userId}/{sDate}/{eDate}"})
	public List<UserEntryLog> findUserEntryLog (@PathVariable String userId,@PathVariable String sDate,@PathVariable String eDate){
		return gateDao.findUserEntryLog(userId,sDate,eDate);
	}

	@RequestMapping(method = RequestMethod.GET, value = {"/monthlystats/{year}"})
	public List<MonthlyStats> findMonthlyStats (@PathVariable String year){
		return gateDao.findMonthlyStats(year);
	}
	
	
}
