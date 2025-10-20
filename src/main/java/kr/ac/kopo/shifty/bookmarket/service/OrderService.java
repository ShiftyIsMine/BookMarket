package kr.ac.kopo.shifty.bookmarket.service;

import kr.ac.kopo.shifty.bookmarket.domain.Order;

public interface OrderService {
    void confirmOrder(String bookid,long quantity);
    Long saveOrder(Order order);

}
