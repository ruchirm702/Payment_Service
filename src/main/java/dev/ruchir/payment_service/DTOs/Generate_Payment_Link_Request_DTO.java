package dev.ruchir.payment_service.DTOs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Generate_Payment_Link_Request_DTO {
    private Long order_Id;
}
