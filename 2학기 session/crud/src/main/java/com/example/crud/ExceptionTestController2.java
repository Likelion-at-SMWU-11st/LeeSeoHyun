package com.example.crud;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("except2")
public class ExceptionTestController2 {
    @GetMapping("/{id}")
    public void throwException(@PathVariable("id") int id){
        switch(id){
            default:
                throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
