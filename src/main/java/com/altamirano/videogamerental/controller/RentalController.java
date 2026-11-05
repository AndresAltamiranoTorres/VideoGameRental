/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.altamirano.videogamerental.controller;

import com.altamirano.videogamerental.exception.ValidationException;
import com.altamirano.videogamerental.model.Game;
import com.altamirano.videogamerental.model.Platform;
import com.altamirano.videogamerental.model.PlatformStock;
import com.altamirano.videogamerental.model.Rental;
import com.altamirano.videogamerental.model.User;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Andrés
 */
public class RentalController {

    private List<Rental> rentals;
    private UserController userController;
    private GameController gameController;

    public RentalController(UserController userController, GameController gameController) throws ValidationException {

        if (userController == null) {
            throw new ValidationException("El UserController no puede ser nulo");
        }

        if (gameController == null) {
            throw new ValidationException("El GameController no puede ser nulo");
        }

        this.userController = userController;
        this.gameController = gameController;
        this.rentals = new ArrayList<>();
    }

    /**
     * Metodo para añadir un nuevo alquiler
     *
     * @param user
     * @param game
     * @param platform
     * @throws ValidationException
     */
    public void newRental(User user, Game game, Platform platform) throws ValidationException {

        /**
         * Creamos condicionales por si no eligen algun juego
         */
        if (user == null) {
            throw new ValidationException("Añada un usuario");
        }

        if (game == null) {
            throw new ValidationException("Añada un juego");
        }

        if (platform == null) {
            throw new ValidationException("Añada una plataforma");
        }

        /**
         * Creamos una validación para buscar una plataforma y comprobamos su
         * stock.
         */
        boolean platformFound = false;
        PlatformStock selectedStock = null;

        /**
         * Buscamos la plataforma
         */
        for (PlatformStock platformStock : game.getPlatforms()) {
            if (platformStock.getPlatform().equals(platform)) {

                platformFound = true;
                selectedStock = platformStock;

                break;

            }
        }

        /**
         * Comprobamos si el juego tiene esa plataforma
         *
         */
        if (!platformFound) {
            throw new ValidationException("El juego no está disponible para esta plataforma");
        }

        /**
         * Comprobamos si hay Stock
         */
        if (selectedStock.getStock() <= 0) {
            throw new ValidationException("Tiene 0 unidades disponibles");
        }

        /**
         * Creamos el alquiler
         */
        Rental newRental = new Rental(user, game, platform);
        rentals.add(newRental);

        /**
         * Descontamos una unidad si pasa todas las condiciones y se añade al
         * registro.
         */
        selectedStock.setStock(selectedStock.getStock() - 1);

    }

    /**
     * Obtenemos una copia de la lista de Rental
     */
    public List<Rental> getRentals() {
        return List.copyOf(rentals);
    }
}
