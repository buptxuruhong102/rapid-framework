/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */

package com.jd.springmvcbase.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

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

@Service
@Transactional
public class EmployeeServiceImpl extends BaseService<Employee,Integer> implements IEmployeeService<Employee,Integer>{
	@Autowired
	private IEmployeeDao employeeDao;

	public EntityDao getEntityDao() {
		return this.employeeDao;
	}
	
	@Transactional(readOnly=true)
	public Page findPage(EmployeeQuery query) {
		return employeeDao.findPage(query);
	}
	
}
