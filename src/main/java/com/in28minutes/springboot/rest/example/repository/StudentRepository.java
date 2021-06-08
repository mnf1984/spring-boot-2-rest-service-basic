package com.in28minutes.springboot.rest.example.repository;

import com.in28minutes.springboot.rest.example.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

}
