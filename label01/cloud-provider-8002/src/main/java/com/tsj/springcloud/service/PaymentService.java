package com.tsj.springcloud.service;

import com.tsj.springcloud.entities.Payment;

public interface PaymentService {

    Payment getPaymentById(Long id);

    int create(Payment payment);
    
}
