package com.iiisunny.ecommerce.service;

import com.alibaba.fastjson.JSON;
import com.iiisunny.ecommerce.account.BalanceInfo;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <h1>用于余额相关服务测试</h1>
 * */
public class BalanceServiceTest extends BaseTest {

    private static final Logger LOG = LoggerFactory.getLogger(BalanceServiceTest.class);

    @Autowired
    private IBalanceService balanceService;

    /**
     * <h2>测试获取当前用户的余额信息</h2>
     * */
    @Test
    public void testGetCurrentUserBalanceInfo() {

        LOG.info("test get current user balance info: [{}]", JSON.toJSONString(
                balanceService.getCurrentUserBalanceInfo()
        ));
    }

    /**
     * <h2>测试扣减用于余额</h2>
     * */
    @Test
    public void testDeductBalance() {

        BalanceInfo balanceInfo = new BalanceInfo();
        balanceInfo.setUserId(loginUserInfo.getId());
        balanceInfo.setBalance(1000L);

        LOG.info("test deduct balance: [{}]", JSON.toJSONString(
                balanceService.deductBalance(balanceInfo)
        ));
    }
}
