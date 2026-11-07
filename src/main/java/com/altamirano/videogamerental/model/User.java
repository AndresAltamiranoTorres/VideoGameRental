/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.altamirano.videogamerental.model;

import com.altamirano.videogamerental.exception.ValidationException;
import java.time.LocalDate;

/**
 *
 * @author Andrés
 */
public class User {

    private String name;
    private String lastname;
    private String surname;
    private String dni;
    private String phone;
    private LocalDate dateRegistrer;

    public User(String name, String lastname, String surname, String dni, String phone) throws ValidationException {

        if (name == null || name.isBlank()) {
            throw new ValidationException("El nombre es obligatorio");
        }

        if (lastname == null || lastname.isBlank()) {
            throw new ValidationException("El primer apellido es obligatorio");
        }

        if (surname == null || surname.isBlank()) {
            throw new ValidationException("El segundo apellido es obligatorio");
        }

        if (dni == null || dni.isBlank()) {
            throw new ValidationException("El DNI es obligatorio");
        }
        
        if(phone == null || phone.isBlank()){
            throw new ValidationException("El Telefono es obligatorio");
        }
        
        this.name = name;
        this.lastname = lastname;
        this.surname = surname;
        this.dni = dni;
        this.phone = phone;
        this.dateRegistrer = LocalDate.now();
    }

    /**
     * Getter/Setter
     */
    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getSurname() {
        return surname;
    }

    public String getDni() {
        return dni;
    }

    public String getPhone() {
        return phone;
    }

    public LocalDate getDateRegister() {
        return dateRegistrer;
    }

}
