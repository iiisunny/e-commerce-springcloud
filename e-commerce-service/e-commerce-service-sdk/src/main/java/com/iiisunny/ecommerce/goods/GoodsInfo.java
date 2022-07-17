package com.iiisunny.ecommerce.goods;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * <h1>商品信息</h1>
 */
@ApiModel(description = "详细的商品信息")
public class GoodsInfo {

    @ApiModelProperty(value = "商品表主键 id")
    private Long id;

    @ApiModelProperty(value = "商品类别编码")
    private String goodsCategory;

    @ApiModelProperty(value = "品牌类别编码")
    private String brandCategory;

    @ApiModelProperty(value = "商品名称")
    private String goodsName;

    @ApiModelProperty(value = "商品图片")
    private String goodsPic;

    @ApiModelProperty(value = "商品描述信息")
    private String goodsDescription;

    @ApiModelProperty(value = "商品状态")
    private Integer goodsStatus;

    @ApiModelProperty(value = "商品价格")
    private Integer price;

    @ApiModelProperty(value = "商品属性")
    private GoodsProperty goodsProperty;

    @ApiModelProperty(value = "供应量")
    private Long supply;

    @ApiModelProperty(value = "库存")
    private Long inventory;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    /**
     * <h2>商品属性</h2>
     */
    @ApiModel(description = "商品属性对象")
    public static class GoodsProperty {

        @ApiModelProperty(value = "尺寸")
        private String size;

        @ApiModelProperty(value = "颜色")
        private String color;

        @ApiModelProperty(value = "材质")
        private String material;

        @ApiModelProperty(value = "图案")
        private String pattern;

        public GoodsProperty() {
        }

        public GoodsProperty(String size, String color, String material, String pattern) {
            this.size = size;
            this.color = color;
            this.material = material;
            this.pattern = pattern;
        }

        public String getSize() {
            return size;
        }

        public void setSize(String size) {
            this.size = size;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String getMaterial() {
            return material;
        }

        public void setMaterial(String material) {
            this.material = material;
        }

        public String getPattern() {
            return pattern;
        }

        public void setPattern(String pattern) {
            this.pattern = pattern;
        }
    }

    public GoodsInfo() {
    }

    public GoodsInfo(
            Long id, String goodsCategory, String brandCategory, String goodsName,
            String goodsPic, String goodsDescription, Integer goodsStatus, Integer price,
            GoodsProperty goodsProperty, Long supply, Long inventory, Date createTime, Date updateTime) {
        this.id = id;
        this.goodsCategory = goodsCategory;
        this.brandCategory = brandCategory;
        this.goodsName = goodsName;
        this.goodsPic = goodsPic;
        this.goodsDescription = goodsDescription;
        this.goodsStatus = goodsStatus;
        this.price = price;
        this.goodsProperty = goodsProperty;
        this.supply = supply;
        this.inventory = inventory;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGoodsCategory() {
        return goodsCategory;
    }

    public void setGoodsCategory(String goodsCategory) {
        this.goodsCategory = goodsCategory;
    }

    public String getBrandCategory() {
        return brandCategory;
    }

    public void setBrandCategory(String brandCategory) {
        this.brandCategory = brandCategory;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsPic() {
        return goodsPic;
    }

    public void setGoodsPic(String goodsPic) {
        this.goodsPic = goodsPic;
    }

    public String getGoodsDescription() {
        return goodsDescription;
    }

    public void setGoodsDescription(String goodsDescription) {
        this.goodsDescription = goodsDescription;
    }

    public Integer getGoodsStatus() {
        return goodsStatus;
    }

    public void setGoodsStatus(Integer goodsStatus) {
        this.goodsStatus = goodsStatus;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public GoodsProperty getGoodsProperty() {
        return goodsProperty;
    }

    public void setGoodsProperty(GoodsProperty goodsProperty) {
        this.goodsProperty = goodsProperty;
    }

    public Long getSupply() {
        return supply;
    }

    public void setSupply(Long supply) {
        this.supply = supply;
    }

    public Long getInventory() {
        return inventory;
    }

    public void setInventory(Long inventory) {
        this.inventory = inventory;
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
}
