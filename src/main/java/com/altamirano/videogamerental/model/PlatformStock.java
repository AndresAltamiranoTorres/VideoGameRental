/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.altamirano.videogamerental.model;

import com.altamirano.videogamerental.exception.ValidationException;

/**
 *
 * @author Andrés
 *
 * Clase auxiliar para conectar la plataforma y los stocks de los juegos.
 */
public class PlatformStock {

    private Platform platform;
    private int stock;

    public PlatformStock(Platform platform, int stock) throws ValidationException {
        
        if( platform == null ){
            throw new ValidationException("La plataforma no puede ser nula");
        }
        
        if(stock < 0 ){
            throw new ValidationException("El stock no puede ser negativo");
        }
        
        this.platform = platform;
        this.stock = stock;
    }

    /**
     * Getter/Setter
     */
    public Platform getPlatform() {
        return platform;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) throws ValidationException {
        if ( stock < 0 ){
            throw new ValidationException("El stock no puede ser negativo");
        }
        this.stock = stock;
    }
    
}
