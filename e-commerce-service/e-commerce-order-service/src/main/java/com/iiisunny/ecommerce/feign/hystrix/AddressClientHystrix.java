package com.iiisunny.ecommerce.feign.hystrix;

import com.alibaba.fastjson.JSON;
import com.iiisunny.ecommerce.account.AddressInfo;
import com.iiisunny.ecommerce.common.TableId;
import com.iiisunny.ecommerce.feign.AddressClient;
import com.iiisunny.ecommerce.service.impl.OrderServiceImpl;
import com.iiisunny.ecommerce.vo.CommonResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Collections;

/**
 * <h1>账户服务熔断降级兜底策略</h1>
 * */
@Component
public class AddressClientHystrix implements AddressClient {

    private static final Logger LOG = LoggerFactory.getLogger(AddressClientHystrix.class);
    @Override
    public CommonResponse<AddressInfo> getAddressInfoByTablesId(TableId tableId) {

        LOG.error("[account client feign request error in order service] get address info" +
                "error: [{}]", JSON.toJSONString(tableId));
        return new CommonResponse<>(
                -1,
                "[account client feign request error in order service]",
                Collections.emptyList()
        );
    }
}
