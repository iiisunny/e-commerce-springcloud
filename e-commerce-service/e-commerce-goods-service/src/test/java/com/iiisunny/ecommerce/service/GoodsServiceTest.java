package com.iiisunny.ecommerce.service;

import com.alibaba.fastjson.JSON;
import com.iiisunny.ecommerce.common.TableId;
import com.iiisunny.ecommerce.goods.DeductGoodsInventory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <h1>商品微服务功能测试</h1>
 * */
@SpringBootTest
@RunWith(SpringRunner.class)
public class GoodsServiceTest {

    private static final Logger LOG = LoggerFactory.getLogger(GoodsServiceTest.class);

    @Autowired
    private IGoodsService goodsService;

    @Test
    public void testGetGoodsInfoByTableId() {

        List<Long> ids = Arrays.asList(1L, 2L, 3L);
        List<TableId.Id> tIds = ids.stream()
                .map(TableId.Id::new).collect(Collectors.toList());
        LOG.info("test get goods info by table id: [{}]",
                JSON.toJSONString(goodsService.getGoodsInfoByTableId(new TableId(tIds))));
    }

    @Test
    public void testGetSimpleGoodsInfoByPage() {

        LOG.info("test get simple goods info by page: [{}]", JSON.toJSONString(
                goodsService.getSimpleGoodsInfoByPage(1)
        ));
    }

    @Test
    public void testGetSimpleGoodsInfoByTableId() {

        List<Long> ids = Arrays.asList(1L, 2L, 3L);
        List<TableId.Id> tIds = ids.stream()
                .map(TableId.Id::new).collect(Collectors.toList());
        LOG.info("test get simple goods info by table id: [{}]", JSON.toJSONString(
                goodsService.getSimpleGoodsInfoByTableId(new TableId(tIds))
        ));
    }

    @Test
    public void testDeductGoodsInventory() {

        List<DeductGoodsInventory> deductGoodsInventories = Arrays.asList(
                new DeductGoodsInventory(1L, 100),
                new DeductGoodsInventory(2L, 66)
        );
        LOG.info("test deduct goods inventory: [{}]",
                goodsService.deductGoodsInventory(deductGoodsInventories));
    }
}
