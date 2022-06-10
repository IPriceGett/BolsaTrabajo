/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.proyecto.Back.clases;

import java.util.LinkedList;

/**
 *
 * @author Ignacio
 */
public class Skill {
    private String nombre;

    public Skill(String nombre){
        this.nombre = nombre;
    }
    
    public Skill(){
        this.nombre = "";
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public String getNombre(){
        return this.nombre;
    }

}
