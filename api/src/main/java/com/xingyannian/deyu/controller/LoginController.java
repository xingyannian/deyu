package com.xingyannian.deyu.controller;

import com.xingyannian.deyu.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Created by XINGYANNIAN on 2018/9/21.
 */
@Controller
@RequestMapping("")
public class LoginController {
    @Autowired
    private LoginService loginService;
    @RequestMapping("/login")
    public String login(){
        return "redirect:https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx1043e0e52faa7e3c&redirect_uri=http%3a%2f%2fweixin.10000bat.com&response_type=code&scope=snsapi_base#wechat_redirect";
    }
    @GetMapping("/")
    public String startSession(String code, Model model, HttpSession session){
        if(code == null){
            return "forward:/login";
        }else {
            //将openid存入session
            String openid =  loginService.getOpenid(code);
            session.setAttribute("openid",openid);
            model.addAttribute("openid",openid);
            return "index";
        }
    }

}
