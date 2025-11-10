package kr.ac.kopo.shifty.bookmarket.service;

import kr.ac.kopo.shifty.bookmarket.domain.Cart;
import kr.ac.kopo.shifty.bookmarket.exception.CartException;
import kr.ac.kopo.shifty.bookmarket.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ControllerAdvice;


@Service
public class CartServiceImpl implements CartService{
    @Autowired
    private CartRepository cartRepository;

    public Cart create(Cart cart) {
        return cartRepository.create(cart);
    }

    public Cart read(String cartId) {
        return cartRepository.read(cartId);
    }

    public void update(String cartId, Cart cart) {
        cartRepository.update(cartId, cart);
    }

    public void delete(String cartId) {
        cartRepository.delete(cartId);
    }

    public Cart validateCart(String cartId) {
        Cart cart = cartRepository.read(cartId);
        if(cart==null || cart.getCartItems().isEmpty()){
            throw new CartException(cartId);
        }
        return cart;
    }
}
