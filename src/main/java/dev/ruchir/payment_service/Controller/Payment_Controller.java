package dev.ruchir.payment_service.Controller;


import dev.ruchir.payment_service.DTOs.Generate_Payment_Link_Request_DTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")

public class Payment_Controller {

    @PostMapping()
    public String generate_Payment_Link(@RequestBody Generate_Payment_Link_Request_DTO requestDto){
        return null;
    }



}
