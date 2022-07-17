package com.iiisunny.ecommerce.vo;

import com.iiisunny.ecommerce.goods.SimpleGoodsInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

/**
 * <h1>分页商品信息</h1>
 * */
@ApiModel(description = "分页商品信息对象")
public class PageSimpleGoodsInfo {

    @ApiModelProperty(value = "分页简单商品信息")
    private List<SimpleGoodsInfo> simpleGoodsInfos;

    @ApiModelProperty(value = "是否有更多的商品(分页)")
    private Boolean hasMore;

    public PageSimpleGoodsInfo() {
    }

    public PageSimpleGoodsInfo(List<SimpleGoodsInfo> simpleGoodsInfos, Boolean hasMore) {
        this.simpleGoodsInfos = simpleGoodsInfos;
        this.hasMore = hasMore;
    }

    public List<SimpleGoodsInfo> getSimpleGoodsInfos() {

        return simpleGoodsInfos;
    }

    public void setSimpleGoodsInfos(List<SimpleGoodsInfo> simpleGoodsInfos) {
        this.simpleGoodsInfos = simpleGoodsInfos;
    }

    public Boolean getHasMore() {
        return hasMore;
    }

    public void setHasMore(Boolean hasMore) {
        this.hasMore = hasMore;
    }
}
