/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */

package com.jd.springmvcbase.model;

import javax.validation.constraints.*;
import org.hibernate.validator.constraints.*;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

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


/**
 *
 * @author badqiu email:badqiu(a)gmail.com
 * @version 1.0
 * @since 1.0
 * */
public class Userinfo  implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "Userinfo";
	public static final String ALIAS_ID = "ID";
	public static final String ALIAS_NAME = "名称";
	public static final String ALIAS_AGE = "年龄";
	
	//date formats
	
	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
    /**
     * ID       db_column: id 
     */	
	
	private Integer id;
    /**
     * 名称       db_column: name 
     */	
	@Length(max=128)
	private String name;
    /**
     * 年龄       db_column: age 
     */	
	
	private Integer age;
	//columns END

	public Userinfo(){
	}

	public Userinfo(
		Integer id
	){
		this.id = id;
	}

	public void setId(Integer value) {
		this.id = value;
	}
	
	public Integer getId() {
		return this.id;
	}
	public void setName(String value) {
		this.name = value;
	}
	
	public String getName() {
		return this.name;
	}
	public void setAge(Integer value) {
		this.age = value;
	}
	
	public Integer getAge() {
		return this.age;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Userinfo == false) return false;
		if(this == obj) return true;
		Userinfo other = (Userinfo)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

