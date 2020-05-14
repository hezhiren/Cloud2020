package cn.hezhiren.service.impl;

import cn.hezhiren.dao.PaymentDao;
import cn.hezhiren.entities.Payment;
import cn.hezhiren.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author : hezr
 * @description :
 * @date : 2020/04/28
 **/
@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {

        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {

        return paymentDao.getPaymentById(id);
    }

    @Override
    public int createBatch() {
        Long start = System.currentTimeMillis();
        List<Integer> list = new ArrayList<>();
        List<Payment> payments = new ArrayList<>();
//        for(int i = 1; i < 1000; i ++) {
//            Payment payment = new Payment();
//            payment.setSerial(String.valueOf(i));
//            payments.add(payment);
//            paymentDao.create(payment);
//        }
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        try {
            for (Payment payment : payments) {
                CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(()-> {
                    int i = paymentDao.create(payment);
                    return i;
                }).whenComplete((returnValue, exception) -> {
                   list.add(returnValue);
                });
                completableFuture.get();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } finally {
            executorService.shutdownNow();
        }
        Long end = System.currentTimeMillis();
        System.out.println(end - start);
        return list.size();
    }
}
