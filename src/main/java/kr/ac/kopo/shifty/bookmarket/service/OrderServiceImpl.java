package kr.ac.kopo.shifty.bookmarket.service;

import kr.ac.kopo.shifty.bookmarket.domain.Book;
import kr.ac.kopo.shifty.bookmarket.domain.Order;
import kr.ac.kopo.shifty.bookmarket.repository.BookRepository;
import kr.ac.kopo.shifty.bookmarket.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private BookRepository bookRepository;

    public void confirmOrder(String bookId,long quantity) {
        Book bookById = bookRepository.getBookById(bookId);
        if(bookById.getUnitsInStock() < quantity) {
            throw new IllegalArgumentException("품절이용");
        }
        bookById.setUnitsInStock(bookById.getUnitsInStock() - quantity);

    }
    public void saveOrder(Order order) {
        orderRepository.saveOrder(order);
    }
}
