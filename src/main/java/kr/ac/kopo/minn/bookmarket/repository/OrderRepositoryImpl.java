package kr.ac.kopo.minn.bookmarket.repository;

import kr.ac.kopo.minn.bookmarket.domain.Order;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class OrderRepositoryImpl implements OrderRepository {
    private final Map<Long, Order> listOfOrders;
    private long nextOrderId;

    public OrderRepositoryImpl() {
        listOfOrders = new HashMap<>();
        nextOrderId = 2000;
    }

    @Override
    public Long saveOrder(Long id) {
        return 0L;
    }

    @Override
    public Long saveOrder(Order order) {
        order.setId(getNextOrderId());
        listOfOrders.put(order.getOrderId(), order);
        return order.getOrderId();
    }
    private synchronized long getNextOrderId() {
        return nextOrderId++;
    }


}
