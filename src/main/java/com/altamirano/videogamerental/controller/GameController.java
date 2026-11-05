/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.altamirano.videogamerental.controller;

import com.altamirano.videogamerental.exception.ValidationException;
import com.altamirano.videogamerental.model.Game;
import com.altamirano.videogamerental.model.Genre;
import com.altamirano.videogamerental.model.PlatformStock;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Andrés
 */
public class GameController {

    private List<Game> games;

    public GameController() {
        this.games = new ArrayList<>();
    }

    /**
     * Metodo para añadir juegos
     */
    public void newGame(String name, Genre genre, List<PlatformStock> platforms) throws ValidationException {

        Game newGame = new Game(name, genre, platforms);
        games.add(newGame);

    }

    /**
     * Metodo para obtener una copia de lista de los juegos
     */
    public List<Game> getGames() {
        return List.copyOf(games);
    }

    /**
     * Metodo para eliminar un juego que no este alquilado
     */
    public void deleteGame(Game game) throws ValidationException {

        if (game == null) {
            throw new ValidationException("Debes eliminar un juego");
        }

        if (!games.remove(game)) {
            throw new ValidationException("El juego no existe");
        }

    }

}
