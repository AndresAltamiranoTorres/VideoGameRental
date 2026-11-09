/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.altamirano.videogamerental;

import com.altamirano.videogamerental.exception.ValidationException;
import com.altamirano.videogamerental.view.MainView;
import javax.swing.JOptionPane;

/**
 *
 * @author Andrés
 */
public class VideoGameRental {

    public static void main(String[] args) {

        java.awt.EventQueue.invokeLater(() -> {
            try {
                MainView ventana = new MainView();
                ventana.setVisible(true);

            } catch (ValidationException e) {

                JOptionPane.showMessageDialog(
                        null,
                        e.getMessage(),
                        "Error al iniciar",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        });
    }
}
