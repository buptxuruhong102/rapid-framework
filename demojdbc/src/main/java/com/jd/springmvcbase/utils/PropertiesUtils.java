/*
 * @(#)PropertiesUtils.java
 *
 * CopyRight (c) 2015 北京亚信智慧数据科技有限公司 保留所有权利。
 */

package com.jd.springmvcbase.utils;

import org.apache.commons.lang3.StringUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;



public class PropertiesUtils {
    
    private static Map<String, Map<String, String>> props = new HashMap<String, Map<String, String>>();
    
    private static Map<String,String> fileNames = new LinkedHashMap<String,String>();
    
    private static String provinceCity = null;
    
    private static Map<String,String> provinceFileNames = new LinkedHashMap<String,String>();

    /**
     * Description: 加载properties文件内容到缓存
     *
     * @param path 路径
     * @param key 保存后的key
     */
    public static void load(String path,String key) throws IOException{
    	
        Resource resource = new ClassPathResource(path);
		try {
			Properties prop = PropertiesLoaderUtils.loadProperties(resource);
			Map<String, String> map = new HashMap<String, String>();
			for (Object p : prop.keySet()) {
				String pk = p.toString();
				map.put(pk, prop.getProperty(pk));
			}
			props.put(key, map);
			fileNames.put(key, path);
		} catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }
    
    /**
     * Description: 获取POC的properties配置项,根据文件名获取，方便扩展
     *
     * @param key
     * @param fileName
     * @return
     * @throws Exception
     */
    public static String getProperties(String key,String fileName) throws Exception{
        Map<String, String> prop = props.get(fileName);
        if(prop == null){
        	if(!fileNames.isEmpty()) {
        		if (StringUtils.isEmpty(fileNames.get(fileName))) {
        			throw new Exception("never load properties file: "
        					+ fileName + ",place need the file is exist!");
        		}
        	}
            load(fileNames.get(fileName),fileName);
        }
        String value = props.get(fileName).get(key);
        if(StringUtils.isEmpty(value)){
            throw new Exception("not find properties["
                    + key + "] in file:"+fileNames.get(fileName));
        }
        return StringUtils.isEmpty(value)? "" :value.trim();
    }
    
  
    /**
     * Description: 其它的properties配置项,根据文件名获取，方便扩展
     *
     * @param key 获取的KEY
     * @param fileName 文件名
     * @param path 路径
     * @return
     * @throws Exception
     */
    public static String getProperties(String key,String fileName,String path) throws Exception{
        Map<String, String> prop = props.get(fileName);
        String file = path + fileName + ".properties";
        if(prop == null){
            load(file,fileName);
        }
        String value = props.get(fileName).get(key);
        if(StringUtils.isEmpty(value)){
            throw new Exception("not find properties["
                    + key + "] in file:" + file);
        }
        return StringUtils.isEmpty(value)? "" :value.trim();
    }
    
    /**
     * 从所有配置文件中获取配置项，按先读先获取的原则获取
     * @param key 配置项Key
     * @return 配置项值
     * @throws Exception
     */
    public static String getProperties(String key){
        String value = null;
        String key0 = key;
        if(isDebug()){
        	key0 = key0 + ".debug";
        }
        for (String fileKey : fileNames.keySet()) {
            Map<String, String> prop = props.get(fileKey);
            if (prop != null && ((value = prop.get(key0)) != null || (value = prop.get(key)) != null)) {
                break;
            }
        }
        return StringUtils.isEmpty(value)? "" :value.trim();
    }
    
    /**
     * 刷新配置文件的配置项
     * @param fileKey 需要刷新的配置项
     * @return
     * @throws Exception
     */
    public static boolean refreshProperties(String fileKey) throws Exception{
    	try {
			load(fileNames.get(fileKey),fileKey);
			return true;
		} catch (IOException e) {
			throw new Exception("refresh["+fileNames.get(fileKey)+"]properties file exception!",e);
		}
    }
    
    public static boolean isDebug(){
    	String key = "debug";
    	boolean isDbug = false;
    	try {
    		
    		for (String fileKey : fileNames.keySet()) {
                Map<String, String> prop = props.get(fileKey);
                if (prop != null &&  "true".equalsIgnoreCase(prop.get(key))) {
                	isDbug = true;
                    break;
                }
            }
    		
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return isDbug;
    }

}
