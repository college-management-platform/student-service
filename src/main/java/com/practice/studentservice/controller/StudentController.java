package com.practice.studentservice.controller;

import com.practice.studentservice.dto.StudentRequestDTO;
import com.practice.studentservice.dto.StudentResponseDTO;
import com.practice.studentservice.entity.StudentStatus;
import com.practice.studentservice.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequestMapping("/students")
@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/addStudent")
    public ResponseEntity<StudentResponseDTO> addStudent(@RequestBody StudentRequestDTO studentRequestDTO) {
        log.info("Adding student details");
        StudentResponseDTO studentResponseDTO = studentService.addStudent(studentRequestDTO);
        return new ResponseEntity<>(studentResponseDTO, HttpStatus.CREATED);
    }

    @GetMapping("/getStudents")
    public ResponseEntity<List<StudentResponseDTO>> getAllStudents() {
        log.info("Fetching all students details");
        List<StudentResponseDTO> studentsList = studentService.getAllStudents();
        return new ResponseEntity<>(studentsList, HttpStatus.OK);
    }

    @GetMapping("/getStudent/{id}")
    public ResponseEntity<StudentResponseDTO> getStudentById(@PathVariable Integer id) {
        log.info("Fetching student details by id = {}", id);
        StudentResponseDTO studentResponseDTO = studentService.getStudentById(id);
        HttpStatusCode httpStatusCode = HttpStatus.FOUND;
        if(studentResponseDTO == null){
            httpStatusCode = HttpStatus.NOT_FOUND;
        }
        return new ResponseEntity<>(studentResponseDTO, httpStatusCode);
    }

    @PatchMapping("/updateStudent/{id}/status")
    public ResponseEntity<StudentResponseDTO> updateStudent(@PathVariable int id, @RequestParam StudentStatus status) {
        log.info("Updating student details for id = {}", id);
        StudentResponseDTO studentResponseDTO = studentService.updateStudentStatusById(id, status);
        return new ResponseEntity<>(studentResponseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/deleteStudent/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable int id) {
        log.info("Deleting student details for id = {}", id);
        studentService.deleteStudentById(id);
        String msg = "Student details successfully deleted with id = " + id;
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }
}
