package com.wustht.pojo.entities;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author HuangTao
 * @Description 订单实体类
 * @Date 16:30 2021/10/17
 **/
@Data
public class Payment implements Serializable {
    private Long id;
    private String serial;
}
