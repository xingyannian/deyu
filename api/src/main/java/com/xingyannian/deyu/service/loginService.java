package com.xingyannian.deyu.service;

import com.xingyannian.deyu.domain.WeChat;

/**
 * Created by XINGYANNIAN on 2018/9/25.
 */
public interface loginService {
    public WeChat getOpenid(String code);
}
