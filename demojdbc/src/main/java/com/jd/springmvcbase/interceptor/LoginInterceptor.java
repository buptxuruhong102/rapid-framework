package com.jd.springmvcbase.interceptor;

import com.jd.springmvcbase.model.UserInfo;
import com.jd.springmvcbase.utils.CommonConstants;
import com.jd.springmvcbase.utils.DESUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by chenguoyou on 2017/3/6.
 */
public class LoginInterceptor implements HandlerInterceptor {
    private final static Logger log = Logger.getLogger(LoginInterceptor.class);
    //@Autowired
   // private IUserInfoService userInfoService;

    @SuppressWarnings("unused")
    private String excludePath;

    private List<String> excludePathCache;

    private int cacheTimeout = 1800;
    private Map<String, UserInfo> cache = new ConcurrentHashMap<>();

    /**
     * Description: 设置排除路径
     * 通过spring 属性设置 注入进来
     * @param excludePath
     */
    public void setExcludePath(String excludePath) {
        this.excludePath = excludePath;
        if (StringUtils.isNotBlank(excludePath)) {
            excludePathCache = new ArrayList<String>();
            String[] path = excludePath.split(",");
            for (String p : path) {
                excludePathCache.add(p.trim());
            }
        }
    }

    /**
     * Description: 判断是否包含排除的路径
     *
     * @param uri
     * @return
     */
    public boolean isExclude(String uri) {
        if (excludePathCache == null || excludePathCache.isEmpty()) {
            return false;
        }
        for (String path : this.excludePathCache) {
            if (uri.startsWith(path)) {
                return true;
            }
        }
        return false;
    }

    public boolean isExclude(HttpServletRequest request) {
        return this.isExclude(request.getRequestURI());
    }

    /**
     * {@inheritDoc}
     * @see org.springframework.web.servlet.HandlerInterceptor#preHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object)
     */
    @Override
    public boolean preHandle(HttpServletRequest request,HttpServletResponse response, Object handler) throws Exception {

            if (isExclude(request)) {
                return true;
            }else{
                try {
                    HttpSession session =  request.getSession();
                    if(session == null){
                        return false;
                    }
                    UserInfo user = (UserInfo) session.getAttribute(CommonConstants.SessionKey.LOGIN_USER);
                    if(user == null){
                        String userNameDes = this.getCookieValue(request, CommonConstants.SessionKey.SSO_COOKIE_NAME);
                        String userName = DESUtil.decryptStr(userNameDes);
                        if(StringUtils.isNotEmpty(userName)){
                            //单点登录
                            UserInfo userInfo = this.getUserInfoFromCache(userName);
                            if(userInfo == null){
                                //userInfo = userInfoService.findByName(userName);
                                if(userInfo == null){
                                    //防攻击,通过cookie输入不存在用户名
                                    return false;
                                }
                                this.saveUserInfoToCache(userName,userInfo);
                            }
                            session.setAttribute(CommonConstants.SessionKey.LOGIN_USER, userInfo);
                            return true;
                        }else{
                            request.getSession().setAttribute("msg", "请先登录");

                            //重定向到登录
                            String loginUrl = session.getServletContext().getContextPath()+"/login";
                            HttpServletResponse resp = (HttpServletResponse) response;
                            //如果是 AJAX 请求
                            if (request.getHeader("x-requested-with") != null
                                    && request.getHeader("x-requested-with").equals("XMLHttpRequest")) {
                                resp.setStatus(401);
                                resp.setHeader("Location", loginUrl);
                            }else {
                                resp.sendRedirect(loginUrl);
                            }
                            return false;
                        }
                    }
                } catch (Exception e) {
                    log.error(e);
                    e.printStackTrace();
                }
            }


        return true;
    }

    /**
     * {@inheritDoc}
     * @see org.springframework.web.servlet.HandlerInterceptor#postHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, org.springframework.web.servlet.ModelAndView)
     */
    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {

    }

    /**
     * {@inheritDoc}
     * @see org.springframework.web.servlet.HandlerInterceptor#afterCompletion(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, java.lang.Exception)
     */
    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler, Exception ex)
            throws Exception {

    }

    public String getCookieValue(HttpServletRequest servletRequest, String name) {
        Cookie[] cookies = servletRequest.getCookies();
        if(cookies != null && cookies.length > 0) {
            Cookie[] arr$ = cookies;
            int len$ = cookies.length;

            for(int i$ = 0; i$ < len$; ++i$) {
                Cookie cookie = arr$[i$];
                String cookieName = cookie.getName();
                if(cookieName.equals(name)) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }

    private void saveUserInfoToCache(String ticket, UserInfo userInfo) {
        if(this.cache != null && ticket != null && userInfo != null) {
            long expire = System.currentTimeMillis() + (long)(this.cacheTimeout * 1000);
            userInfo.setExpire(expire);
            this.cache.put(ticket, userInfo);
        }
    }

    private UserInfo getUserInfoFromCache(String ticket) {
        if(this.cache == null) {
            return null;
        } else {
            UserInfo user = (UserInfo)this.cache.get(ticket);
            if(user != null && System.currentTimeMillis() > user.getExpire()) {
                this.cache.remove(ticket);
                return null;
            } else {
                return user;
            }
        }
    }

}
