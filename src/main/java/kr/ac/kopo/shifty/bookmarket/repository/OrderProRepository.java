package kr.ac.kopo.shifty.bookmarket.repository;

import kr.ac.kopo.shifty.bookmarket.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderProRepository extends JpaRepository<Order, Long> {
}
