<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

<#include "/java_imports.include">
@Service
@Transactional
public class ${className}ServiceImpl extends BaseService<${className},${table.idColumn.javaType}> implements I${className}Service<${className},${table.idColumn.javaType}>{
	@Autowired
	private I${className}Dao ${classNameLower}Dao;

	public EntityDao getEntityDao() {
		return this.${classNameLower}Dao;
	}
	
	@Transactional(readOnly=true)
	public Page findPage(${className}Query query) {
		return ${classNameLower}Dao.findPage(query);
	}
	
<#list table.columns as column>
	<#if column.unique && !column.pk>
	@Transactional(readOnly=true)
	public ${className} getBy${column.columnName}(${column.javaType} v) {
		return ${classNameLower}Dao.getBy${column.columnName}(v);
	}	
	
	</#if>
</#list>
}
