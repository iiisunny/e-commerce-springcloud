package com.iiisunny.ecommerce.vo;

import com.iiisunny.ecommerce.account.UserAddress;
import com.iiisunny.ecommerce.goods.SimpleGoodsInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * <h1>订单详情</h1>
 * */
@ApiModel(description = "分页订单详情对象")
public class PageSimpleOrderDetail {

    @ApiModelProperty(value = "订单详情")
    private List<SingleOrderItem> orderItems;

    @ApiModelProperty(value = "是否有更多的订单(分页)")
    private Boolean hasMore;

    /**
     * <h2>单个订单信息</h2>
     * */
    @ApiModel(description = "单个订单信息对象")
    public static class SingleOrderItem {

        @ApiModelProperty(value = "订单表主键 id")
        private Long id;

        @ApiModelProperty(value = "用户地址信息")
        private UserAddress userAddress;

        @ApiModelProperty(value = "订单商品信息")
        private List<SingleOrderGoodsItem> goodsItems;

        public SingleOrderItem() {
        }

        public SingleOrderItem(Long id, UserAddress userAddress, List<SingleOrderGoodsItem> goodsItems) {
            this.id = id;
            this.userAddress = userAddress;
            this.goodsItems = goodsItems;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public UserAddress getUserAddress() {
            return userAddress;
        }

        public void setUserAddress(UserAddress userAddress) {
            this.userAddress = userAddress;
        }

        public List<SingleOrderGoodsItem> getGoodsItems() {
            return goodsItems;
        }

        public void setGoodsItems(List<SingleOrderGoodsItem> goodsItems) {
            this.goodsItems = goodsItems;
        }
    }

    @ApiModel(description = "单个订单中的单项商品信息")
    public static class SingleOrderGoodsItem {

        @ApiModelProperty(value = "简单商品信息")
        private SimpleGoodsInfo simpleGoodsInfo;

        @ApiModelProperty(value = "商品个数")
        private Integer count;

        public SingleOrderGoodsItem() {
        }

        public SingleOrderGoodsItem(SimpleGoodsInfo simpleGoodsInfo, Integer count) {
            this.simpleGoodsInfo = simpleGoodsInfo;
            this.count = count;
        }

        public SimpleGoodsInfo getSimpleGoodsInfo() {
            return simpleGoodsInfo;
        }

        public void setSimpleGoodsInfo(SimpleGoodsInfo simpleGoodsInfo) {
            this.simpleGoodsInfo = simpleGoodsInfo;
        }

        public Integer getCount() {
            return count;
        }

        public void setCount(Integer count) {
            this.count = count;
        }
    }

    public PageSimpleOrderDetail(List<SingleOrderItem> orderItems, Boolean hasMore) {
        this.orderItems = orderItems;
        this.hasMore = hasMore;
    }

    public List<SingleOrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<SingleOrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public Boolean getHasMore() {
        return hasMore;
    }

    public void setHasMore(Boolean hasMore) {
        this.hasMore = hasMore;
    }
}
