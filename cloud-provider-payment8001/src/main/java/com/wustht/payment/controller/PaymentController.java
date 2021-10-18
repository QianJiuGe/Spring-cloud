package com.wustht.payment.controller;

import com.sun.org.apache.regexp.internal.RE;
import com.wustht.payment.pojo.entities.Payment;
import com.wustht.payment.pojo.entities.Result;
import com.wustht.payment.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


/**
 * @author Ht
 */
@RestController
@Slf4j
public class PaymentController{
    @Resource
    private PaymentService paymentService;

    @PostMapping(value = "/payment/create")
    public Result create(Payment payment)
    {
        int result = paymentService.create(payment);
        log.info("*****插入结果："+result);

        log.info("热部署结果");

        if(result > 0)
        {
            return new Result(200,"插入数据库成功,serverPort: "+3306,result);
        }else{
            return new Result(444,"插入数据库失败",null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public Result<Payment> getPaymentById(@PathVariable("id") Long id)
    {
        Payment payment = paymentService.getPaymentById(id);

        if(payment != null)
        {
            return new Result<>(200,"查询成功,serverPort:  "+3306,payment);
        }else{
            return new Result<>(444,"没有对应记录,查询ID: "+id,null);
        }
    }
}
