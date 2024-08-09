package com.example.menu.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class ExceptionController {
    
    private static final Logger logger = LoggerFactory.getLogger(ExceptionController.class);

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e ) {
        logger.error("Erro inesperado", e );
        return new ResponseEntity<>("Erro inesperado: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
