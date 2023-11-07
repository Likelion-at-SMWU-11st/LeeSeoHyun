package com.example.crud.exception;

public class PostNotInBoardException extends baseException {
    public PostNotInBoardException() {
        super("target post is not in board");
    }
}
