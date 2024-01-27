package com.gradems.grademangementsystem.exception;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class ErrorResponse {
    private boolean success;
    private String message;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime dateTimeStamp;

    public ErrorResponse(String message, boolean success) {
        this.message = message;
        this.success = success;
        this.dateTimeStamp = LocalDateTime.now();
    }


}
