package kr.ac.kopo.minn.bookmarket.exception;

import lombok.Getter;

@Getter
public class CartException extends RuntimeException {
    private final String cartId;

    public CartException(String cartId) {
        this.cartId = cartId;

    }
}
