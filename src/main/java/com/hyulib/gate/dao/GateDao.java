package com.hyulib.gate.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.hyulib.gate.domain.MonthlyStats;
import com.hyulib.gate.domain.MonthlyStatsRowMapper;
import com.hyulib.gate.domain.UserEntryLog;
import com.hyulib.gate.domain.UserEntryLogRowMapper;

@Repository
public class GateDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate = new JdbcTemplate();
	
	public List<UserEntryLog> findUserEntryLog (String userId,String sDate, String eDate){		
		String sql = 	
			"select  GM.COLLEGENM COLLEGENM,GU.GATENAME GATENAME, gu.DATE1 DATE1, GU.TIME TIME , S.USER_ID USER_ID, S.USER_NAME USER_NAME" +
			", (select name from ST_CODE where code_div='l13'and lang='kor' and code = s.USER_POSITION ) USER_POSITION  " +
			", (select name from ST_CODE where code_div='l19'and lang='kor' and code = s.STATUS_CODE ) STATUS  " +
			", (select name from st_dept where lang='kor' and company_code = s.company_code and dept_code='00000000' ) COMPANY  " +
			", (select name from st_dept where lang='kor' and company_code = s.company_code and dept_code= s.dept_code and major_code='00000000' ) DEPT  " +
			"from  tulip.st_user s inner join open.gateuser gu on (s.user_id = gu.id) INNER JOIN OPEN.GATEMASTER GM ON (GM.GATENAME=GU.GATENAME)  " +
			"WHERE GU.ID=? " +
			"AND GU.DATE1 BETWEEN ? AND ?  " +
			"ORDER BY GU.DATE1,GU.TIME, GM.COLLEGENM ";
		
		List<UserEntryLog> entryLogs =   jdbcTemplate.query(sql, new Object[]{userId,sDate,eDate}, new UserEntryLogRowMapper() );
		return entryLogs;
	}
	
	public List<MonthlyStats> findMonthlyStats (String year){
		String sql =
			"SELECT COLLEGENM,"+
			" COUNT(DECODE(MONTH, '01', ID, NULL)) JANUARY,"+
			" COUNT(DECODE(MONTH, '02', ID, NULL)) FEBRAURY,"+
			" COUNT(DECODE(MONTH, '03', ID, NULL)) MARCH, "+
			" COUNT(DECODE(MONTH, '04', ID, NULL)) APRIL,"+
			" COUNT(DECODE(MONTH, '05', ID, NULL)) MAY,"+
			" COUNT(DECODE(MONTH, '06', ID, NULL)) JUNE,"+
			" COUNT(DECODE(MONTH, '07', ID, NULL)) JULY,"+
			" COUNT(DECODE(MONTH, '08', ID, NULL)) AUGUST,"+
			" COUNT(DECODE(MONTH, '09', ID, NULL)) SEPTEMBER, "+
			" COUNT(DECODE(MONTH, '10', ID, NULL)) OCTOBER, "+
			" COUNT(DECODE(MONTH, '11', ID, NULL)) NOVEMBER, "+
			" COUNT(DECODE(MONTH, '12', ID, NULL)) DECEMBER "+
			"FROM  (SELECT GM.COLLEGENM, SUBSTR(DATE1,5,2) MONTH, ID "+
		    "       FROM OPEN.GATEMASTER GM INNER JOIN OPEN.GATEUSER GU ON (GM.GATENAME = GU.GATENAME) "+
		    "       WHERE SUBSTR(GU.DATE1,1,4) = ? "+
		    "       AND SUBSTR(GU.GATENAME,-2) <> '출구' "+
		    "       )"+
			"GROUP BY COLLEGENM";

		List<MonthlyStats> monthlyStats = jdbcTemplate.query(sql, new Object[] {year}, new MonthlyStatsRowMapper());
		return monthlyStats;
	}

}
