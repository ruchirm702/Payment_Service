package dev.ruchir.payment_service.Controller;

import com.razorpay.RazorpayException;
import com.stripe.exception.StripeException;
import dev.ruchir.payment_service.DTOs.Generate_Payment_Link_Request_DTO;
import dev.ruchir.payment_service.Services.Payment_Service;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class Payment_Controller {

    private final Payment_Service payment_service;

    public Payment_Controller(@Qualifier("stripePaymentGateway") Payment_Service payment_service) {
        this.payment_service = payment_service;
    }

    @PostMapping()
    public String generate_Payment_Link(@RequestBody Generate_Payment_Link_Request_DTO requestDto) throws RazorpayException, StripeException {
        return payment_service.generate_Payment_Link(requestDto.getOrder_Id());
    }

    @PostMapping("/webhook")
    public void handleWebhookEvent(@RequestBody Object object) {
        // Placeholder for webhook event handling logic
        System.out.println("Webhook triggered");
    }
}
