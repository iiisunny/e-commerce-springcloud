package com.iiisunny.ecommerce.vo;

import java.io.Serializable;
import java.util.List;

/**
 * 通用响应对象定义
 * {
 *     "code": 0,
 *     "message": "",
 *     "data": {}
 * }
 */

public class CommonResponse<T> implements Serializable {

    /** 错误码 */
    private Integer code;

    /** 错误消息 */
    private String message;

    /** 泛型响应数据 */
    private T data;

    public CommonResponse(int code, String message, List<T> data) {
        this.code = code;
        this.message = message;
        this.data = (T) data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public CommonResponse(Integer code, String message){

        this.code = code;
        this.message = message;
    }

}
