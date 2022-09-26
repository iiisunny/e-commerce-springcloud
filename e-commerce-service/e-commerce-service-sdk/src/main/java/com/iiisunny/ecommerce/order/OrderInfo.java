package com.iiisunny.ecommerce.order;

import com.iiisunny.ecommerce.goods.DeductGoodsInventory;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel(description = "用户发起购买订单")
public class OrderInfo {

    @ApiModelProperty(value = "用户地址表主键 id")
    private Long userAddress;

    @ApiModelProperty(value = "订单中的商品信息")
    private List<OrderItem> orderItems;

    @ApiModel(description = "订单中的单向商品信息")
    public static class OrderItem{

        @ApiModelProperty(value = "商品表主键 id")
        private Long goodsId;

        @ApiModelProperty(value = "购买商品个数")
        private Integer count;

        public DeductGoodsInventory toDeductGoodsInventory(){
            return new DeductGoodsInventory(this.goodsId, this.count);
        }

        public OrderItem(Long goodsId, Integer count) {
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

    public OrderInfo(Long userAddress, List<OrderItem> orderItems) {
        this.userAddress = userAddress;
        this.orderItems = orderItems;
    }

    public Long getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(Long userAddress) {
        this.userAddress = userAddress;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }
}
