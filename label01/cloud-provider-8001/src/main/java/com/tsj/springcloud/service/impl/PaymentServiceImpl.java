package com.tsj.springcloud.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tsj.springcloud.entities.Payment;
import com.tsj.springcloud.mapper.PaymentDao;
import com.tsj.springcloud.service.PaymentService;

@Service("paymentService")
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentDao paymentDao;

    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }

    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

}
