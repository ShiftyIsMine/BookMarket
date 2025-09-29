package kr.ac.kopo.minn.bookmarket.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Data
@Entity
@Table(name="orders")
public class Order {
    @Id
    @GeneratedValue
    private long id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="shipping_id")
    private Shipping shipping;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_order_id")
    private Map<String, OrderItem> orderitems = new HashMap<>();

    private BigDecimal grandtotal;

    public Long getOrderId() {
        return id;
    }
}
