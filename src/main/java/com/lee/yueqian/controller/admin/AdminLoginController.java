package com.lee.yueqian.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@RequestMapping("/admin")
@Controller
public class AdminLoginController {

    @PostMapping("/userlogin")
    public String login(String username, String password, ModelMap modelMap, HttpSession httpSession){
        //防止空指针
        if("admin".equals(username) && "123".equals(password)){
            httpSession.setAttribute("username",username);
            return "redirect:/admin/main";
        }else {
            modelMap.addAttribute("msg","用户名或密码错误");
            return "/admin/login";
        }
    }

}
