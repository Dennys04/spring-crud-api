package com.dmorillo.crud.services;

import com.dmorillo.crud.domains.Student;
import com.dmorillo.crud.exceptions.StudentAlreadyExistsException;
import com.dmorillo.crud.exceptions.StudentNotFoundException;
import com.dmorillo.crud.models.StudentDTO;
import com.dmorillo.crud.repositories.IStudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentService implements IStudentService{

    private final IStudentRepository studentRepository;

    @Override
    public StudentDTO addStudent(Student student) {
        if(studentAlreadyExists(student.getEmail())){
            throw  new StudentAlreadyExistsException(student.getEmail() + " already exists!");
        }
        Student studentCreated = studentRepository.save(student);
        return studentCreated.toDTO();
    }


    @Override
    public StudentDTO getStudentById(Long idStudent) {
        Student student = studentRepository.findById(idStudent)
                .orElseThrow(
                        () -> new StudentNotFoundException("Sorry, Student not found!")
                );
        return student.toDTO();
    }

    @Override
    public StudentDTO getStudentByEmail(String email) {
        Student student = studentRepository.findByEmail(email)
                .orElseThrow(
                        () -> new StudentNotFoundException("Sorry, no student found with this email: " + email)
                );

        return student.toDTO();
    }

    @Override
    public List<StudentDTO> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        return students.stream().map(Student::toDTO).collect(Collectors.toList());
    }

    @Override
    public StudentDTO updateStudent(Student student) {

        Student ostu = studentRepository.findById(student.getId())
                .orElseThrow(
                        () -> new StudentNotFoundException("Sorry, no student found with this id: " + student.getId())
                );

        ostu.setId(student.getId());
        ostu.setFirstname(student.getFirstname());
        ostu.setLastname(student.getLastname());
        ostu.setEmail(student.getEmail());
        ostu.setDepartment(student.getDepartment());

        Student su = studentRepository.save(ostu);

        return su.toDTO();
    }

    @Override
    public void deleteStudentById(Long id) {
        if (!studentRepository.existsById(id)){
            throw new StudentNotFoundException("Sorry, student not found!");
        } 
        studentRepository.deleteById(id);
    }


    private boolean studentAlreadyExists(String email) {
        return studentRepository.findByEmail(email).isPresent();
    }

}
