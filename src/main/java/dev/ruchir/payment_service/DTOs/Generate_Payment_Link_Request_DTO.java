package dev.ruchir.payment_service.DTOs;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter

public class Generate_Payment_Link_Request_DTO {
    private Long order_Id;
    private BigDecimal amount;
    private String currency;
    private String description;
    private String redirectUrl;
}
