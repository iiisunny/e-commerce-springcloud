package com.iiisunny.ecommerce.advice;


import com.iiisunny.ecommerce.vo.CommonResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * 全局异常捕获处理
 * @author iiisunny
 */
@RestControllerAdvice
public class GlobalExceptionAdvice {

    private static final Logger LOG = LoggerFactory.getLogger(GlobalExceptionAdvice.class);

    @ExceptionHandler(value = Exception.class)
    public CommonResponse<String> handlerCommerceException(HttpServletRequest req, Exception ex){

        CommonResponse<String> response = new CommonResponse<>(-1, "Bussiness Error");
        response.setData(ex.getMessage());
        LOG.error("commerce service has error: [{}]", ex.getMessage());
        return response;
    }
}
