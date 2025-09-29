package kr.ac.kopo.minn.bookmarket.service;

import kr.ac.kopo.minn.bookmarket.domain.Book;
import kr.ac.kopo.minn.bookmarket.domain.Order;
import kr.ac.kopo.minn.bookmarket.repository.BookRepository;
import kr.ac.kopo.minn.bookmarket.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private BookRepository bookRepository;

    public void confirmOrder(String bookid,long quantity) {
        Book bookById = bookRepository.getBookById(bookid);
        if(bookById.getUnitsInStock() < quantity) {
            throw new IllegalArgumentException("품절이용");
        }
        bookById.setUnitsInStock(bookById.getUnitsInStock() - quantity);

    }
    public Long saveOrder(Order order) {
        Long orderid = orderRepository.saveOrder(order);
        return 0L;
    }
}
