package dev.ruchir.payment_service.Services;

import dev.ruchir.payment_service.DTOs.RefundDTO;

import java.math.BigDecimal;

public interface RefundService {
    RefundDTO initiateRefund(Long paymentId, BigDecimal amount, String reason);
}
