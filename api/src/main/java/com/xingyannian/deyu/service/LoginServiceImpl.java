package com.xingyannian.deyu.service;

import com.xingyannian.deyu.config.WxMappingJackson2HttpMessageConverter;
import com.xingyannian.deyu.domain.WeChat;
import com.xingyannian.deyu.dto.UserToken;
import com.xingyannian.deyu.repository.WeChatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;


/**
 * Created by XINGYANNIAN on 2018/9/25.
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private WeChatRepository weChatRepository;
    @Override
    public String getOpenid(String code) {
        if(code == null){
            System.out.println("code为空");
            return null;
        }else {
            String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=wx1043e0e52faa7e3c&secret=b776bf9bb33abf17a35f39ee9642c041&code=" + code +"&grant_type=authorization_code";
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new WxMappingJackson2HttpMessageConverter());
            UserToken userToken = null;
            try {
                userToken = restTemplate.getForObject(url,UserToken.class);
            } catch (RestClientException e) {
                e.printStackTrace();
            }
            if(userToken.getErrcode() != 0){
                //如果失败。。。
                System.out.println(userToken.getErrcode() + userToken.getErrmsg());
                return null;
            }else {
                //获取成功
                System.out.println(userToken.getOpenid());
                return userToken.getOpenid();
            }
        }
    }
    @Override
    public WeChat getWeChat(String openid){
        if (openid == null){
            return null;
        }else {
            if(weChatRepository.existsByOpenId(openid)){
                return weChatRepository.findByOpenId(openid);
            }else {
                return null;
            }
        }
    }
}
