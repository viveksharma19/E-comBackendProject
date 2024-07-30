package dev.vivek.ProductService.exception;

public class NoProductPresentException extends RuntimeException{

    public NoProductPresentException(String message) {
        super(message);
    }
}
