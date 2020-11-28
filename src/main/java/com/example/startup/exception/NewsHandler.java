package com.example.startup.exception;

import com.example.startup.response.CustomResponse;
import java.time.LocalDateTime;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class NewsHandler {

    @ExceptionHandler(EntityExistsException.class)
    protected ResponseEntity handleEntityAlreadyExistsException(EntityExistsException e, HttpServletRequest request) {
        CustomResponse response = new CustomResponse();
        response.setCode(400);
        response.setPath(request.getServletPath());
        response.setMessage(e.getMessage());
        response.setDate(LocalDateTime.now());
        return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    protected ResponseEntity handleEntityNotFoundException(EntityNotFoundException e, HttpServletRequest request) {
        CustomResponse response = new CustomResponse();
        response.setCode(404);
        response.setPath(request.getServletPath());
        response.setMessage(e.getMessage());
        response.setDate(LocalDateTime.now());
        return new ResponseEntity(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    protected ResponseEntity handleEntityAlreadyExistsException(Exception e, HttpServletRequest request) {
        CustomResponse response = new CustomResponse();
        response.setCode(500);
        response.setPath(request.getServletPath());
        response.setMessage(e.getMessage());
        response.setDate(LocalDateTime.now());
        return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
