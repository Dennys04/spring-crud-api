package com.dmorillo.crud.services;

import com.dmorillo.crud.domains.Student;
import com.dmorillo.crud.models.StudentDTO;

import java.util.List;

public interface IStudentService {

    public StudentDTO addStudent(Student student);
    public StudentDTO getStudentById(Long id);
    public StudentDTO getStudentByEmail(String studentEmail);
    public List<StudentDTO> getAllStudents();
    public StudentDTO updateStudent(Student student);
    public void deleteStudentById(Long id);


}
