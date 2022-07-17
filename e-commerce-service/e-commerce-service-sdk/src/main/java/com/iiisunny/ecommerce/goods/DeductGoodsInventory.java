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

    @ApiModelProperty(value = "是否有更多的商品（分页）")
    private Boolean hasMore;

    public DeductGoodsInventory() {
    }

    public DeductGoodsInventory(Long goodsId, Boolean hasMore) {
        this.goodsId = goodsId;
        this.hasMore = hasMore;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Boolean getHasMore() {
        return hasMore;
    }

    public void setHasMore(Boolean hasMore) {
        this.hasMore = hasMore;
    }
}
