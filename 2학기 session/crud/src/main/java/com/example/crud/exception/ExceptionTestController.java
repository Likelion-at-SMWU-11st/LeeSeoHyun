package com.example.crud.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("except")
public class ExceptionTestController {
    @GetMapping("/{id}")
    public void throwExceptionTest(@PathVariable int id){
        switch(id) {
            case 1:
                throw new PostNotExistException();
            case 2:
                throw new PostNotInBoardException();
            default:
                throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

   // @ExceptionHandler(baseException.class)
    //@ResponseStatus(HttpStatus.BAD_REQUEST)
    //public ErrorResponseDto handleBaseException(baseException exception){
        //return new ErrorResponseDto(exception.getMessage());
    //}
}
