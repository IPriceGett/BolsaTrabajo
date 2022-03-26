/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.proyecto;

/**
 *
 * @author Ignacio
 */
public class Skill {
    private int id;
    private String nombre;

    public Skill(int id, String nombre){
        this.id = id;
        this.nombre = nombre;
    }

    public int getId(){
        return this.id;
    }

    public String getNombre(){
        return this.nombre;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }
}
