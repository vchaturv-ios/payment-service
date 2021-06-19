package com.vish.paymentservice.api.service;

import com.vish.paymentservice.api.entity.Payment;
import com.vish.paymentservice.api.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.UUID;

@Service
public class PaymentService {

  @Autowired
  private PaymentRepository repository;

  public Payment doPayment(Payment payment) {
    payment.setPaymentStatus(paymentProcessing());
    payment.setTransactionId(UUID.randomUUID().toString());
    return repository.save(payment);
  }

  public String paymentProcessing() {
    return new Random().nextBoolean()?"success":"false";
  }

  public Payment findPaymentHistoryOrderId(int orderId) {
    return repository.findByOrderId(orderId);
  }
}
