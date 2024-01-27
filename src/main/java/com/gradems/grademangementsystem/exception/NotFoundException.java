package com.gradems.grademangementsystem.exception;

import java.util.UUID;

public class NotFoundException extends RuntimeException {
    public NotFoundException(UUID sId) {
        super("The id " + sId + " is not found in our Database");
    }

    public NotFoundException(UUID sId, UUID cId) {
        super("The student id " + sId + "and course id" + cId + " is not found in our Database");
    }
}
