package com.iiisunny.ecommerce.feign;

import com.iiisunny.ecommerce.account.AddressInfo;
import com.iiisunny.ecommerce.common.TableId;
import com.iiisunny.ecommerce.feign.hystrix.AddressClientHystrix;
import com.iiisunny.ecommerce.vo.CommonResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * <h1>用户账户服务 Feign 接口(安全的)</h1>
 * */
@FeignClient(
        contextId = "AddressClient",
        value = "e-commerce-account-service",
        fallback = AddressClientHystrix.class
)
public interface AddressClient {

    /**
     * <h2>根据 id 查询地址信息</h2>
     * */
    @RequestMapping(
            value = "/ecommerce-account-service/address/address-info-by-table-id",
            method = RequestMethod.POST
    )
    CommonResponse<AddressInfo> getAddressInfoByTablesId(@RequestBody TableId tableId);
}
