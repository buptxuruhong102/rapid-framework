/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */

package com.jd.springmvcbase.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import java.util.*;

import com.jd.springmvcbase.common.base.*;
import com.jd.springmvcbase.common.page.*;

import com.jd.springmvcbase.entity.*;
import com.jd.springmvcbase.dao.*;
import com.jd.springmvcbase.service.*;
import com.jd.springmvcbase.query.*;

/**
 * @author xuruhong
 * @version 1.0
 * @since 1.0
 */

@Repository
public class EmployeeDaoImpl extends BaseSpringJdbcDao<Employee,Integer> implements IEmployeeDao<Employee,Integer>{
	
	//注意: getSqlGenerator()可以生成基本的：增删改查sql语句, 通过这个父类已经封装了增删改查操作
    // sqlgenerator参考: http://code.google.com/p/rapid-framework/wiki/rapid_sqlgenerator
    
	public Class getEntityClass() {
		return Employee.class;
	}
	
	public void save(Employee entity) {
		String sql = getSqlGenerator().getInsertSql();
		insertWithIdentity(entity,sql); //for sqlserver and mysql
		
		//其它主键生成策略
		//insertWithOracleSequence(entity,"sequenceName",sql); //oracle sequence: 
		//insertWithDB2Sequence(entity,"sequenceName",sql); //db2 sequence:
		//insertWithUUID(entity,sql); //uuid
		//insertWithAssigned(entity,sql); //手工分配
	}
	
	public Page findPage(EmployeeQuery query) {
		StringBuilder sql = new StringBuilder("select "+ getSqlGenerator().getColumnsSql("t") + " from employee t where 1=1 ");
		if(query.getEmployeeid() != null) {
			sql.append(" and t.employeeid = :employeeid ");
		}
		if(StringUtils.isNotEmpty(query.getEmployeename())) {
			sql.append(" and t.employeename = :employeename ");
        }
		if(query.getWorkpostid() != null) {
			sql.append(" and t.workpostid = :workpostid ");
		}
		if(StringUtils.isNotEmpty(query.getWorkpostname())) {
			sql.append(" and t.workpostname = :workpostname ");
        }
		if(query.getEntrytimeBegin() != null) {
			sql.append(" and t.entrytime >= :entrytimeBegin ");
		}
		if(query.getEntrytimeEnd() != null) {
			sql.append(" and t.entrytime <= :entrytimeEnd ");
        }
		if(query.getLeavetimeBegin() != null) {
			sql.append(" and t.leavetime >= :leavetimeBegin ");
		}
		if(query.getLeavetimeEnd() != null) {
			sql.append(" and t.leavetime <= :leavetimeEnd ");
        }
		if(query.getPhone() != null) {
			sql.append(" and t.phone = :phone ");
		}
		if(query.getSalary() != null) {
			sql.append(" and t.salary = :salary ");
		}
		if(StringUtils.isNotEmpty(query.getSortColumns())) {
			sql.append(" order by :sortColumns ");
        }
		
		return pageQuery(sql.toString(),query);
	}
	

}
