/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.proyecto.Back.clases;

/**
 *
 * @author Ignacio
 */

import java.util.LinkedList;

public class Empresa {

    private String nombre;
    private LinkedList areas;

    public Empresa(String nombre, LinkedList areas){
        this.nombre = nombre;
        this.areas = areas;
    }

    public Empresa(){
        this.nombre = "";
        this.areas = new LinkedList();
    }

    public String getNombre(){
        return this.nombre;
    }

    public Area getArea(int indice){
        return (Area)  this.areas.get(indice);
    }

    public LinkedList getAreas(){
        return this.areas;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setAreas(LinkedList areas){
        this.areas = areas;
    }

}
