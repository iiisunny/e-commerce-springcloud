package com.iiisunny.ecommerce.order;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <h1>创建订单时发送的物流消息</h1>
 */
@ApiModel(description = "Stream 物流消息对象")
public class LogisticsMessage {

    @ApiModelProperty(value = "用户表主键 id")
    private Long userId;

    @ApiModelProperty(value = "订单表主键 id")
    private Long orderId;

    @ApiModelProperty(value = "用户地址表主键 id")
    private Long addressId;

    @ApiModelProperty(value = "备注信息（json 存储)")
    private String extraInfo;

    public LogisticsMessage(Long userId, Long orderId, Long addressId, String extraInfo) {
        this.userId = userId;
        this.orderId = orderId;
        this.addressId = addressId;
        this.extraInfo = extraInfo;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long uesrId) {
        this.userId = uesrId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public String getExtraInfo() {
        return extraInfo;
    }

    public void setExtraInfo(String extraInfo) {
        this.extraInfo = extraInfo;
    }
}
