package com.in28minutes.springboot.rest.example;

import com.in28minutes.springboot.rest.example.model.Student;
import com.in28minutes.springboot.rest.example.repository.StudentRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SaveStudentTests {

	@Mock
	private StudentRepository studentRepository;
	
	@Test
	public void saveStudentOk() {
		Student studentTest = new Student(1L,"Pepe", "12345");
		when(studentRepository.save(ArgumentMatchers.any(Student.class))).thenReturn(studentTest);
		Student savedStudent = studentRepository.save(studentTest);

		assertEquals("Pepe", savedStudent.getName());
	}

}
