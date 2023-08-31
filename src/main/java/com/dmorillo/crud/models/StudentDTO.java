package com.dmorillo.crud.models;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class StudentDTO {
    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private String department;
}
