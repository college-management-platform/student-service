package com.practice.studentservice.dto;

import com.practice.studentservice.entity.StudentStatus;
import lombok.Data;

@Data
public class StudentRequestDTO {

    private String rollNumber;

    private String firstName;

    private String lastName;

    String department;

    StudentStatus status;
}
