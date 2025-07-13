package com.LLD.paymentstrategy;

import java.math.BigDecimal;

public class PaymentClient {

    public static void main(String[] args) {
        // PaymentProcessor paymentProcessor = new UPIPayment();
        PaymentProcessor paymentProcessor = new CashPayment();
        PaymentStrategy paymentStrategy = new PaymentStrategy(paymentProcessor);
        PaymentFacade paymentFacade = new PaymentFacade();
        Payment payment = new Payment();
        payment.setStatus("pending");
        payment.setAmount(BigDecimal.valueOf(10L));
        Order order = new Order();
        order.setOrderId(1);
        order.setPayment(payment);
        Account account = new Account();
        account.setAccountNo(1);
        account.setBalance(BigDecimal.valueOf(100L));
        String paymentId = paymentFacade.pay(order, paymentStrategy, account);
        System.out.println(paymentId);
        System.out.println(order);
        System.out.println(account);
        System.out.println(payment);
    }
}
