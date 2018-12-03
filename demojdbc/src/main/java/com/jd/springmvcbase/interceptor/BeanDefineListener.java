package com.jd.springmvcbase.interceptor;

import com.jd.springmvcbase.utils.PropertiesUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * 启动后执行
 * Created by xuruhong on 2017/3/13.
 */
@Component
public class BeanDefineListener implements ApplicationListener<ContextRefreshedEvent> {
    private static Logger log = LoggerFactory.getLogger(BeanDefineListener.class);

    private static final String PROPERTIES_PATH = "/config/application.properties";
    private static final String PROPERTIES_MODEL = "imagecollect";

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if(event.getApplicationContext().getParent() == null){
            //需要执行的逻辑代码，当spring容器初始化完成后就会执行该方法。
            try {
                PropertiesUtils.load(PROPERTIES_PATH, PROPERTIES_MODEL);
            } catch (IOException e) {
                log.error("加载配置文件失败", e);
            }
        }
    }
}
