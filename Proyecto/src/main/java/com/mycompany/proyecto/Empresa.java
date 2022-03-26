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
public class Empresa {

    private String nombre;
    private Area[] areas;

    public Empresa(String nombre, Area[] areas){
        this.nombre = nombre;
        this.areas = areas;
    }

    public String getNombre(){
        return this.nombre;
    }

    public Area getArea(int indice){
        return this.areas[indice];
    }

    public Area[] getAreas(){
        return this.areas;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setAreas(Area[] areas){
        this.areas = areas;
    }

}
