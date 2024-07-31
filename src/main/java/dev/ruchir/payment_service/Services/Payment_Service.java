package dev.ruchir.payment_service.Services;

public interface Payment_Service {
    public String generate_Payment_Link(Long order_Id);
}
