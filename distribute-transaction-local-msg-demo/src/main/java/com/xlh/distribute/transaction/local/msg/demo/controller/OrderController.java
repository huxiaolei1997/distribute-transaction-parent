package com.xlh.distribute.transaction.local.msg.demo.controller;

import com.xlh.distribute.transaction.local.msg.demo.service.OrderService;
import com.xlh.distribute.transaction.local.msg.demo.service.PaymentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * 用途描述
 *
 * @author 胡晓磊
 * @company xxx
 * @date 2020年12月26日 21:14 胡晓磊 Exp $
 */
@RestController
public class OrderController {

    @Resource
    private OrderService orderService;

    @PostMapping("/handleOrder")
    public String handleOrder(int orderId) {
        try {
            int result = orderService.handleOrder(orderId);

            if (result == 0) {
                return "success";
            }

            return "fail";
        } catch (Exception e) {
            return "fail";
        }


    }
}
