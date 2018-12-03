package com.jd.springmvcbase.utils;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

/**
 * Created by xuruhong on 2017/4/4.
 */
public class CommonUtils {
    /**
     * 获取任务编号
     * @return
     */
    public synchronized static String getTaskNum(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String dateStr = sdf.format(new Date());

        String taskNum = dateStr;
        return taskNum;
    }

    /**
     * 获取本机IP
     * @return
     */
    public static String getLocalIP() {
        try {
            Enumeration e = NetworkInterface.getNetworkInterfaces();

            while(e.hasMoreElements()) {
                NetworkInterface networkInterface = (NetworkInterface)e.nextElement();
                Enumeration inetAddresses = networkInterface.getInetAddresses();

                while(inetAddresses.hasMoreElements()) {
                    InetAddress inetAddress = (InetAddress)inetAddresses.nextElement();
                    if(inetAddress instanceof Inet4Address && !inetAddress.isLoopbackAddress()) {
                        return inetAddress.getHostAddress();
                    }
                }
            }
        } catch (Exception var6) {
            ;
        }

        try {
            return InetAddress.getByName((String)null).getHostAddress();
        } catch (Exception var5) {
            return "127.0.0.1";
        }
    }
    
    public static String getPicDns(){
    	
    	try {
    		String dbs = PropertiesUtils.getProperties("PIC_DNS");
			String bus = PropertiesUtils.getProperties("BUSINESS_NAME");
			return dbs + bus;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	return null;
    }
}
