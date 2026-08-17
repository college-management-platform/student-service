package com.practice.studentservice.service;

import com.practice.studentservice.dto.StudentRequestDTO;
import com.practice.studentservice.dto.StudentResponseDTO;
import com.practice.studentservice.entity.Student;
import com.practice.studentservice.entity.StudentStatus;
import com.practice.studentservice.mapper.StudentMapperInterface;
import com.practice.studentservice.repository.StudentRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class StudentService {

    @Autowired
    private StudentRepo studentRepo;

    private final StudentMapperInterface mapper;

    public StudentService(StudentMapperInterface mapper) {
        this.mapper = mapper;
    }

    public StudentResponseDTO addStudent(StudentRequestDTO studentRequestDTO) {
        log.info("Adding student details to database");
        Student student = mapper.toEntity(studentRequestDTO);
        Student savedStudent = studentRepo.save(student);
        log.info("Successfully added student details to database ");
        return mapper.toDTO(savedStudent);
    }

    public List<StudentResponseDTO> getAllStudents() {
        log.info("Fetching all student details from database");
        List<Student> allStudents = studentRepo.findAll();
        log.info("Successfully fetched all student details from database ");
        return allStudents.stream().map(mapper::toDTO).toList();
    }

    public StudentResponseDTO getStudentById(int id) {
        log.info("Fetching student details by id = {} from database", id);
        Optional<Student> student = studentRepo.findById(id);
        StudentResponseDTO studentResponseDTO = null;
        if (student.isPresent()) {
            log.info("Successfully fetched student details for id = {} from database ", id);
            studentResponseDTO = mapper.toDTO(student.get());
        }
        return studentResponseDTO;
    }

    public StudentResponseDTO updateStudentStatusById(int id, StudentStatus status) {
        log.info("Updating student details for id = {} with status = {}", id, status);
        Optional<Student> student = studentRepo.findById(id);
        if (student.isPresent()) {
            log.info("Student found with id = {}", id);
            student.get().setStatus(status);
            Student savedStudent = studentRepo.save(student.get());
            log.info("Successfully updated student details for id = {}", id);
            return mapper.toDTO(savedStudent);
        } else {
            log.info("Student does not found with id = {}", id);
            return null;
        }
    }

    public void deleteStudentById(Integer id) {
        log.info("Deleting student details by id = {} from database", id);
        studentRepo.deleteById(id);
        log.info("Successfully deleted student details for id = {} from database ", id);
    }
}
