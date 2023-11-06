package com.example.crud.exception.PostControllerAdvice;

import com.example.crud.exception.ErrorResponseDto;
import com.example.crud.exception.baseException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class PostControllerAdvice {

    @ExceptionHandler(baseException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponseDto handlerException(baseException exception){
        return new ErrorResponseDto(exception.getMessage());
    }
}
