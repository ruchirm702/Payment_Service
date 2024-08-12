package dev.ruchir.payment_service.Services;

import dev.ruchir.payment_service.DTOs.RefundDTO;
import dev.ruchir.payment_service.Models.Refund;
import dev.ruchir.payment_service.Repositories.RefundRepository;
import dev.ruchir.payment_service.Repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class RefundServiceImpl implements RefundService {

    private RefundRepository refundRepository;
    private PaymentRepository paymentRepository;

    @Override
    public RefundDTO initiateRefund(Long paymentId, BigDecimal amount, String reason) {
        // Logic to create a refund and interact with payment gateways
        Refund refund = new Refund();
        refund.setAmount(amount);
        refund.setCurrency("USD"); // Example currency
        refund.setReason(reason);
        refund.setPayment(paymentRepository.findById(paymentId).orElseThrow(() -> new RuntimeException("Payment not found")));
        refund.setRefundDate(LocalDateTime.now());

        Refund savedRefund = refundRepository.save(refund);

        // Convert to DTO
        RefundDTO refundDTO = new RefundDTO();
        refundDTO.setId(savedRefund.getId());
        refundDTO.setAmount(savedRefund.getAmount());
        refundDTO.setCurrency(savedRefund.getCurrency());
        refundDTO.setReason(savedRefund.getReason());
        refundDTO.setPaymentId(savedRefund.getPayment().getId());
        refundDTO.setRefundDate(savedRefund.getRefundDate());

        return refundDTO;
    }
}
