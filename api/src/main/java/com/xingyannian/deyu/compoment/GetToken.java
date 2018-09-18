package com.xingyannian.deyu.compoment;

/**
 * Created by XINGYANNIAN on 2018/9/14.
 */

import com.xingyannian.deyu.domain.Token;
import com.xingyannian.deyu.dto.AccessToken;
import com.xingyannian.deyu.repository.TokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


/**
 * Created by XINGYANNIAN on 2018/9/7.
 */
@Component
public class GetToken {
    @Autowired
    private TokenRepository tokenRepository;
    private String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential";
    //获取此应用token的网址
    private String tokenUrl = url + "&appid=wx1043e0e52faa7e3c&secret=b776bf9bb33abf17a35f39ee9642c041";
    //获取通讯路的token网址


    private void getAccessToken(String url,Long id) {
        RestTemplate restTemplate = new RestTemplate();
        AccessToken accessToken = restTemplate.getForObject(url,AccessToken.class);
        if (accessToken.getErrcode() == null){
            //获取token成功
            //System.out.println(accessToken.getAccess_token());
            //保存id=1的记录为app_id
            if(!tokenRepository.existsById(id)){
                Token token = new Token();
                token.setAccess_token(accessToken.getAccess_token());
                token.setExpires_in(accessToken.getExpires_in());
                try {
                    tokenRepository.save(token);
                    System.out.println("access token" + id + "保存成功！");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }else {
                try {
                    Token token = tokenRepository.findById(id).get();
                    token.setAccess_token(accessToken.getAccess_token());
                    System.out.println("access token"+ id +"更新成功！");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            //打印成功消息
        }else {
            //获取token失败
            System.out.println(accessToken.getErrmsg());
        }
    }
    //获取自定义应用的access——token,并保存到数据库
    @Scheduled(fixedDelay = 6200000)//定时每7200秒自动执行
    public void getAppAccessToken(){
        this.getAccessToken(tokenUrl,1L);
    }


}
