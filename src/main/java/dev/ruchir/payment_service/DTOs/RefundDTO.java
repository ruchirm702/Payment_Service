package dev.ruchir.payment_service.DTOs;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class RefundDTO {
    private Long id;
    private BigDecimal amount;
    private String currency;
    private String reason;
    private Long paymentId;
    private LocalDateTime refundDate;
}
