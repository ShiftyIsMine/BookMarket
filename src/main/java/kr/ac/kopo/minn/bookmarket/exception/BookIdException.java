package kr.ac.kopo.minn.bookmarket.exception;

import lombok.Getter;

@Getter
public class BookIdException extends RuntimeException {
    private final String bookId;
    public BookIdException(String bookId) {
        super();
        this.bookId = bookId;
    }

}
