package com.iiisunny.ecommerce.account;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.List;

/**
 * <h1>用户地址信息</h1>
 * */
@ApiModel(description = "用户地址信息")
public class AddressInfo {

    @ApiModelProperty(value = "地址所属用户 id")
    private Long userId;

    @ApiModelProperty(value = "地址详细信息")
    private List<AddressItem> addressItems;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<AddressItem> getAddressItems() {
        return addressItems;
    }

    public void setAddressItems(List<AddressItem> addressItems) {
        this.addressItems = addressItems;
    }

    public AddressInfo() {
    }

    public AddressInfo(Long userId, List<AddressItem> addressItems) {
        this.userId = userId;
        this.addressItems = addressItems;
    }

    /**
     * <h2>单个的地址信息</h2>
     * */
    @ApiModel(description = "用户的单个地址信息")
    public static class AddressItem {

        @ApiModelProperty(value = "地址表主键 id")
        private Long id;

        @ApiModelProperty(value = "用户姓名")
        private String username;

        @ApiModelProperty(value = "电话")
        private String phone;

        @ApiModelProperty(value = "省")
        private String province;

        @ApiModelProperty(value = "市")
        private String city;

        @ApiModelProperty(value = "详细的地址")
        private String addressDetail;

        @ApiModelProperty(value = "创建时间")
        private Date createTime;

        @ApiModelProperty(value = "更新时间")
        private Date updateTime;

        public AddressItem(Long id) {
            this.id = id;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getAddressDetail() {
            return addressDetail;
        }

        public void setAddressDetail(String addressDetail) {
            this.addressDetail = addressDetail;
        }

        public Date getCreateTime() {
            return createTime;
        }

        public void setCreateTime(Date createTime) {
            this.createTime = createTime;
        }

        public Date getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(Date updateTime) {
            this.updateTime = updateTime;
        }

        public AddressItem() {
        }

        public AddressItem(Long id, String username, String phone, String province, String city,
                           String addressDetail, Date createTime, Date updateTime) {
            this.id = id;
            this.username = username;
            this.phone = phone;
            this.province = province;
            this.city = city;
            this.addressDetail = addressDetail;
            this.createTime = createTime;
            this.updateTime = updateTime;
        }

        /**
         * <h2>将 AddressItem 转换成 UserAddress</h2>
         * */
        public UserAddress toUserAddress() {

            UserAddress userAddress = new UserAddress();

            userAddress.setUsername(this.username);
            userAddress.setPhone(this.phone);
            userAddress.setProvince(this.province);
            userAddress.setCity(this.city);
            userAddress.setAddressDetail(this.addressDetail);

            return userAddress;
        }
    }
}
