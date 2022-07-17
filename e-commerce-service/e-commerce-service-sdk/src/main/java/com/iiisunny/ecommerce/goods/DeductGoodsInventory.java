package com.iiisunny.ecommerce.goods;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <h1>扣减商品库存</h1>
 */
@ApiModel(description = "扣减商品库存对象")
public class DeductGoodsInventory {

    @ApiModelProperty(value = "分页简单商品信息")
    private Long goodsId;

    @ApiModelProperty(value = "扣减个数")
    private Integer count;

    public DeductGoodsInventory() {
    }

    public DeductGoodsInventory(Long goodsId, Integer count) {
        this.goodsId = goodsId;
        this.count = count;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
