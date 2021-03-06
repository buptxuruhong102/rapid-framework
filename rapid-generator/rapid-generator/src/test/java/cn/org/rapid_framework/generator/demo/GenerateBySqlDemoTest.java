package cn.org.rapid_framework.generator.demo;

import cn.org.rapid_framework.generator.GeneratorFacade;
import cn.org.rapid_framework.generator.GeneratorTestCase;
import cn.org.rapid_framework.generator.provider.db.sql.SqlFactory;
import cn.org.rapid_framework.generator.provider.db.sql.model.Sql;

import java.net.URL;

public class GenerateBySqlDemoTest extends GeneratorTestCase{
	GeneratorFacade generatorFacade = new GeneratorFacade();
	public void setUp() throws Exception {
		super.setUp();
		g.setOutRootDir("target/temp/"+getClass().getSimpleName()+"/"+getName());
		generatorFacade.setGenerator(g);
	}
	
	public void test_generate_by_sql() throws Exception {
		URL url = this.getClass().getClassLoader().getResource("for_test_select_sql");
		System.out.println("=============" + url);

		generatorFacade.getGenerator().addTemplateRootDir(url.getFile());
		Sql sql = new SqlFactory().parseSql("select * from user_info where username=#username# and password=#password#");
		sql.setMultiplicity("many");  //many or one
		sql.setOperation("findByUsernameAndPassword");
		sql.setRemarks("根据用户名及密码进行查询");
		generatorFacade.generateBySql(sql);
		
	}
	
}
