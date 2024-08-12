package dev.ruchir.payment_service.ControllerAdvice;

public class PaymentException extends RuntimeException {
    public PaymentException(String message) {
        super(message);
    }
}