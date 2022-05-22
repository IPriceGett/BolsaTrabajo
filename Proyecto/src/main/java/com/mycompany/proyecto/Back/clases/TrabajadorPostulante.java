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
public class TrabajadorPostulante extends Trabajador {
    private String empresaAnterior;
    private String posicionAnterior;
    private int expectativaSueldo;
    private String motivosDeCambio;

    public TrabajadorPostulante(){
        super();
        this.empresaAnterior = "";
        this.posicionAnterior = "";
        this.expectativaSueldo = 0;
        this.motivosDeCambio = "";
    }
    
    public TrabajadorPostulante(String nombre, String apellido, String rut, String genero, int edad, String correo, String telefono, int experiencia, String instituto, String empresa, String posicion, int expectativa, String motivo){
        super(nombre, apellido, rut, genero, edad, correo, telefono, experiencia, instituto);
        this.empresaAnterior = empresa;
        this.posicionAnterior = posicion;
        this.expectativaSueldo = expectativa;
        this.motivosDeCambio = motivo;
        
    }

    public int obtenerSueldo(){
        return this.expectativaSueldo;
    }

    public String obtenerPosicion(){ 
        return this.posicionAnterior; 
    }
    
    public void mostrarInfoTrabajador(){
        System.out.println(this.getNombre() + " " + this.getApellido() + " | " + this.getRut() + " |           " + this.getPuntaje() + "           |          " + expectativaSueldo);
        return;
    }

}
