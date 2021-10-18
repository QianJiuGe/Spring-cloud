package com.wustht.payment.service.impl;

import com.wustht.payment.mapper.PaymentMapper;
import com.wustht.payment.pojo.entities.Payment;
import com.wustht.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author Ht
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentMapper paymentMapper;

    @Override
    public Payment getPaymentById(Long id) {
        Payment payment = paymentMapper.getPaymentById(id);

        return payment;
    }

    @Override
    public int create(Payment payment) {
        int res = paymentMapper.createPayment(payment);

        return res;
    }
}
