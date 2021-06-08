package com.in28minutes.springboot.rest.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.in28minutes.springboot.rest.example.controller.StudentController;
import com.in28minutes.springboot.rest.example.model.Student;
import com.in28minutes.springboot.rest.example.repository.StudentRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(StudentController.class)
public class StudentControllerTests {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private StudentRepository studentRepository;

    @Test
    public void listAllStudentsWhenMethodGet() throws Exception {

        Student student1 = new Student(1L, "Pepe", "12345");
        Student student2 = new Student(2L, "Maria", "54321");

        List<Student> listAllStudents = Arrays.asList(student1, student2);

        given(studentRepository.findAll())
                .willReturn(listAllStudents);

        mvc.perform(get("/students"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].name", is(student1.getName())));
    }

    @Test
    public void studentNotExistByIdWhenMethodGet() throws Exception {

        Student studentTest = new Student(1L, "Pepe", "12345");

        given(studentRepository.findById(studentTest.getId())).willThrow(new ArrayIndexOutOfBoundsException());

        mvc.perform(get("/students/1" + studentTest.getId().toString()))
                .andExpect(status().isNotFound());

    }

    @Test
    public void createStudentsWhenMethodPost() throws Exception {

        Student studentTest = new Student(1L, "Pepe", "12345");

        given(studentRepository.save(ArgumentMatchers.any(Student.class))).willReturn(studentTest);

        String jsonBody = "{\"id\": 1,\"name\": \"Maria\", \"passportNumber\": \"45679989\"}";

        mvc.perform(post("/students")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonBody)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());

    }

}


