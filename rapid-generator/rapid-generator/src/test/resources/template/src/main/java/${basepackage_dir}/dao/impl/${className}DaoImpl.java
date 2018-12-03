<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>   
package ${basepackage}.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

<#include "/java_imports.include">
@Repository
public class ${className}DaoImpl extends BaseSpringJdbcDao<${className},${table.idColumn.javaType}> implements I${className}Dao<${className},${table.idColumn.javaType}>{
	
	//注意: getSqlGenerator()可以生成基本的：增删改查sql语句, 通过这个父类已经封装了增删改查操作
    // sqlgenerator参考: http://code.google.com/p/rapid-framework/wiki/rapid_sqlgenerator
    
	public Class getEntityClass() {
		return ${className}.class;
	}
	
	public void save(${className} entity) {
		String sql = getSqlGenerator().getInsertSql();
		insertWithIdentity(entity,sql); //for sqlserver and mysql
		
		//其它主键生成策略
		//insertWithOracleSequence(entity,"sequenceName",sql); //oracle sequence: 
		//insertWithDB2Sequence(entity,"sequenceName",sql); //db2 sequence:
		//insertWithUUID(entity,sql); //uuid
		//insertWithAssigned(entity,sql); //手工分配
	}
	
	public Page findPage(${className}Query query) {
		StringBuilder sql = new StringBuilder("select "+ getSqlGenerator().getColumnsSql("t") + " from ${table.sqlName} t where 1=1 ");
		<#list table.columns as column>
		<#if column.isDateTimeColumn>
		if(query.get${column.columnName}Begin() != null) {
			sql.append(" and t.${column.sqlName} >= :${column.columnNameLower}Begin ");
		}
		if(query.get${column.columnName}End() != null) {
			sql.append(" and t.${column.sqlName} <= :${column.columnNameLower}End ");
        }
		<#elseif column.isNumberColumn>
		if(query.get${column.columnName}() != null) {
			sql.append(" and t.${column.sqlName} = :${column.columnNameLower} ");
		}
		<#else>
		if(StringUtils.isNotEmpty(query.get${column.columnName}())) {
			sql.append(" and t.${column.sqlName} = :${column.columnNameLower} ");
        }
		</#if>
		</#list>
		if(StringUtils.isNotEmpty(query.getSortColumns())) {
			sql.append(" order by :sortColumns ");
        }
		
		return pageQuery(sql.toString(),query);
	}
	
	<#list table.columns as column>
	<#if column.unique && !column.pk>
	public ${className} getBy${column.columnName}(${column.javaType} v) {
		String sql = "select " + getSqlGenerator().getColumnsSql() + " from ${table.sqlName} where ${column.columnNameLower}=?";
		return (${className})DataAccessUtils.singleResult(getSimpleJdbcTemplate().queryForList(sql, ParameterizedBeanPropertyRowMapper.newInstance(getEntityClass()), v));
	}	
	
	</#if>
	</#list>

}
