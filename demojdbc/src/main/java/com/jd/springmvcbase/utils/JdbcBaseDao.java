package com.jd.springmvcbase.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class JdbcBaseDao {
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setJDBCDataSource(@Qualifier("dataSource") final DataSource datasource) {
		jdbcTemplate = new JdbcTemplate(datasource);
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

}
