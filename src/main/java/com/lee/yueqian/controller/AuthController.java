package com.lee.yueqian.controller;

import com.lee.yueqian.dao.impl.UsersDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 处理用户注册、登录、注销请求
 */

@Controller
public class AuthController {

    @Autowired
    UsersDaoImpl usersDaoImpl;

    /**
     * 后端校验用户名是否已被使用,
     * 返回给ajax是false则用户名已被使用(不可用)，true则用户名可用
     */
    @ResponseBody
    @RequestMapping("/check_username")
    public String check_username(String username) {
        //查询数据库是否已有用户名记录
        boolean isUsed = usersDaoImpl.isUsed(username);
        //若已被使用,返回false给ajax请求标记用户名已被使用，并显示在页面上
        if (isUsed) {
            return "false";
        } else
            return "true";
    }

    /**
     * 注册操作
     */
    @PostMapping(value = {"/register", "/register.html"})
    public String register(@RequestParam("username") String username,
                           @RequestParam("password") String password,
                           HttpServletRequest httpServletRequest, //用于获取用户输入的验证码
                           ModelMap modelMap) {
        //获取以上方法生成的验证码
        String captchaId = (String) httpServletRequest.getSession().getAttribute("vrifyCode");
        System.out.println("输入的验证码是：" + captchaId);
        //获取用户输入的name="vrifyCode"的文本验证码
        String parameter = httpServletRequest.getParameter("vrifyCode");
        //检查验证码是否匹配
        if (!captchaId.equals(parameter)) {
            modelMap.addAttribute("msg", "验证码错误");
            return "register";
        } else { //验证码正确
            //把用户名密码保存数据库
            usersDaoImpl.saveUser(username, password);
            //注册成功重定向登录页
            return "redirect:/login";
        }
    }


    /**
     * 登录操作
     * 不能直接用where password = ? 查询是否有记录来判断密码是否正确
     * 因为会有数据库注入漏洞(防止万能密码)
     * 应该根据用户名到数据库查询返回密码在java代码中匹配
     */
    @PostMapping("/user/login")
    public String userLogin(@RequestParam("username") String username,
                            @RequestParam("password") String password,
                            HttpSession httpSession,
                            ModelMap modelMap) {

        //验证密码
        String real_password = usersDaoImpl.getPassword(username);
        //若数据库无此用户名
        if (real_password == null) {
            System.out.println("用户不存在");
            //带用户不存在msg返回登录页
            modelMap.addAttribute("msg", "用户不存在");
            return "login";
        }
        //若密码正确,重定向到主页
        if (real_password.equals(password)) {
            System.out.println("登录成功");
            //session保存登录状态
            httpSession.setAttribute("username", username);
            return "redirect:/index";
        } else { //若密码不正确,带密码错误msg返回登录页
            System.out.println("用户名或密码错误");
            modelMap.addAttribute("msg", "用户名或密码错误");
            return "login";
        }
    }


    /**
     * 注销操作
     */
    @RequestMapping("/signout")
    public String signout(HttpSession httpSession) {
        //清除session所有内容
        httpSession.invalidate();
        return "redirect:/index.html";
    }


}
