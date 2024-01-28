package com.gradems.grademangementsystem.exception;

import java.util.UUID;

public class StudentNotEnrolledException extends RuntimeException {
    public StudentNotEnrolledException(UUID studentId, UUID courseId) {
        super("The student with id: " + studentId + " is not enrolled in the course with " + courseId);
    }
}
