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

    public int obtenerSueldo(){
        return this.expectativaSueldo;
    }

    public String obtenerPosicion(){ return this.posicionAnterior; }

}
