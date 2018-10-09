package com.xingyannian.deyu.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by XINGYANNIAN on 2018/9/26.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserToken {
    private String access_token;
    private String openid;
    private Integer errcode = 0;
    private String errmsg;

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public Integer getErrcode() {
        return errcode;
    }

    public void setErrcode(Integer errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }
}
