package dev.ruchir.payment_service.Repositories;

import dev.ruchir.payment_service.Models.Refund;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RefundRepository extends JpaRepository<Refund, Long> {
}
