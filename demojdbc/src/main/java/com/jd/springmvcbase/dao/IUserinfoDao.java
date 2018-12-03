/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */

package com.jd.springmvcbase.dao;

import java.io.Serializable;
import java.util.List;

import com.jd.springmvcbase.common.base.EntityDao;
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

public interface IUserinfoDao<E,PK extends java.io.Serializable> extends EntityDao<E,PK> {

	public Page findPage(UserinfoQuery query);
}
