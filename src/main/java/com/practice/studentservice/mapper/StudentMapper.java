package com.practice.studentservice.mapper;

import com.practice.studentservice.dto.StudentRequestDTO;
import com.practice.studentservice.dto.StudentResponseDTO;
import com.practice.studentservice.entity.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {

    public static StudentResponseDTO convertToStudentDTO(Student student) {

        StudentResponseDTO studentResponseDto = new StudentResponseDTO();
        studentResponseDto.setId(student.getId());
        studentResponseDto.setRollNumber(student.getRollNumber());
        studentResponseDto.setFirstName(student.getFirstName());
        studentResponseDto.setLastName(student.getLastName());
        studentResponseDto.setDepartment(student.getDepartment());
        studentResponseDto.setStatus(student.getStatus());

        return studentResponseDto;
    }

    public static Student convertToStudentEntity(StudentRequestDTO studentRequestDTO) {

        Student student = new Student();
        student.setRollNumber(studentRequestDTO.getRollNumber());
        student.setFirstName(studentRequestDTO.getFirstName());
        student.setLastName(studentRequestDTO.getLastName());
        student.setDepartment(studentRequestDTO.getDepartment());
        student.setStatus(studentRequestDTO.getStatus());

        return student;
    }
}
