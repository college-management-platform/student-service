
package com.practice.studentservice.mapper;

import com.practice.studentservice.dto.StudentRequestDTO;
import com.practice.studentservice.dto.StudentResponseDTO;
import com.practice.studentservice.entity.Student;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentMapperInterface {

    StudentResponseDTO toDTO(Student student);

    Student toEntity(StudentRequestDTO dto);
}
