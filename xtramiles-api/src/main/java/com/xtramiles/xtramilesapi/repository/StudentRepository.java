package com.xtramiles.xtramilesapi.repository;

import com.xtramiles.xtramilesapi.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
