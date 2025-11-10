package kr.ac.kopo.shifty.bookmarket.domain;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;

@Data
@ToString
public class CartItem {
    @Id
    private Long id;
    private Book book;
    private int quantity;
    private BigDecimal totalPrice;

    public CartItem(Book book) {
        super();
        this.book = book;
        quantity = 1;
        totalPrice = book.getUnitPrice();
    }

    public void setBook(Book book) {
        this.book = book;
        this.updateTotalPrice();
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
        this.updateTotalPrice();
    }

    public void updateTotalPrice() {
        totalPrice = this.book.getUnitPrice().multiply(new BigDecimal(this.quantity));
    }
}
