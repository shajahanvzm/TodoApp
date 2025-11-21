package com.codemx.todoapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class TodosAlreadyExistsException extends RuntimeException {
    public TodosAlreadyExistsException(String message) {
        super(message);
    }
}
