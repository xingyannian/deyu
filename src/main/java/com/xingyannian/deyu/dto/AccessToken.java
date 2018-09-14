package com.xingyannian.deyu.dto;

/**
 * Created by XINGYANNIAN on 2018/9/14.
 */
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by XINGYANNIAN on 2018/6/19.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AccessToken {
    private Integer errcode;
    private String errmsg;
    private String access_token;
    private Integer expires_in;

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

    @Override
    public String toString() {
        return "AccessToken{" +
                "errcode=" + errcode +
                ", errmsg=" + errmsg +
                ", access_token='" + access_token + '\'' +
                ", expires_in=" + expires_in +
                '}';
    }
}
