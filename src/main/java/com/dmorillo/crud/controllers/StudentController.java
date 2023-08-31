package com.dmorillo.crud.controllers;


import com.dmorillo.crud.domains.Student;
import com.dmorillo.crud.models.StudentDTO;
import com.dmorillo.crud.services.StudentService;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:3000")
@RestController
@RequiredArgsConstructor
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;

    /*
       Get all students

       Request: GET
       URL: http://localhost:8080/api/v1/student/
       BODY: (empty)
    */

    @GetMapping
    public ResponseEntity<List<StudentDTO>> getAllStudents(){
        List<StudentDTO> students = studentService.getAllStudents();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    /*
       Get a student by id

       Request: GET
       URL: http://localhost:8080/api/v1/student/1
       BODY: (empty)
    */

    @GetMapping("{id}")
    public ResponseEntity<StudentDTO> getStudentById(@PathVariable Long id){
        StudentDTO student = studentService.getStudentById(idStudent);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

        /*
       Find a student by email

       Request: GET
       URL: http://localhost:8080/api/v1/student/email?email=example@mail.com
       BODY: (empty)
    */

    @GetMapping("email")
    public ResponseEntity<StudentDTO> getStudentByEmail(@PathParam("email") String email){
        StudentDTO student = studentService.getStudentByEmail(email);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    /*
       Create a student

       Request: POST
       URL: http://localhost:8080/api/v1/student/
       BODY: (JSON)
    */


    @PostMapping
    public ResponseEntity<StudentDTO> createStudent(@RequestBody Student student){
        StudentDTO stc = studentService.addStudent(student);
        return new ResponseEntity<>(stc, HttpStatus.CREATED);
    }

    /*
       Update a student by id
       Request: PUT
       URL: http://localhost:8080/api/v1/student/{id}
       BODY: (JSON)
    */

    @PutMapping("/update/{id}")
    public ResponseEntity<StudentDTO> updateStudent(@PathVariable Long id, @RequestBody Student student){
        student.setId(student.getId());
        StudentDTO updatedStudent = studentService.updateStudent(student);
        return new ResponseEntity<>(updatedStudent, HttpStatus.OK);
    }

    /*
       Delete a student by id

       Request: DELETE
       URL: http://localhost:8080/api/v1/student/{id}
       BODY: (empty)
    */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStudentById(@PathVariable Long id){
        studentService.deleteStudentById(id);
        return new ResponseEntity<>("Student successfully deleted", HttpStatus.OK);
    }
}
