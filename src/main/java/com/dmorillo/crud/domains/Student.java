package com.dmorillo.crud.domains;


import com.dmorillo.crud.models.StudentDTO;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.NaturalId;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String first_name;
    private String last_name;
    @NaturalId(mutable = true)
    private String email;
    private String department;

    public StudentDTO toDTO(){
        return StudentDTO.builder()
                .id(id)
                .first_name(first_name)
                .last_name(last_name)
                .email(email)
                .department(department)
                .build();
    }

}
