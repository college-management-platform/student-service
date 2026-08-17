package com.practice.studentservice.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.practice.studentservice.entity.StudentStatus;
import lombok.Data;

@JsonPropertyOrder({
        "id",
        "rollNumber",
        "firstName",
        "lastName",
        "department",
        "status"
})
@Data
public class StudentResponseDTO {

    Integer id;
    String rollNumber;
    String firstName;
    String lastName;
    String department;
    StudentStatus status;
}
