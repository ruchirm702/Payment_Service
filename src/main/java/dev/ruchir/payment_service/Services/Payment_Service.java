package dev.ruchir.payment_service.Services;

import com.razorpay.RazorpayException;
import com.stripe.exception.StripeException;

public interface Payment_Service {
    public String generate_Payment_Link(Long order_Id) throws RazorpayException, StripeException;
}
