package com.iiisunny.ecommerce.constant;

import java.util.Objects;
import java.util.stream.Stream;

/**
 * <h1>商品状态枚举类</h1>
 * */
public enum GoodsStatus {

    ONLINE(101, "上线"),
    OFFLINE(102, "下线"),
    STOCK_OUT(103, "缺货"),
    ;

    /** 状态码 */
    private final Integer status;

    /** 状态描述 */
    private final String description;

    public Integer getStatus() {
        return status;
    }

    public String getDescription() {
        return description;
    }

    GoodsStatus(Integer status, String description) {
        this.status = status;
        this.description = description;
    }

    /**
     * <h2>根据 code 获取到 GoodsStatus</h2>
     * */
    public static GoodsStatus of(Integer status) {

        Objects.requireNonNull(status);

        return Stream.of(values())
                .filter(bean -> bean.status.equals(status))
                .findAny()
                .orElseThrow(
                        () -> new IllegalArgumentException(status + " not exists")
                );
    }
}
