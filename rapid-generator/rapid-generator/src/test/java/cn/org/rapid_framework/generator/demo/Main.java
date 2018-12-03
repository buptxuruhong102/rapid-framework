package cn.org.rapid_framework.generator.demo;

import cn.org.rapid_framework.generator.GeneratorFacade;
import cn.org.rapid_framework.generator.GeneratorProperties;

import java.net.URL;

/**
 * Created by xuruhong on 2017/5/21.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        URL url = Main.class.getClassLoader().getResource("template");

        GeneratorFacade g = new GeneratorFacade();
        g.getGenerator().addTemplateRootDir(url.getFile());
        g.deleteOutRootDir();
        g.generateByTable("user_info");
        //删除生成的文件
        Runtime.getRuntime().exec("cmd.exe /c start "+ GeneratorProperties.getRequiredProperty("outRoot"));
    }
}
