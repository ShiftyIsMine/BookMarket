package kr.ac.kopo.shifty.bookmarket.repository;

import kr.ac.kopo.shifty.bookmarket.domain.Order;

public interface OrderRepository {

    Long saveOrder(Long id);

    void saveOrder(Order order);
}
