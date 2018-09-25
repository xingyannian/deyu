package com.xingyannian.deyu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by XINGYANNIAN on 2018/9/21.
 */
@Controller
@RequestMapping("")
public class loginController {
    @RequestMapping("/login")
    public String login(){
        return "redirect:https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx1043e0e52faa7e3c&redirect_uri=http%3a%2f%2fweixin.10000bat.com&response_type=code&scope=snsapi_base#wechat_redirect";
    }
    @GetMapping("/")
    public String getCode(String code){
        if(code == null){
            return "forward:/login";
        }else {

            return "redirect:https://api.weixin.qq.com/sns/oauth2/access_token?appid=wx1043e0e52faa7e3c&secret=b776bf9bb33abf17a35f39ee9642c041&code=" + code +"&grant_type=authorization_code";
        }
    }
    public void getOpenid(){

    }
}
