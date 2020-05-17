package cn.hezhiren.controller;

import cn.hezhiren.entities.CommonResult;
import cn.hezhiren.entities.Payment;
import cn.hezhiren.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * @author : hezr
 * @description :
 * @date : 2020/04/28
 **/
@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @Autowired
    private PaymentService paymentService;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("*****插入结果:  " + result);
        if(result > 0) {
            return new CommonResult(0000, "插入成功, serverPort: " + serverPort, result);
        } else{
            return new CommonResult(1111, "插入失败");
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("*****查询结果：" + payment);
        if(payment != null) {
            return new CommonResult(0000, "查询成功, serverPort: " + serverPort, payment);
        } else{
            return new CommonResult(1111, "没有对应记录");
        }
    }

    @GetMapping(value = "/payment/createBatch")
    public CommonResult createBatch() {
        int result = paymentService.createBatch();
        log.info("*****插入结果:  " + result);
        if(result > 0) {
            return new CommonResult(0000, "插入成功", result);
        } else{
            return new CommonResult(1111, "插入失败");
        }
    }
}
