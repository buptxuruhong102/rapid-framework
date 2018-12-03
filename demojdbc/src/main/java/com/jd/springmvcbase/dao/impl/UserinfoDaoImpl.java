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
public class UserinfoDaoImpl extends BaseSpringJdbcDao<Userinfo,Integer> implements IUserinfoDao<Userinfo,Integer>{
	
	//注意: getSqlGenerator()可以生成基本的：增删改查sql语句, 通过这个父类已经封装了增删改查操作
    // sqlgenerator参考: http://code.google.com/p/rapid-framework/wiki/rapid_sqlgenerator
    
	public Class getEntityClass() {
		return Userinfo.class;
	}
	
	public void save(Userinfo entity) {
		String sql = getSqlGenerator().getInsertSql();
		insertWithIdentity(entity,sql); //for sqlserver and mysql
		
		//其它主键生成策略
		//insertWithOracleSequence(entity,"sequenceName",sql); //oracle sequence: 
		//insertWithDB2Sequence(entity,"sequenceName",sql); //db2 sequence:
		//insertWithUUID(entity,sql); //uuid
		//insertWithAssigned(entity,sql); //手工分配
	}
	
	public Page findPage(UserinfoQuery query) {
		StringBuilder sql = new StringBuilder("select "+ getSqlGenerator().getColumnsSql("t") + " from userinfo t where 1=1 ");
		if(query.getId() != null) {
			sql.append(" and t.id = :id ");
		}
		if(StringUtils.isNotEmpty(query.getName())) {
			sql.append(" and t.name = :name ");
        }
		if(query.getAge() != null) {
			sql.append(" and t.age = :age ");
		}
		if(StringUtils.isNotEmpty(query.getSortColumns())) {
			sql.append(" order by :sortColumns ");
        }
		
		return pageQuery(sql.toString(),query);
	}
	

}
