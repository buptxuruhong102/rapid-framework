package com.jd.springmvcbase.controller;

import com.jd.springmvcbase.model.UserInfo;
import com.jd.springmvcbase.utils.CommonConstants;
import com.jd.springmvcbase.utils.VerifyCodeUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by xuruhong on 2017/3/24.
 */
@Controller
@RequestMapping("")
public class LoginController {
    private static Logger log = LoggerFactory.getLogger(LoginController.class);
//    @Autowired
//    private IUserInfoService userInfoService;

    @RequestMapping("/login")
    public String login(){
        return "/login";
    }

    @RequestMapping("/index")
    public String index(){
        return "/index";
    }

    @RequestMapping("/login/validate")
    public void login(String user, String pass, String code, HttpServletRequest request, HttpServletResponse response) {
        String loginUrl = request.getContextPath() + "/login";
        try {
            HttpSession session = request.getSession();
//
//            String jimDBKey = getJimDBKey(request);
//            String verifycode = JimDBClientFactory.getInstence().getJimClient().get(jimDBKey);
//            log.debug(jimDBKey + "=" + verifycode);
//            if(verifycode == null || !verifycode.equalsIgnoreCase(code)){
//                session.setAttribute("msg", "验证码错误!");
//                response.sendRedirect(loginUrl);
//                return;
//            }
//
//            UserInfo userInfo = userInfoService.findByName(user);
//            if(userInfo == null){
//                session.setAttribute("msg", "用户名不存在!");
//                response.sendRedirect(loginUrl);
//                return;
//            }
//
//            String pwd = DigestUtils.md5DigestAsHex(pass.getBytes());
//            if (!pwd.equals(userInfo.getPwd())){
//                session.setAttribute("msg", "密码错误!");
//                response.sendRedirect(loginUrl);
//                return;
//            }
//
//            Cookie cookie = new Cookie(CommonConstants.SessionKey.SSO_COOKIE_NAME, DESUtil.encryptStr(user));
//            cookie.setDomain(CommonConstants.SessionKey.SSO_COOKIE_DOMAIN);
//            cookie.setPath("/");
//            response.addCookie(cookie);

            session.setAttribute(CommonConstants.SessionKey.LOGIN_USER, new UserInfo());
            response.sendRedirect(request.getContextPath() + "/index");
        } catch (IOException e) {
            log.error("登录失败",e);
        }
    }

    @RequestMapping("/logout")
    public void logout(HttpServletRequest request, HttpServletResponse response) {
        try {
            HttpSession session = request.getSession();
            session.removeAttribute("msg");
            session.removeAttribute(CommonConstants.SessionKey.LOGIN_USER);

            Cookie cookie = new Cookie(CommonConstants.SessionKey.SSO_COOKIE_NAME, null);
            cookie.setDomain(CommonConstants.SessionKey.SSO_COOKIE_DOMAIN);
            cookie.setPath("/");
            response.addCookie(cookie);

            response.sendRedirect(request.getContextPath() + "/login");
        } catch (IOException e) {
            log.error("退出异常",e);
        }
    }

    @RequestMapping("/login/authImage")
    public void authImage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");

        //生成随机字串
        String verifyCode = VerifyCodeUtils.generateVerifyCode(4);
        //存入jimdb
//        String jimDBKey = getJimDBKey(request);
//        JimDBClientFactory.getInstence().getJimClient().set(jimDBKey, verifyCode.toLowerCase());
//        JimDBClientFactory.getInstence().getJimClient().expire(jimDBKey, 60, TimeUnit.SECONDS);
        //生成图片
        int w = 100, h = 30;
        VerifyCodeUtils.outputImage(w, h, response.getOutputStream(), verifyCode);
    }

    private String getJimDBKey(javax.servlet.http.HttpServletRequest request){
        String clientIp = getIpAddr(request);
        return "imgc.jd.com_" + clientIp;
    }

    public static String getIpAddr(javax.servlet.http.HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        String[] ips = null;
        if(StringUtils.isNotEmpty(ip)){
            ips = ip.split(",");
            return ips[0];
        }
        return ip;
    }

}
