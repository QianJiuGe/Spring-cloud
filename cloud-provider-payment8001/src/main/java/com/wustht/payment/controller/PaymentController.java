package com.wustht.payment.controller;

import com.wustht.payment.service.PaymentService;
import com.wustht.pojo.entities.Payment;
import com.wustht.pojo.entities.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


/**
 * @author Ht
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/payment/create")
    public Result create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("*****插入结果：" + result);

        if (result > 0) {
            return new Result(200, "插入数据库成功,serverPort: " + serverPort, result);
        } else {
            return new Result(444, "插入数据库失败", null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public Result<Payment> getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);

        if (payment != null) {
            return new Result<>(200, "查询成功,serverPort:  " + serverPort, payment);
        } else {
            return new Result<>(444, "没有对应记录,查询ID: " + id, null);
        }
    }

    @GetMapping("/payment/discovery")
    public Object discovery() {

        List<String> services = discoveryClient.getServices();
        for(String service: services){
            log.info("*******service:{}",service);
        }

        String s = "CLOUD-PAYMENT-SERVICE";
        List<ServiceInstance> instances = discoveryClient.getInstances(s);
        for (ServiceInstance instance : instances){
            log.info(instance.getServiceId()+"\t"+instance.getHost()+"\t"+
                    instance.getPort()+"\t"+instance.getUri());
        }

        return discoveryClient;
    }

    @GetMapping("/payment/lb")
    public String getPaymentLb(){

        return serverPort;
    }


}
