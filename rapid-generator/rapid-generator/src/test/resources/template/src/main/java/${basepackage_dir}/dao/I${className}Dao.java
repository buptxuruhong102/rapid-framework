<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>   
package ${basepackage}.dao;

import java.io.Serializable;
import java.util.List;

import com.jd.springmvcbase.common.base.EntityDao;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

<#include "/java_imports.include">
public interface I${className}Dao<E,PK extends java.io.Serializable> extends EntityDao<E,PK> {

	public Page findPage(${className}Query query);
}
