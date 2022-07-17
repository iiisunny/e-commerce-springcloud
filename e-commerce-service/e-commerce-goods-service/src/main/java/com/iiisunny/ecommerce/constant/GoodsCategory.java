package com.iiisunny.ecommerce.constant;

import java.util.Objects;
import java.util.stream.Stream;

/**
 * <h1>商品类别</h1>
 * 电器 -> 手机、电脑
 * */
public enum GoodsCategory {

    DIAN_QI("10001", "电器"),
    JIA_JU("10002", "家具"),
    FU_SHI("10003", "服饰"),
    MY_YIN("10004", "母婴"),
    SHI_PIN("10005", "食品"),
    TU_SHU("10006", "图书"),
    ;

    /** 商品类别编码 */
    private final String code;

    /** 商品类别描述信息 */
    private final String description;

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    GoodsCategory(String code, String description) {
        this.code = code;
        this.description = description;
    }

    /**
     * <h2>根据 code 获取到 GoodsCategory</h2>
     * */
    public static GoodsCategory of(String code) {

        Objects.requireNonNull(code);

        return Stream.of(values())
                .filter(bean -> bean.code.equals(code))
                .findAny()
                .orElseThrow(
                        () -> new IllegalArgumentException(code + " not exists")
                );
    }
}
