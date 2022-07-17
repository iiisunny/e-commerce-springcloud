package com.iiisunny.ecommerce.entity;

import com.alibaba.fastjson.JSON;
import com.iiisunny.ecommerce.constant.BrandCategory;
import com.iiisunny.ecommerce.constant.GoodsCategory;
import com.iiisunny.ecommerce.constant.GoodsStatus;
import com.iiisunny.ecommerce.converter.BrandCategoryConverter;
import com.iiisunny.ecommerce.converter.GoodsCategoryConverter;
import com.iiisunny.ecommerce.converter.GoodsStatusConverter;
import com.iiisunny.ecommerce.goods.GoodsInfo;
import com.iiisunny.ecommerce.goods.SimpleGoodsInfo;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * <h1>商品表实体类定义</h1>
 * */
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "t_ecommerce_goods")
public class EcommerceGoods {

    /** 自增主键 */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    /** 商品类型 */
    @Column(name = "goods_category", nullable = false)
    @Convert(converter = GoodsCategoryConverter.class)
    private GoodsCategory goodsCategory;

    /** 品牌分类 */
    @Column(name = "brand_category", nullable = false)
    @Convert(converter = BrandCategoryConverter.class)
    private BrandCategory brandCategory;

    /** 商品名称 */
    @Column(name = "goods_name", nullable = false)
    private String goodsName;

    /** 商品名称 */
    @Column(name = "goods_pic", nullable = false)
    private String goodsPic;

    /** 商品描述信息 */
    @Column(name = "goods_description", nullable = false)
    private String goodsDescription;

    /** 商品状态 */
    @Column(name = "goods_status", nullable = false)
    @Convert(converter = GoodsStatusConverter.class)
    private GoodsStatus goodsStatus;

    /** 商品价格: 单位: 分、厘 */
    @Column(name = "price", nullable = false)
    private Integer price;

    /** 总供应量 */
    @Column(name = "supply", nullable = false)
    private Long supply;

    /** 库存 */
    @Column(name = "inventory", nullable = false)
    private Long inventory;

    /** 商品属性, json 字符串存储 */
    @Column(name = "goods_property", nullable = false)
    private String goodsProperty;

    /** 创建时间 */
    @CreatedDate
    @Column(name = "create_time", nullable = false)
    private Date createTime;

    /** 更新时间 */
    @LastModifiedDate
    @Column(name = "update_time", nullable = false)
    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public GoodsCategory getGoodsCategory() {
        return goodsCategory;
    }

    public void setGoodsCategory(GoodsCategory goodsCategory) {
        this.goodsCategory = goodsCategory;
    }

    public BrandCategory getBrandCategory() {
        return brandCategory;
    }

    public void setBrandCategory(BrandCategory brandCategory) {
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

    public GoodsStatus getGoodsStatus() {
        return goodsStatus;
    }

    public void setGoodsStatus(GoodsStatus goodsStatus) {
        this.goodsStatus = goodsStatus;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
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

    public String getGoodsProperty() {
        return goodsProperty;
    }

    public void setGoodsProperty(String goodsProperty) {
        this.goodsProperty = goodsProperty;
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

    public EcommerceGoods() {
    }

    public EcommerceGoods(
            Long id, GoodsCategory goodsCategory, BrandCategory brandCategory,
            String goodsName, String goodsPic, String goodsDescription,
            GoodsStatus goodsStatus, Integer price, Long supply, Long inventory,
            String goodsProperty, Date createTime, Date updateTime) {
        this.id = id;
        this.goodsCategory = goodsCategory;
        this.brandCategory = brandCategory;
        this.goodsName = goodsName;
        this.goodsPic = goodsPic;
        this.goodsDescription = goodsDescription;
        this.goodsStatus = goodsStatus;
        this.price = price;
        this.supply = supply;
        this.inventory = inventory;
        this.goodsProperty = goodsProperty;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    /**
     * <h2>将 GoodsInfo 转成实体对象</h2>
     * */
    public static EcommerceGoods to(GoodsInfo goodsInfo) {

        EcommerceGoods ecommerceGoods = new EcommerceGoods();

        ecommerceGoods.setGoodsCategory(GoodsCategory.of(goodsInfo.getGoodsCategory()));
        ecommerceGoods.setBrandCategory(BrandCategory.of(goodsInfo.getBrandCategory()));
        ecommerceGoods.setGoodsName(goodsInfo.getGoodsName());
        ecommerceGoods.setGoodsPic(goodsInfo.getGoodsPic());
        ecommerceGoods.setGoodsDescription(goodsInfo.getGoodsDescription());
        ecommerceGoods.setGoodsStatus(GoodsStatus.ONLINE);  // 可以增加一个审核的过程
        ecommerceGoods.setPrice(goodsInfo.getPrice());
        ecommerceGoods.setSupply(goodsInfo.getSupply());
        ecommerceGoods.setInventory(goodsInfo.getSupply());
        ecommerceGoods.setGoodsProperty(
                JSON.toJSONString(goodsInfo.getGoodsProperty())
        );

        return ecommerceGoods;
    }

    /**
     * <h2>将实体对象转成 GoodsInfo 对象</h2>
     * */
    public GoodsInfo toGoodsInfo() {

        GoodsInfo goodsInfo = new GoodsInfo();

        goodsInfo.setId(this.id);
        goodsInfo.setGoodsCategory(this.goodsCategory.getCode());
        goodsInfo.setBrandCategory(this.brandCategory.getCode());
        goodsInfo.setGoodsName(this.goodsName);
        goodsInfo.setGoodsPic(this.goodsPic);
        goodsInfo.setGoodsDescription(this.goodsDescription);
        goodsInfo.setGoodsStatus(this.goodsStatus.getStatus());
        goodsInfo.setPrice(this.price);
        goodsInfo.setGoodsProperty(
                JSON.parseObject(this.goodsProperty, GoodsInfo.GoodsProperty.class)
        );
        goodsInfo.setSupply(this.supply);
        goodsInfo.setInventory(this.inventory);
        goodsInfo.setCreateTime(this.createTime);
        goodsInfo.setUpdateTime(this.updateTime);

        return goodsInfo;
    }

    /**
     * <h2>将实体对象转成 SimpleGoodsInfo 对象</h2>
     * */
    public SimpleGoodsInfo toSimple() {

        SimpleGoodsInfo simpleGoodsInfo = new SimpleGoodsInfo();

        simpleGoodsInfo.setId(this.id);
        simpleGoodsInfo.setGoodsName(this.goodsName);
        simpleGoodsInfo.setGoodsPic(this.goodsPic);
        simpleGoodsInfo.setPrice(this.price);

        return simpleGoodsInfo;
    }
}
