package dev.ruchir.payment_service.Services;

import org.springframework.stereotype.Service;

@Service
public class Razorpay_Payment_Gateway implements Payment_Service{

    @Override
    public String generate_Payment_Link(Long order_Id){
        //Make a call to RazorPay to generate the Payment Link
        return null;
    }
}
