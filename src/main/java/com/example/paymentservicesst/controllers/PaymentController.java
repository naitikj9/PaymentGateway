package com.example.paymentservicesst.controllers;

import com.example.paymentservicesst.dtos.InitiatePaymentRequestDto;
import com.example.paymentservicesst.services.PaymentService;
import com.razorpay.RazorpayException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class PaymentController {
    private PaymentService paymentService;

    PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/")
    public String initiatePayment(@RequestBody InitiatePaymentRequestDto requestDto) throws RazorpayException {
        return paymentService.initiatePayment(
                requestDto.getOrderId(),
                requestDto.getEmail()
        );
    }
}
