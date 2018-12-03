<#include "/java_copyright.include">
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
package ${basepackage}.service;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
<#include "/java_imports.include">
public interface I${className}Service<T,PK extends java.io.Serializable> extends IBaseService<T,PK>{

    public Page findPage(${className}Query query);
}
