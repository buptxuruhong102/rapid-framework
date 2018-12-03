/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */

package com.jd.springmvcbase.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.*;

import com.jd.springmvcbase.utils.DateConvertUtils;

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


public class Employee extends BaseEntity implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "Employee";
	public static final String ALIAS_EMPLOYEEID = "员工ID";
	public static final String ALIAS_EMPLOYEENAME = "员工名称";
	public static final String ALIAS_WORKPOSTID = "工作岗位ID";
	public static final String ALIAS_WORKPOSTNAME = "工作岗位名称";
	public static final String ALIAS_ENTRYTIME = "入职时间";
	public static final String ALIAS_LEAVETIME = "离职时间";
	public static final String ALIAS_PHONE = "电话号码";
	public static final String ALIAS_SALARY = "薪资";
	
	//date formats
	public static final String FORMAT_ENTRYTIME = DATE_FORMAT;
	public static final String FORMAT_LEAVETIME = DATE_FORMAT;
	
	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
    /**
     * 员工ID       db_column: employeeid 
     */ 	
	private Integer employeeid;
    /**
     * 员工名称       db_column: employeename 
     */ 	
	private String employeename;
    /**
     * 工作岗位ID       db_column: workpostid 
     */ 	
	private Integer workpostid;
    /**
     * 工作岗位名称       db_column: workpostname 
     */ 	
	private String workpostname;
    /**
     * 入职时间       db_column: entrytime 
     */ 	
	private java.util.Date entrytime;
    /**
     * 离职时间       db_column: leavetime 
     */ 	
	private java.util.Date leavetime;
    /**
     * 电话号码       db_column: phone 
     */ 	
	private Integer phone;
    /**
     * 薪资       db_column: salary 
     */ 	
	private java.lang.Float salary;
	//columns END
	
	//注意： spring_jdbc的MetadataCreateUtils.fromTable(Entity.class) 可以读取JPA annotation的标注信息
	//现支持 @Id,@Column,@Table标注

	public Employee(){
	}

	public Employee(
		Integer employeeid
	){
		this.employeeid = employeeid;
	}

	@Id
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
	
	public java.util.Date getEntrytime() {
		return this.entrytime;
	}
	
	public void setEntrytime(java.util.Date value) {
		this.entrytime = value;
	}
	
	public java.util.Date getLeavetime() {
		return this.leavetime;
	}
	
	public void setLeavetime(java.util.Date value) {
		this.leavetime = value;
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
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Employeeid",getEmployeeid())
			.append("Employeename",getEmployeename())
			.append("Workpostid",getWorkpostid())
			.append("Workpostname",getWorkpostname())
			.append("Entrytime",getEntrytime())
			.append("Leavetime",getLeavetime())
			.append("Phone",getPhone())
			.append("Salary",getSalary())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getEmployeeid())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Employee == false) return false;
		if(this == obj) return true;
		Employee other = (Employee)obj;
		return new EqualsBuilder()
			.append(getEmployeeid(),other.getEmployeeid())
			.isEquals();
	}
}

