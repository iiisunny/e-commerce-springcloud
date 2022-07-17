package com.iiisunny.ecommerce.goods;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <h1>简单商品信息：封面</h1>
 */
@ApiModel(description = "简单的商品信息")
public class SimpleGoodsInfo {

    @ApiModelProperty(value = "商品表主键 id")
    private Long id;

    @ApiModelProperty(value = "商品名称")
    private String goodsName;

    @ApiModelProperty(value = "商品图片")
    private String goodsPic;

    @ApiModelProperty(value = "商品价格")
    private Integer price;

    public SimpleGoodsInfo(Long id) {
        this.id = id;
    }

    public SimpleGoodsInfo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
