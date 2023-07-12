package com.xtramiles.xtramilesapi.controller;

import com.xtramiles.xtramilesapi.dto.StudentDTO;
import com.xtramiles.xtramilesapi.model.Student;
import com.xtramiles.xtramilesapi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    StudentService studentService;



    @PostMapping("")
    public StudentDTO create(@RequestBody StudentDTO request){
        final Student student = studentService.mapToEntity(request);
        final Student result = studentService.create(student);

        return studentService.mapToDto(result);
    }

    @PutMapping("/{id}")
    public StudentDTO update(@PathVariable Long id, @RequestBody StudentDTO request){
        final Student student = studentService.mapToEntity(request);
        final Student result = studentService.update(id, student);
        return studentService.mapToDto(result);
    }

    @GetMapping("")
    public List<StudentDTO> findAll(){
        return studentService.findAll().stream().map(student -> studentService.mapToDto(student)).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public StudentDTO findById(@PathVariable Long id){
        final Student result = studentService.findById(id);
        return studentService.mapToDto(result);
    }

    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable Long id){
        return studentService.delete(id);
    }
}
