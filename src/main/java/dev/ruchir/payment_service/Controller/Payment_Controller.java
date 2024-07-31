package dev.ruchir.payment_service.Controller;


import com.razorpay.RazorpayException;
import dev.ruchir.payment_service.DTOs.Generate_Payment_Link_Request_DTO;
import dev.ruchir.payment_service.Services.Payment_Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")

public class Payment_Controller {
    private Payment_Service payment_service;

        public Payment_Controller(Payment_Service payment_service) {
            this.payment_service = payment_service;
        }
    //POST -> http://localhost:8080/payments
    @PostMapping()
    public String generate_Payment_Link(@RequestBody Generate_Payment_Link_Request_DTO requestDto) throws RazorpayException {
        //Ideally we should handle the exception in the controller using Controller Advice
        return payment_service.generate_Payment_Link(requestDto.getOrder_Id());
    }
}
