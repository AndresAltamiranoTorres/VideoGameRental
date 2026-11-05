/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.altamirano.videogamerental.controller;

import com.altamirano.videogamerental.exception.ValidationException;
import com.altamirano.videogamerental.model.User;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Andrés
 */
public class UserController {

    private List<User> users;

    public UserController() {
        this.users = new ArrayList<>();
    }

    /**
     * Creamos metodo para añadir usuarios Hacemos validacion con For-Each para
     * validar que no haya usuarios con el mismo DNI;
     */
    public void newUser(String name, String lastname, String surname, String dni, String phone) throws ValidationException {

        for (User user : users) {
            String dniRepetido = user.getDni();
            if (dniRepetido.equalsIgnoreCase(dni)) {
                throw new ValidationException("El Usuario ya existe");
            }
        }

        User newUser = new User(name, lastname, surname, dni, phone);
        users.add(newUser);

    }

    /**
     * Metodo para obtener los usuarios de la lista.
     *
     * @return una copia de la lista.
     */
    public List<User> getUsers() {

        return List.copyOf(users);

    }

    /**
     * Metodo para eliminar Usuaios
     */
    public void deleteUser(User user) throws ValidationException {

        if (user == null) {
            throw new ValidationException("Debes eliminar un usuario");
        }

        if (!users.remove(user)) {
            throw new ValidationException("El usuario no existe");
        }

    }

}
