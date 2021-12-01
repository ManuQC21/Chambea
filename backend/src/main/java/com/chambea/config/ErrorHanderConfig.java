package com.chambea.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ValidationException;
import java.util.List;

@Slf4j//For logger
@ControllerAdvice

public class ErrorHanderConfig {

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity handleValidationException(
            HttpServletRequest httpServletRequest,
            ValidationException e)
    {
            log.error("ValidationException {} {}\n",httpServletRequest.getRequestURI(), e.getMessage());

            return ResponseEntity
                    .badRequest()
                    .body("Validation Exception "+ List.of(e.getMessage()));
    }
}
