package com.dmorillo.crud.repositories;

import com.dmorillo.crud.domains.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IStudentRepository extends JpaRepository<Student, Long> {

    Optional<Student> findByEmail(String email);
}
