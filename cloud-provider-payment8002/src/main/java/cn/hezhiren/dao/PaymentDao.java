package cn.hezhiren.dao;

import cn.hezhiren.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author : hezr
 * @description :
 * @date : 2020/04/28
 **/
@Mapper
public interface PaymentDao {
    //增
    int create(Payment payment);

    //查询
    Payment getPaymentById(@Param("id") Long id);
}
