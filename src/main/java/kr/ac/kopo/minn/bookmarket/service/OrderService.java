package kr.ac.kopo.minn.bookmarket.service;

import kr.ac.kopo.minn.bookmarket.domain.Order;

public interface OrderService {
    void confirmOrder(String bookid,long quantity);
    Long saveOrder(Order order);

}
