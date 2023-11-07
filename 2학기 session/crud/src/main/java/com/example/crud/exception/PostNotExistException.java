package com.example.crud.exception;

public class PostNotExistException extends baseException {
    public PostNotExistException() {
        super("target post does not exist");
    }
}
