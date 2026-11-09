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
public class Rental {

    private int numberId;
    private static int nextId = 1;
    private User user;
    private Game game;
    private Platform platform;
    private LocalDate dateStart;
    private LocalDate dateEnd;
    private RentalStatus status;

    public Rental(User user, Game game, Platform platform) throws ValidationException {

        if (user == null) {
            throw new ValidationException("El usuario es obligatorio");
        }
        if (game == null) {
            throw new ValidationException("El juego es obligatorio");
        }

        if (platform == null) {
            throw new ValidationException("La plataforma es obligatorio");
        }

        this.user = user;
        this.game = game;
        this.platform = platform;
        this.dateStart = LocalDate.now();
        this.dateEnd = this.dateStart.plusDays(3);
        this.numberId = nextId++;
        this.status = RentalStatus.ACTIVE;

    }

    /**
     * Getter/Setter
     */
    public int getNumberId() {
        return numberId;
    }

    public User getUser() {
        return user;
    }

    public Game getGame() {
        return game;
    }

    public Platform getPlatform() {
        return platform;
    }

    public LocalDate getDateStart() {
        return dateStart;
    }

    public LocalDate getDateEnd() {
        return dateEnd;
    }

    public RentalStatus getStatus() {
        return status;
    }

    public static int getNextId() {
        return nextId;
    }

    /**
     * Verificaremos si esta alquilado o no, en caso de que no, pasa el estado a
     * Retornado
     *
     * @throws ValidationException
     */
    public void markAsReturned() throws ValidationException {

        if (status != RentalStatus.ACTIVE) {
            throw new ValidationException("El alquiler ya ha sido devuelto");
        }

        this.status = RentalStatus.RETURNED;
    }

}
