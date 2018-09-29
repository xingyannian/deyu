package com.xingyannian.deyu.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by XINGYANNIAN on 2018/9/26.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserToken {
    private String access_token;
    private Integer expires_in;
    private String oprnid;
    private Integer errcode;
    private String errmsg;

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public Integer getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(Integer expires_in) {
        this.expires_in = expires_in;
    }

    public String getOprnid() {
        return oprnid;
    }

    public void setOprnid(String oprnid) {
        this.oprnid = oprnid;
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
