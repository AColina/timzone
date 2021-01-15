package com.acolina.timezone.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @author Angel Colina
 * @version 1.0
 */
@ControllerAdvice
public class GlobalExceptionController {


    /**
     * Handler para errores tipo {@link Exception}
     *
     * @param ex Exception ocurrida durante la llamada de los servicios Rest
     * @return Json que representa el error que se presento y el Codigo de Error
     * HTTP que representa dicho error
     */
    @ExceptionHandler(Exception.class)
    public @ResponseBody
    ResponseEntity<String> handleAllException(
            Exception ex) {
        String error = "General error\nMessage: " + ex.getMessage();
        return ResponseEntity.ok(error);

    }
}
