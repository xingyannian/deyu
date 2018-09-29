package com.xingyannian.deyu.service;

import com.xingyannian.deyu.domain.WeChat;
import com.xingyannian.deyu.dto.UserToken;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Logger;

/**
 * Created by XINGYANNIAN on 2018/9/25.
 */
@Service
public class loginServiceImpl implements loginService {
    private final static Logger logger = (Logger) LoggerFactory.getLogger(loginServiceImpl.class);

    @Override
    public WeChat getOpenid(String code) {
        if(code == null){
            logger.info("code为空值");
        }else {
            String url = "redirect:https://api.weixin.qq.com/sns/oauth2/access_token?appid=wx1043e0e52faa7e3c&secret=b776bf9bb33abf17a35f39ee9642c041&code=" + code +"&grant_type=authorization_code";
            RestTemplate restTemplate = new RestTemplate();
            UserToken userToken = restTemplate.getForObject(url,UserToken.class);
            if(userToken.getErrcode() == 40029){
                logger.info(userToken.getErrmsg());
            }else {

            }
        }
        return null;
    }
}
