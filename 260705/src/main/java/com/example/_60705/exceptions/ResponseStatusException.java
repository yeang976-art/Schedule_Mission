package com.example._60705.exceptions;

import org.springframework.http.HttpStatus;

public class ResponseStatusException extends RuntimeException {
    public ResponseStatusException(HttpStatus h, String s) { super(h, s);
    }
}
