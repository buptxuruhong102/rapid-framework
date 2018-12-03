/*
 * @(#)UserInfo.java
 *
 * CopyRight (c) 2017 北京京东尚科信息技术有限公司 保留所有权利。
 */
package com.jd.springmvcbase.model;

import javax.persistence.Id;
import javax.persistence.Transient;

/**
 * Title : UserInfo
 * <p/>
 * Description : 
 * <p/>
 * CopyRight : CopyRight (c) 2017
 * <p/>
 * Company : 北京京东尚科信息技术有限公司
 * <p/>
 * JDK Version Used : JDK 1.8 +
 * <p/>
 * Modification History	:
 * <p/>
 * <pre>NO.    Date    Modified By    Why & What is modified</pre>
 * <pre>1    2017年5月17日    haozhifeng        Created</pre>
 * <p/>
 *
 * @author  haozhifeng
 * @version 1.0.0.2017年5月17日
 */
public class UserInfo implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;

	private Long userId;
    /**
     * account       db_column: account
     */
	private String account;
    /**
     * 0：超级管理员             1：模板设计师             2：普通用户       db_column: user_type
     */

	private Long userType;
	//columns END

	//用于登录缓存
	private long expire;

	//注意： spring_jdbc的MetadataCreateUtils.fromTable(Entity.class) 可以读取JPA annotation的标注信息
	//现支持 @Id,@Column,@Table标注

	public UserInfo(){
	}

	public UserInfo(
		Long userId
	){
		this.userId = userId;
	}

	@Id
	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long value) {
		this.userId = value;
	}

	public String getAccount() {
		return this.account;
	}

	public void setAccount(String value) {
		this.account = value;
	}


	public Long getUserType() {
		return this.userType;
	}

	public void setUserType(Long value) {
		this.userType = value;
	}

	@Transient
	public long getExpire() {
		return expire;
	}

	public void setExpire(long expire) {
		this.expire = expire;
	}
}

