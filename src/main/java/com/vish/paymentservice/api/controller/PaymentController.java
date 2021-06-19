package com.vish.paymentservice.api.controller;

import com.vish.paymentservice.api.entity.Payment;
import com.vish.paymentservice.api.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController {

  @Autowired
  private PaymentService service;

  @PostMapping("/doPayment")
  public Payment doPayment(@RequestBody Payment payment) {
    return service.doPayment(payment);
  }

  @GetMapping("/{orderId}")
  public Payment findPaymentHistoryByOrderId(@PathVariable int orderId) {
    return service.findPaymentHistoryOrderId(orderId);

  }

}
