package com.iiisunny.ecommerce.service;

import com.iiisunny.ecommerce.common.TableId;
import com.iiisunny.ecommerce.goods.DeductGoodsInventory;
import com.iiisunny.ecommerce.goods.GoodsInfo;
import com.iiisunny.ecommerce.goods.SimpleGoodsInfo;
import com.iiisunny.ecommerce.vo.PageSimpleGoodsInfo;

import java.util.List;

/**
 * <h1>商品微服务相关服务接口定义</h1>
 * */
public interface IGoodsService {

    /**
     * <h2>根据 TableId 查询商品详细信息</h2>
     * */
    List<GoodsInfo> getGoodsInfoByTableId(TableId tableId);

    /**
     * <h2>获取分页的商品信息</h2>
     * */
    PageSimpleGoodsInfo getSimpleGoodsInfoByPage(int page);

    /**
     * <h2>根据 TableId 查询简单商品信息</h2>
     * */
    List<SimpleGoodsInfo> getSimpleGoodsInfoByTableId(TableId tableId);

    /**
     * <h2>扣减商品库存</h2>
     * */
    Boolean deductGoodsInventory(List<DeductGoodsInventory> deductGoodsInventories);
}
