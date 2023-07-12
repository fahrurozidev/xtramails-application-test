package com.xtramiles.xtramilesapi.service;

import com.xtramiles.xtramilesapi.dto.StudentDTO;
import com.xtramiles.xtramilesapi.model.Student;

import java.util.List;

public interface StudentService {

    Student create(Student student);
    Student update(Long id, Student student);
    Boolean delete(Long id);
    Student findById(Long id);
    List<Student> findAll();

    StudentDTO mapToDto(Student student);
    Student mapToEntity(StudentDTO studentDTO);

}
