package com.iiisunny.ecommerce.feign.hystrix;

import com.alibaba.fastjson.JSON;
import com.iiisunny.ecommerce.common.TableId;
import com.iiisunny.ecommerce.feign.SecuredGoodsClient;
import com.iiisunny.ecommerce.goods.SimpleGoodsInfo;
import com.iiisunny.ecommerce.vo.CommonResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

/**
 * <h1>商品服务熔断降级兜底</h1>
 * */
@Component
public class GoodsClientHystrix implements SecuredGoodsClient {

    private static final Logger LOG = LoggerFactory.getLogger(GoodsClientHystrix.class);

    @Override
    public CommonResponse<List<SimpleGoodsInfo>> getSimpleGoodsInfoByTableId(
            TableId tableId) {

        LOG.error("[goods client feign request error in order service] get simple goods" +
                "error: [{}]", JSON.toJSONString(tableId));
        return new CommonResponse<>(
                -1,
                "[goods client feign request error in order service]",
                Collections.emptyList()
        );
    }
}
