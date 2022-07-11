package com.iiisunny.ecommerce.filter;

import com.iiisunny.ecommerce.vo.LoginUserInfo;

/**
 * <h1>使用 TreadLocal 去单独皴每一个线程携带的 LoginUserInfo 信息</h1>
 * 要及时清理保存到的 ThreadLocl 中的用户信息
 * 1. 保证没有资源泄漏
 * 2. 保证线程在重用时，不会出现线程混乱
 */
public class AccessContext {

    private static final ThreadLocal<LoginUserInfo> loginUserInfo = new ThreadLocal<>();

    public static LoginUserInfo getLoginUserInfo() {
        return loginUserInfo.get();
    }

    public static void setLoginUserInfo(LoginUserInfo loginUserInfo_) {
        loginUserInfo.set(loginUserInfo_);
    }

    public static void clearLoginUserInfo() {
        loginUserInfo.remove();
    }

}
