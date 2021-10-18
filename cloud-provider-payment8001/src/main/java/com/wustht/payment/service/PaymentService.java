package com.wustht.payment.service;

import com.wustht.pojo.entities.Payment;

/**
 * @author Ht
 */
public interface PaymentService {

    /**
     * 根据id获取订单的信息
     * @param id
     * @return
     */
    Payment getPaymentById(Long id);

    /**
     * 创建
     * @param payment
     * @return
     */
    public int create(Payment payment);
}
