package com.iiisunny.ecommerce.vo;

/**
 * <h1>授权中心鉴权之后给客户端的 Token</h1>
 */
public class JwtToken {

    /** JWT */
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
