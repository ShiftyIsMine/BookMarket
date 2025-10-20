package kr.ac.kopo.shifty.bookmarket.exception;

import lombok.Getter;

@Getter
public class CartException extends RuntimeException {
    private final String cartId;

    public CartException(String cartId) {
        this.cartId = cartId;

    }
}
