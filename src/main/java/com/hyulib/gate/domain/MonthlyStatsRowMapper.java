package com.hyulib.gate.domain;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MonthlyStatsRowMapper implements RowMapper<MonthlyStats>{
	@Override
	public MonthlyStats mapRow(ResultSet rs, int rowNum) throws SQLException {
		MonthlyStats monthlyStats = new MonthlyStats();
		monthlyStats.setCollege(rs.getString("COLLEGENM"));
		monthlyStats.setJanuary(rs.getInt("JANUARY"));
		monthlyStats.setFebraury(rs.getInt("FEBRAURY"));
		monthlyStats.setMarch(rs.getInt("MARCH"));
		monthlyStats.setApril(rs.getInt("APRIL"));
		monthlyStats.setMay(rs.getInt("MAY"));
		monthlyStats.setJune(rs.getInt("JUNE"));
		monthlyStats.setJuly(rs.getInt("JULY"));
		monthlyStats.setAugust(rs.getInt("AUGUST"));
		monthlyStats.setSeptember(rs.getInt("SEPTEMBER"));
		monthlyStats.setOctober(rs.getInt("OCTOBER"));
		monthlyStats.setNovember(rs.getInt("NOVEMBER"));
		monthlyStats.setDecember(rs.getInt("DECEMBER"));

		return monthlyStats;
	}

}
