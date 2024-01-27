package com.gradems.grademangementsystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Object> HandleStudentNotFoundException(NotFoundException ex) {
        ErrorResponse errorMessage = new ErrorResponse(ex.getMessage(), false);
        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
    }
    
}
