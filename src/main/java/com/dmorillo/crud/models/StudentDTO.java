package com.dmorillo.crud.models;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class StudentDTO {
    private Long id;
    private String first_name;
    private String last_name;
    private String email;
    private String department;
}
