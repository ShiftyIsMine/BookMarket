package kr.ac.kopo.shifty.bookmarket.service;

import kr.ac.kopo.shifty.bookmarket.domain.Cart;

public interface CartService {
    Cart create(Cart cart);
    Cart read(String cartId);
    void update(String cartId, Cart cart);
    void delete(String cartId);

    Cart validateCart(String cartId);
}
