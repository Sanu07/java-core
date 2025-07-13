package com.LLD.paymentstrategy;

public class PaymentFacade {

    public String pay(Order order, PaymentStrategy paymentStrategy, Account account) {
        Payment payment = order.getPayment();
        String pay = paymentStrategy.pay(payment.getAmount());
        payment.setPaymentId(pay);
        payment.setStatus("COMPLETED");
        account.setBalance(account.getBalance().subtract(payment.getAmount()));
        return pay;
    }
}
