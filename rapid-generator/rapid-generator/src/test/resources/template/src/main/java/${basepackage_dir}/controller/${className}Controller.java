<#include "/custom.include">
<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>   
package ${basepackage}.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import com.jd.springmvcbase.utils.Response;


<#include "/java_imports.include">

@Controller
@RequestMapping(value = "/${classNameLower}")
public class ${className}Controller{
	//默认多列排序,example: username desc,createTime asc
	protected static final String DEFAULT_SORT_COLUMNS = null;
	@Autowired
	private I${className}Service<${className},${table.idColumn.javaType}> ${classNameLower}Service;

	/**
	 * 首页
	 * @return
	 */
	@RequestMapping(value = "/index")
	public String index() {
		return "/${classNameLower}/${classNameLower}_index";
	}

	/** 
	 * 执行搜索 
	 **/
	@RequestMapping(value = "/list")
	@ResponseBody
	public Page list(HttpServletRequest request,HttpServletResponse response,${className}Query query) {
		Page page = this.${classNameLower}Service.findPage(query);

		return page;
	}

	/**
	 * 新增页面初始化
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/add")
	public String add(Model model) {
		model.addAttribute("title", "新建用户");
		return "/${classNameLower}/${classNameLower}_add";
	}

	/**
	 * 编辑页面初始化
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/edit")
	public String edit(Model model, int id) {
		${className} entity = this.${classNameLower}Service.getById(id);
		model.addAttribute("title", "修改密码");
		model.addAttribute("${classNameLower}", entity);
		return "/${classNameLower}/${classNameLower}_add";
	}

	/**
	 * 新增或修改保存
	 * @param entity
	 * @param request
	 */
	@ResponseBody
	@RequestMapping(value = "/save")
	public Response save(${className} entity, HttpServletRequest request){
		this.${classNameLower}Service.saveOrUpdate(entity);
		return Response.build().success();
	}

	/**
	 * 删除数据
	 * @param id
	 */
	@ResponseBody
	@RequestMapping(value = "/del")
	public Response del(int id){
		try{
			this.${classNameLower}Service.removeById(id);
		}catch (Exception e){
			return Response.build().fail(e);
		}
		return Response.build().success();
	}

}

<#macro generateIdParameter>
	<#if table.compositeId>
		${className}Id id = new ${className}Id();
		bind(request, id);
	<#else>
		<#list table.compositeIdColumns as column>
		${column.javaType} id = new ${column.javaType}(request.getParameter("${column.columnNameLower}"));
		</#list>
	</#if>
</#macro>