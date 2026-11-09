/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.altamirano.videogamerental.view;

import com.altamirano.videogamerental.model.Rental;
import com.altamirano.videogamerental.controller.GameController;
import com.altamirano.videogamerental.controller.RentalController;
import com.altamirano.videogamerental.controller.UserController;
import com.altamirano.videogamerental.exception.ValidationException;
import com.altamirano.videogamerental.model.Game;
import com.altamirano.videogamerental.model.Platform;
import com.altamirano.videogamerental.model.PlatformStock;
import com.altamirano.videogamerental.model.User;
import javax.swing.JOptionPane;

/**
 *
 * @author Andrés
 */
public class DialogNewRental extends javax.swing.JDialog {

    /**
     * Creates new form DialogNewRentral
     */
    private GameController gameController;
    private UserController userController;
    private RentalController rentalController;

    public DialogNewRental(java.awt.Frame parent, boolean modal, UserController userController, GameController gameController, RentalController rentalController) {
        super(parent, modal);
        initComponents();

        this.userController = userController;
        this.gameController = gameController;
        this.rentalController = rentalController;

        /**
         * Obtenemos el numero del registro y le quitamos que lo modifiquen el
         * Field
         */
        fieldNumberRegister.setText(String.valueOf(Rental.getNextId()));
        fieldNumberRegister.setEditable(false);

        /**
         * Obtenemos la fecha inicio y de entrega y quitamos que puedan
         * modificar el Field
         */
        fieldDateStart.setText(
                java.time.LocalDate.now().toString()
        );

        fieldDateEnd.setText(
                java.time.LocalDate.now().plusDays(3).toString()
        );

        fieldDateStart.setEditable(false);
        fieldDateEnd.setEditable(false);

        cargarUsers();
        cargarGames();

    }

    /**
     * Metodo para generar todos los Usuarios Existentes
     */
    public void cargarUsers() {

        comboBoxUser.removeAllItems();

        for (User user : userController.getUsers()) {

            comboBoxUser.addItem(user);
        }

    }

    /**
     * Metodo para generar todos los juegos existentes
     */
    public void cargarGames() {
        comboBoxGame.removeAllItems();

        for (Game game : gameController.getGames()) {
            comboBoxGame.addItem(game);
        }
    }

    /**
     * Metodo para que se actualicen los datos segun el juego
     */
    private void actualizarPlataformas() {
        buttonGroupPlatform.clearSelection();
        Game game = (Game) comboBoxGame.getSelectedItem();

        if (game == null) {
            return;
        }

        // Desactivamos las plataforma principalmente
        radioPc.setEnabled(false);
        radioPs5.setEnabled(false);
        radioXbox.setEnabled(false);
        radioSwitch2.setEnabled(false);

        labelPc.setText("0 unidades");
        labelPs5.setText("0 unidades");
        labelXbox.setText("0 unidades");
        labelSwitch2.setText("0 unidades");

        // Recorremos las plataformas del juego Seleccionado
        for (PlatformStock stock : game.getPlatforms()) {

            int unidades = stock.getStock();

            switch (stock.getPlatform()) {

                case PC:
                    labelPc.setText(unidades + " unidades disponibles");
                    radioPc.setEnabled(unidades > 0);
                    break;
                case PS5:
                    labelPs5.setText(unidades + " unidades disponibles");
                    radioPs5.setEnabled(unidades > 0);
                    break;
                case XBOX:
                    labelXbox.setText(unidades + " unidades disponibles");
                    radioXbox.setEnabled(unidades > 0);
                    break;
                case SWITCH_2:
                    labelSwitch2.setText(unidades + " unidades disponibles");
                    radioSwitch2.setEnabled(unidades > 0);
                    break;
            }
        }

    }

    /**
     * Metodo que actualice la informacion del juego
     */
    public void actualizarInformacionJuego() {
        Game game = (Game) comboBoxGame.getSelectedItem();

        if (game == null) {
            return;
        }

        //Monstramos el genero
        labelGenre.setText(game.getGenre().toString());

        //Monstramos valores iniciales
        labelInfoPc.setText("PC:    0 unidades");
        labelInfoPs5.setText("PS5:   0 unidades");
        labelInfoXbox.setText("Xbox:    0 unidades");
        labelInfoSwitch.setText("Switch 2:   0 unidades");

        //Recorremos las plataforma del juego
        for (PlatformStock stock : game.getPlatforms()) {

            switch (stock.getPlatform()) {
                case PC:
                    labelInfoPc.setText("PC:    " + stock.getStock() + " unidades");
                    break;

                case PS5:
                    labelInfoPs5.setText("PS5:  " + stock.getStock() + " unidades");
                    break;

                case XBOX:
                    labelInfoXbox.setText("Xbox:    " + stock.getStock() + " unidades");
                    break;

                case SWITCH_2:
                    labelInfoSwitch.setText("Switch 2:  " + stock.getStock() + " unidades");
                    break;
            }
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupPlatform = new javax.swing.ButtonGroup();
        mainPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        fieldNumberRegister = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        comboBoxUser = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        comboBoxGame = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        fieldDateStart = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        fieldDateEnd = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        radioPc = new javax.swing.JRadioButton();
        radioPs5 = new javax.swing.JRadioButton();
        radioXbox = new javax.swing.JRadioButton();
        radioSwitch2 = new javax.swing.JRadioButton();
        labelPc = new javax.swing.JLabel();
        labelPs5 = new javax.swing.JLabel();
        labelXbox = new javax.swing.JLabel();
        labelSwitch2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        labelGenre = new javax.swing.JLabel();
        labelInfoPc = new javax.swing.JLabel();
        labelInfoPs5 = new javax.swing.JLabel();
        labelInfoXbox = new javax.swing.JLabel();
        labelInfoSwitch = new javax.swing.JLabel();
        buttonAdd = new javax.swing.JButton();
        butttonDeleted = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del juego"));

        jLabel1.setText("Nº Registro");

        fieldNumberRegister.setEnabled(false);

        jLabel2.setText("Usuario:");

        jLabel3.setText("Juego:");

        comboBoxGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxGameActionPerformed(evt);
            }
        });

        jLabel4.setText("Data Inicio:");

        fieldDateStart.setEnabled(false);
        fieldDateStart.setFocusable(false);
        fieldDateStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldDateStartActionPerformed(evt);
            }
        });

        jLabel5.setText("Data Retorno");

        fieldDateEnd.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fieldNumberRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(fieldDateEnd, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(fieldDateStart, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(comboBoxGame, javax.swing.GroupLayout.Alignment.LEADING, 0, 169, Short.MAX_VALUE)
                        .addComponent(comboBoxUser, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(fieldNumberRegister, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboBoxUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(comboBoxGame, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldDateStart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(fieldDateEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Plataforma"));

        buttonGroupPlatform.add(radioPc);
        radioPc.setText("PC");

        buttonGroupPlatform.add(radioPs5);
        radioPs5.setText("PS5");

        buttonGroupPlatform.add(radioXbox);
        radioXbox.setText("Xbox");

        buttonGroupPlatform.add(radioSwitch2);
        radioSwitch2.setText("Switch 2");

        labelPc.setText("unidades");

        labelPs5.setText("unidades");

        labelXbox.setText("unidades");

        labelSwitch2.setText("unidades");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(radioSwitch2)
                        .addGap(18, 18, 18)
                        .addComponent(labelSwitch2, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(radioPc)
                            .addComponent(radioPs5)
                            .addComponent(radioXbox))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(labelPc, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                            .addComponent(labelPs5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelXbox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radioPc)
                    .addComponent(labelPc))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radioPs5)
                    .addComponent(labelPs5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radioXbox)
                    .addComponent(labelXbox))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radioSwitch2)
                    .addComponent(labelSwitch2))
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Informacion del juego"));

        jLabel6.setText("Genero: ");

        jLabel7.setText("Unidad Disponible");

        labelGenre.setText("jLabel8");

        labelInfoPc.setText("Pc: ");

        labelInfoPs5.setText("PS5: ");

        labelInfoXbox.setText("Xbox:");

        labelInfoSwitch.setText("Switch2 ");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(labelGenre, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelInfoPc, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(labelInfoPs5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelInfoSwitch, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                        .addComponent(labelInfoXbox, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelGenre))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelInfoPc)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelInfoPs5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelInfoXbox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelInfoSwitch))
        );

        buttonAdd.setText("Crear");
        buttonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddActionPerformed(evt);
            }
        });

        butttonDeleted.setText("Cancelar");
        butttonDeleted.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butttonDeletedActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(buttonAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(butttonDeleted, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(buttonAdd, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                            .addComponent(butttonDeleted, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(13, 13, 13)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void butttonDeletedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butttonDeletedActionPerformed
        // TODO add your handling code here:

        this.dispose();
    }//GEN-LAST:event_butttonDeletedActionPerformed

    private void fieldDateStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldDateStartActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldDateStartActionPerformed

    private void comboBoxGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxGameActionPerformed
        // TODO add your handling code here:
        actualizarPlataformas();
        actualizarInformacionJuego();
    }//GEN-LAST:event_comboBoxGameActionPerformed

    private void buttonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddActionPerformed
        // TODO add your handling code here:

        //Obtenemos los usuarios
        User user = (User) comboBoxUser.getSelectedItem();
        Game game = (Game) comboBoxGame.getSelectedItem();

        //Obtenemos la plataforma Seleccionada
        Platform platform = null;

        if (radioPc.isSelected()) {
            platform = Platform.PC;

        } else if (radioPs5.isSelected()) {
            platform = Platform.PS5;

        } else if (radioXbox.isSelected()) {
            platform = Platform.XBOX;

        } else if (radioSwitch2.isSelected()) {
            platform = Platform.SWITCH_2;
        }

        // Hacemos condicionales para verificar que se ha selecionado los datos
        try {

            if (user == null) {
                throw new ValidationException("Seleccione un usuario");
            }

            if (game == null) {
                throw new ValidationException("Seleccione un juego");
            }

            if (platform == null) {
                throw new ValidationException("Seleccione una plataforma");
            }

            // Creamos el alquiler
            rentalController.newRental(user, game, platform);

            JOptionPane.showMessageDialog(
                    this,
                    "Alquiler registrado correctamente"
            );

            this.dispose();

        } catch (ValidationException e) {

            JOptionPane.showMessageDialog(
                    this,
                    e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }

    }//GEN-LAST:event_buttonAddActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAdd;
    private javax.swing.ButtonGroup buttonGroupPlatform;
    private javax.swing.JButton butttonDeleted;
    private javax.swing.JComboBox<Game> comboBoxGame;
    private javax.swing.JComboBox<User> comboBoxUser;
    private javax.swing.JTextField fieldDateEnd;
    private javax.swing.JTextField fieldDateStart;
    private javax.swing.JTextField fieldNumberRegister;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel labelGenre;
    private javax.swing.JLabel labelInfoPc;
    private javax.swing.JLabel labelInfoPs5;
    private javax.swing.JLabel labelInfoSwitch;
    private javax.swing.JLabel labelInfoXbox;
    private javax.swing.JLabel labelPc;
    private javax.swing.JLabel labelPs5;
    private javax.swing.JLabel labelSwitch2;
    private javax.swing.JLabel labelXbox;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JRadioButton radioPc;
    private javax.swing.JRadioButton radioPs5;
    private javax.swing.JRadioButton radioSwitch2;
    private javax.swing.JRadioButton radioXbox;
    // End of variables declaration//GEN-END:variables
}
