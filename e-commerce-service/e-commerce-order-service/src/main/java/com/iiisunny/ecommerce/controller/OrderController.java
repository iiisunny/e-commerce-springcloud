package com.iiisunny.ecommerce.controller;

import com.iiisunny.ecommerce.common.TableId;
import com.iiisunny.ecommerce.order.OrderInfo;
import com.iiisunny.ecommerce.service.IOrderService;
import com.iiisunny.ecommerce.vo.PageSimpleOrderDetail;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <h1>订单服务对外 HTTP 接口</h1>
 * */
@Api(tags = "订单服务")
@RestController
@RequestMapping("/order")
public class OrderController {

    private final IOrderService orderService;

    public OrderController(IOrderService orderService) {
        this.orderService = orderService;
    }

    @ApiOperation(
            value = "创建",
            notes = "购买(分布式事务): 创建订单 -> 扣减库存 -> 扣减余额 -> 发送物流消息",
            httpMethod = "POST"
    )
    @PostMapping("/create-order")
    public TableId createOrder(@RequestBody OrderInfo orderInfo) {
        return orderService.createOrder(orderInfo);
    }

    @ApiOperation(
            value = "订单信息",
            notes = "获取当前用户的订单信息: 带有分页",
            httpMethod = "GET"
    )
    @GetMapping("/order-detail")
    public PageSimpleOrderDetail getSimpleOrderDetailByPage(
            @RequestParam(required = false, defaultValue = "1") int page) {
        return orderService.getSimpleOrderDetailByPage(page);
    }
}
