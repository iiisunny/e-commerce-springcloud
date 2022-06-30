package com.iiisunny.ecommerce.vo;

/**
 * <h1>登录用户信息</h1>
 */
public class LoginUserInfo {

    /** 用户 id */
    private Long id;

    /** 用户名 */
    private String username;

    public LoginUserInfo(Long id, String username) {
        this.id = id;
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
