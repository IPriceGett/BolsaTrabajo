/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto.Back.clases;

/**
 *
 * @author igale
 */
public class Trabajador extends Persona {
    private int añosContratado;
    private int sueldo;
    private String posicionDeTrabajo;

    public Trabajador(){
        super();
        this.sueldo = 0;
        this.añosContratado = 0;
        this.posicionDeTrabajo = "nula";
    }
    public int obtenerSueldo(){ 
        return this.sueldo; 
    }
    public String obtenerPosicion(){ 
        return this.posicionDeTrabajo; 
    }
    
    public void mostrarInfo(){
        System.out.println(this.getNombre() + " " + this.getApellido() + " | " + this.getRut() + " | " + añosContratado + " | " + sueldo);
        return;
    }
}
