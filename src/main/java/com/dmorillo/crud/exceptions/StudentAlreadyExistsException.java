package com.dmorillo.crud.exceptions;

public class StudentAlreadyExistsException extends RuntimeException {
    public StudentAlreadyExistsException(String menssage) {
        super(menssage);
    }
}
