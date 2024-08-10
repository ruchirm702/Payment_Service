package dev.ruchir.payment_service.DTOs;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class PaymentDTO {
    private Long id;
    private BigDecimal amount;
    private String currency;
    private String status;
    private Long orderId;
}
