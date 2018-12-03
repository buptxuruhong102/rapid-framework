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
public class UserinfoServiceImpl extends BaseService<Userinfo,Integer> implements IUserinfoService<Userinfo,Integer>{
	@Autowired
	private IUserinfoDao userinfoDao;

	public EntityDao getEntityDao() {
		return this.userinfoDao;
	}
	
	@Transactional(readOnly=true)
	public Page findPage(UserinfoQuery query) {
		return userinfoDao.findPage(query);
	}
	
}
