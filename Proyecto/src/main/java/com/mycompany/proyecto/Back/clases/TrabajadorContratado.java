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
public class TrabajadorContratado extends Trabajador {
    private int añosContratado;
    private int sueldo;
    private String posicionDeTrabajo;

    public TrabajadorContratado(){
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
    
    public void mostrarInfoTrabajador(){
        System.out.println(this.getNombre() + " " + this.getApellido() + " | " + this.getRut() + " |           " + this.getPuntaje() + "           |          " + añosContratado + " | " + sueldo);
        return;
    }
}
