package com.jd.springmvcbase.utils;

/**
 * 公共常量
 * Created by xuruhong on 2017/3/6.
 */
public interface CommonConstants {
    /** 公用状态： 是*/
    public final static int STATUS_YES = 1;
    /** 公用状态： 否*/
    public final static int STATUS_NO = 0;

    interface SessionKey {
        String LOGIN_USER = "loginUser";
        String SSO_COOKIE_NAME = "sso.imgc.jd.com";
        String SSO_COOKIE_DOMAIN = "imgc.jd.com";
    }
}
