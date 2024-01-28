package com.gradems.grademangementsystem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.gradems.grademangementsystem.exception.ErrorResponse;
import com.gradems.grademangementsystem.exception.NotFoundException;
import com.gradems.grademangementsystem.exception.StudentNotEnrolledException;

@RestControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({StudentNotEnrolledException.class, NotFoundException.class})
    public ResponseEntity<Object> HandleNotFoundException(StudentNotEnrolledException ex) {
        ErrorResponse error = new ErrorResponse(Arrays.asList(ex.getMessage()), false);
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ResponseEntity<Object> handleDataAccessException(EmptyResultDataAccessException ex) {
        ErrorResponse error = new ErrorResponse(Arrays.asList("Cannot delete non-existing resource"), false);  
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<String> handleDataIntegrityViolation(DataIntegrityViolationException ex) {
        String errorMessage = "Data Integrity Violation: we cannot process your request.";
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
            HttpHeaders headers, HttpStatusCode status, WebRequest request) {
                
                List<String> errors = new ArrayList<>();

                for(ObjectError error : ex.getBindingResult().getAllErrors()) {
                    errors.add(error.getDefaultMessage());
                }
                return new ResponseEntity<>(new ErrorResponse(errors, false), HttpStatus.BAD_REQUEST);
    }
    
}
