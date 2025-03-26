package com.ajackus.library.exceptions;

public class InvalidProductException extends RuntimeException{

    public InvalidProductException(String errorMessage) {
        super(errorMessage);
    }

}
