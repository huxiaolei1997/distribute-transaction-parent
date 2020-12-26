package com.xlh.distribute.transaction.local.msg.demo.controller;

import com.xlh.distribute.transaction.local.msg.demo.service.PaymentService;
import org.springframework.web.bind.annotation.GetMapping;
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
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @GetMapping("/payment")
    public String payment(long userId, int orderId, BigDecimal amount) {
        int result = paymentService.payment(userId, orderId, amount);
        return "支付结果：" + result;

    }
}
