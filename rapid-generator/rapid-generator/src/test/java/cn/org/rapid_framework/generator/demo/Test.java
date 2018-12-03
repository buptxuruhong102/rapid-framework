package cn.org.rapid_framework.generator.demo;

import cn.org.rapid_framework.generator.Generator;
import cn.org.rapid_framework.generator.GeneratorFacade;
import cn.org.rapid_framework.generator.GeneratorProperties;
import cn.org.rapid_framework.generator.provider.db.table.TableFactory;
import cn.org.rapid_framework.generator.provider.db.table.model.Table;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuruhong on 2018/11/29.
 */
public class Test {
    public static void main(String[] args) throws Exception {
        String[] tables = new String[]{"userinfo","employee"};
        List<String> menuNames = new ArrayList<String>();


        GeneratorFacade g = new GeneratorFacade();
        URL url = Main.class.getClassLoader().getResource("template2");
        g.getGenerator().addTemplateRootDir(url.getFile());
        g.deleteOutRootDir();

        for(String tableName: tables){
            Table table = TableFactory.getInstance().getTable(tableName);
            Generator.GeneratorModel m = GeneratorFacade.GeneratorModelUtils.newGeneratorModel("table", table);

            menuNames.add(table.getClassNameLowerCase());
            m.templateModel.put("menuNames", menuNames);

            g.getGenerator().generateBy(m.templateModel, m.filePathModel);
        }


        Runtime.getRuntime().exec("cmd.exe /c start "+ GeneratorProperties.getRequiredProperty("outRoot"));
    }
}
