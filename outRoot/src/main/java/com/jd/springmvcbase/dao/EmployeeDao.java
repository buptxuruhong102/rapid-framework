/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */

package com.jd.springmvcbase.dao;

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


import org.springframework.stereotype.Repository;

/**
 *
 * @author badqiu email:badqiu(a)gmail.com
 * @version 1.0
 * @since 1.0
 * */
@Repository
public class EmployeeDao extends BaseMybatisDao<Employee,Integer>{
	
	@Override
	public String getMybatisMapperNamesapce() {
		return "Employee";
	}
	
	public void saveOrUpdate(Employee entity) {
		if(entity.getEmployeeid() == null) 
			save(entity);
		else 
			update(entity);
	}
	
	public Page findPage(EmployeeQuery query) {
		return pageQuery(getSqlSession(),"Employee.findPage",query);
	}
	

}
