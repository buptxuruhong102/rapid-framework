/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */

package com.jd.springmvcbase.query;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

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


public class EmployeeQuery extends BaseQuery implements Serializable {
    private static final long serialVersionUID = 3148176768559230877L;
    

	/** 员工ID */
	private Integer employeeid;
	/** 员工名称 */
	private String employeename;
	/** 工作岗位ID */
	private Integer workpostid;
	/** 工作岗位名称 */
	private String workpostname;
	/** 入职时间 */
	private java.util.Date entrytimeBegin;
	private java.util.Date entrytimeEnd;
	/** 离职时间 */
	private java.util.Date leavetimeBegin;
	private java.util.Date leavetimeEnd;
	/** 电话号码 */
	private Integer phone;
	/** 薪资 */
	private java.lang.Float salary;

	public Integer getEmployeeid() {
		return this.employeeid;
	}
	
	public void setEmployeeid(Integer value) {
		this.employeeid = value;
	}
	
	public String getEmployeename() {
		return this.employeename;
	}
	
	public void setEmployeename(String value) {
		this.employeename = value;
	}
	
	public Integer getWorkpostid() {
		return this.workpostid;
	}
	
	public void setWorkpostid(Integer value) {
		this.workpostid = value;
	}
	
	public String getWorkpostname() {
		return this.workpostname;
	}
	
	public void setWorkpostname(String value) {
		this.workpostname = value;
	}
	
	public java.util.Date getEntrytimeBegin() {
		return this.entrytimeBegin;
	}
	
	public void setEntrytimeBegin(java.util.Date value) {
		this.entrytimeBegin = value;
	}	
	
	public java.util.Date getEntrytimeEnd() {
		return this.entrytimeEnd;
	}
	
	public void setEntrytimeEnd(java.util.Date value) {
		this.entrytimeEnd = value;
	}
	
	public java.util.Date getLeavetimeBegin() {
		return this.leavetimeBegin;
	}
	
	public void setLeavetimeBegin(java.util.Date value) {
		this.leavetimeBegin = value;
	}	
	
	public java.util.Date getLeavetimeEnd() {
		return this.leavetimeEnd;
	}
	
	public void setLeavetimeEnd(java.util.Date value) {
		this.leavetimeEnd = value;
	}
	
	public Integer getPhone() {
		return this.phone;
	}
	
	public void setPhone(Integer value) {
		this.phone = value;
	}
	
	public java.lang.Float getSalary() {
		return this.salary;
	}
	
	public void setSalary(java.lang.Float value) {
		this.salary = value;
	}
	

	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.MULTI_LINE_STYLE);
	}
	
}

