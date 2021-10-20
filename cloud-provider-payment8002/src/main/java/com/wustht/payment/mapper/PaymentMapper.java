package com.wustht.payment.mapper;

import com.wustht.pojo.entities.Payment;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Ht
 */
@Mapper
public interface PaymentMapper {

    /**
     * 上传订单
     * @param payment
     * @return
     */
    int createPayment(Payment payment);

    /**
     * 根据id获取订单信息
     * @param id
     * @return
     */
    Payment getPaymentById(Long id);

}
