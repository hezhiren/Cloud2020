package cn.hezhiren.service;

import cn.hezhiren.entities.Payment;

/**
 * @author : hezr
 * @description :
 * @date : 2020/04/28
 **/
public interface PaymentService {
    //增
    int create(Payment payment);

    //查询
    Payment getPaymentById(Long id);

    // 批量插入
    int createBatch();
}
