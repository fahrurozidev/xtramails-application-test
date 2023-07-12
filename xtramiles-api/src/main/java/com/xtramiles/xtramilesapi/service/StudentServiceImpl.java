package com.xtramiles.xtramilesapi.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xtramiles.xtramilesapi.dto.StudentDTO;
import com.xtramiles.xtramilesapi.model.Student;
import com.xtramiles.xtramilesapi.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class StudentServiceImpl implements StudentService{

    @Autowired
    StudentRepository studentRepository;

    @Override
    public Student create(Student student) {
        final Student result = studentRepository.save(student);
        return result;
    }

    @Override
    public Student update(Long id, Student student) {
        Student result = findById(id);
        if(result != null){
            result.setFirstName(student.getFirstName());
            result.setLastName(student.getLastName());
            result.setDob(student.getDob());
            return studentRepository.save(result);
        }
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        Student result = findById(id);
        if(result != null){
            studentRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Student findById(Long id) {
        Optional<Student> result = studentRepository.findById(id);
        if(result.isPresent()){
            return result.get();
        }
        return null;
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }


    ObjectMapper mapper = new ObjectMapper();

    @Override
    public StudentDTO mapToDto(Student student) {
        return mapper.convertValue(student, StudentDTO.class);
    }

    @Override
    public Student mapToEntity(StudentDTO studentDTO) {
        return mapper.convertValue(studentDTO, Student.class);
    }
}
