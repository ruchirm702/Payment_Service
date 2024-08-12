package dev.ruchir.payment_service.Services;

import dev.ruchir.payment_service.DTOs.TransactionDTO;
import dev.ruchir.payment_service.Models.Transaction;
import dev.ruchir.payment_service.Repositories.TransactionRepository;
import dev.ruchir.payment_service.Repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;
    private final PaymentRepository paymentRepository;

    @Autowired
    public TransactionServiceImpl(TransactionRepository transactionRepository, PaymentRepository paymentRepository) {
        this.transactionRepository = transactionRepository;
        this.paymentRepository = paymentRepository;
    }

    @Override
    public TransactionDTO createTransaction(TransactionDTO transactionDTO) {
        Transaction transaction = new Transaction();
        transaction.setAmount(transactionDTO.getAmount());
        transaction.setCurrency("USD"); // Set default currency or derive from request
        transaction.setTransactionType("Credit"); // Default type or derive from request
        transaction.setPayment(paymentRepository.findById(transactionDTO.getPaymentId()).orElse(null));
        transactionRepository.save(transaction);
        return mapToDTO(transaction);
    }

    @Override
    public TransactionDTO getTransactionById(Long id) {
        return transactionRepository.findById(id)
                .map(this::mapToDTO)
                .orElse(null);
    }

    @Override
    public List<TransactionDTO> getAllTransactions() {
        return transactionRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public TransactionDTO updateTransaction(Long id, TransactionDTO transactionDTO) {
        return transactionRepository.findById(id)
                .map(transaction -> {
                    transaction.setAmount(transactionDTO.getAmount());
                    transaction.setCurrency(transactionDTO.getCurrency());
                    transaction.setTransactionType(transactionDTO.getStatus()); // Assuming status is used for type
                    transaction.setPayment(paymentRepository.findById(transactionDTO.getPaymentId()).orElse(null));
                    transactionRepository.save(transaction);
                    return mapToDTO(transaction);
                })
                .orElse(null);
    }

    @Override
    public void deleteTransaction(Long id) {
        transactionRepository.deleteById(id);
    }

    private TransactionDTO mapToDTO(Transaction transaction) {
        TransactionDTO dto = new TransactionDTO();
        dto.setId(transaction.getId());
        dto.setAmount(transaction.getAmount());
        dto.setStatus(transaction.getTransactionType()); // Assuming status is used for type
        dto.setCreatedAt(transaction.getCreatedAt());
        dto.setPaymentId(transaction.getPayment().getId());
        return dto;
    }
}
