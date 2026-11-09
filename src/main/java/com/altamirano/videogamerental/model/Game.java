/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.altamirano.videogamerental.model;

import com.altamirano.videogamerental.exception.ValidationException;
import java.util.List;

/**
 *
 * @author Andrés
 */
public class Game {

    private int numberId;
    private static int nextId = 1;
    private String name;
    private Genre genre;
    private List<PlatformStock> platforms;

    public Game(String name, Genre genre, List<PlatformStock> platforms) throws ValidationException {

        if (name == null || name.isBlank()) {
            throw new ValidationException("El nombre no puede ser nulo");
        }

        if (genre == null) {
            throw new ValidationException("El genero no puede estar vacio");
        }

        if (platforms == null || platforms.isEmpty()) {
            throw new ValidationException("La plataforma no puede estar vacia");
        }

        this.name = name;
        this.genre = genre;
        this.platforms = List.copyOf(platforms);
        this.numberId = nextId++;
    }

    /**
     * Getter/Setter
     */
    public String getName() {
        return name;
    }

    public Genre getGenre() {
        return genre;
    }

    public List<PlatformStock> getPlatforms() {
        return List.copyOf(platforms);
    }

    public int getNumberId() {
        return numberId;
    }
    
    @Override
    public String toString() {
        return name;
    }

}
