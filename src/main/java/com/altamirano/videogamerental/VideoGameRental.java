/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.altamirano.videogamerental;

import com.altamirano.videogamerental.controller.GameController;
import com.altamirano.videogamerental.controller.RentalController;
import com.altamirano.videogamerental.controller.UserController;
import com.altamirano.videogamerental.exception.ValidationException;
import com.altamirano.videogamerental.model.Game;
import com.altamirano.videogamerental.model.Genre;
import com.altamirano.videogamerental.model.Platform;
import com.altamirano.videogamerental.model.PlatformStock;
import com.altamirano.videogamerental.model.Rental;
import com.altamirano.videogamerental.model.RentalStatus;
import com.altamirano.videogamerental.model.User;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Andrés
 */
public class VideoGameRental {

    public static void main(String[] args) throws ValidationException {

        UserController userController = new UserController();

        GameController gameController = new GameController();

        RentalController rentalController
                = new RentalController(userController, gameController);

        // Usuarios
        userController.newUser("Andres", "Altamirano", "Torres",
                "12345678A", "600123456");

        userController.newUser("Laura", "Garcia", "Lopez",
                "87654321B", "600987654");

        // Plataformas del primer juego
        List<PlatformStock> platforms1 = new ArrayList<>();

        platforms1.add(new PlatformStock(Platform.PS5, 5));
        platforms1.add(new PlatformStock(Platform.PC, 3));

        // Primer juego
        gameController.newGame("Cyberpunk 2077", Genre.RPG, platforms1);

        List<PlatformStock> platforms2 = new ArrayList<>();

        platforms2.add(new PlatformStock(Platform.XBOX, 4));
        platforms2.add(new PlatformStock(Platform.SWITCH_2, 2));

        gameController.newGame("Minecraft", Genre.ADVENTURE, platforms2);

        System.out.println("===== USUARIOS =====");

        for (User user : userController.getUsers()) {
            System.out.println(user.getName() + " "
                    + user.getLastname() + " "
                    + user.getSurname()
                    + " | DNI: " + user.getDni()
                    + " | Teléfono: " + user.getPhone());
        }

        System.out.println("\n===== JUEGOS =====");

        for (Game game : gameController.getGames()) {
            System.out.println("Juego: " + game.getName());
            System.out.println("Género: " + game.getGenre());

            for (PlatformStock stock : game.getPlatforms()) {
                System.out.println("Plataforma: " + stock.getPlatform()
                        + " | Stock: " + stock.getStock());
            }

            System.out.println("--------------------");
        }
        // Obtenemos el primer usuario y el primer juego
        User user = userController.getUsers().get(0);
        Game game = gameController.getGames().get(0);

// Consultamos el stock inicial
        System.out.println("Stock antes del alquiler:");

        for (PlatformStock stock : game.getPlatforms()) {
            System.out.println(stock.getPlatform() + ": " + stock.getStock());
        }

// Creamos el alquiler
        rentalController.newRental(user, game, Platform.PS5);

// Consultamos el stock después del alquiler
        System.out.println("\nStock después del alquiler:");

        for (PlatformStock stock : game.getPlatforms()) {
            System.out.println(stock.getPlatform() + ": " + stock.getStock());
        }

        System.out.println("\nLista de alquileres:");

        for (Rental rental : rentalController.getRentals()) {
            System.out.println(
                    "ID: " + rental.getNumberId()
                    + " | Usuario: " + rental.getUser().getName()
                    + " | Juego: " + rental.getGame().getName()
                    + " | Plataforma: " + rental.getPlatform()
                    + " | Estado: " + rental.getStatus()
            );
        }

        Rental rental = rentalController.getRentals().get(0);

        rentalController.returnRental(rental);

        System.out.println("\nStock después de devolver:");

        for (PlatformStock stock : game.getPlatforms()) {
            System.out.println(stock.getPlatform() + ": " + stock.getStock());
        }

        try {
            rentalController.returnRental(rental);
        } catch (ValidationException e) {
            System.out.println("Error: " + e.getMessage());
        }

// Alquilamos las 5 unidades disponibles
        for (int i = 0; i < 5; i++) {
            rentalController.newRental(user, game, Platform.PS5);
        }

        System.out.println("Stock PS5 después de alquilar: "
                + game.getPlatforms().get(0).getStock());

        try {
            rentalController.newRental(user, game, Platform.PS5);
        } catch (ValidationException e) {
            System.out.println("Error: " + e.getMessage());
        }

        for (Rental r : rentalController.getRentals()) {
            if (r.getStatus() == RentalStatus.ACTIVE) {
                rentalController.returnRental(r);
            }
        }
        System.out.println("\n===== PRUEBA 1: PLATAFORMA INEXISTENTE =====");

        try {
            rentalController.newRental(user, game, Platform.XBOX);
        } catch (ValidationException e) {
            System.out.println("Error esperado: " + e.getMessage());
        }

        System.out.println("\n===== PRUEBA 2: ELIMINAR USUARIO CON ALQUILER ACTIVO =====");

        rentalController.newRental(user, game, Platform.PS5);

        if (rentalController.hasActiveRentalForUser(user)) {
            System.out.println("No se puede eliminar: el usuario tiene alquileres activos");
        } else {
            userController.deleteUser(user);
        }

        System.out.println("\n===== PRUEBA 3: ELIMINAR JUEGO CON ALQUILER ACTIVO =====");

        if (rentalController.hasActiveRentalForGame(game)) {
            System.out.println("No se puede eliminar: el juego tiene alquileres activos");
        } else {
            gameController.deleteGame(game);
        }

        System.out.println("\n===== PRUEBA 4: DEVOLVER Y ELIMINAR =====");

        for (Rental r : rentalController.getRentals()) {
            if (r.getStatus() == RentalStatus.ACTIVE
                    && (r.getUser().equals(user) || r.getGame().equals(game))) {
                rentalController.returnRental(r);
            }
        }

        if (!rentalController.hasActiveRentalForUser(user)) {
            userController.deleteUser(user);
            System.out.println("Usuario eliminado correctamente");
        }

        if (!rentalController.hasActiveRentalForGame(game)) {
            gameController.deleteGame(game);
            System.out.println("Juego eliminado correctamente");
        }

    }
}
