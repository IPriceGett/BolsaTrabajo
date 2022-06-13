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
    private int valor; // Valor que tiene cada skill para su area, usado para calcular el puntaje. Para las skills de las personas este valor queda en '0'

    public Skill(String nombre, int valor){
        this.nombre = nombre;
        this.valor = valor;
    }
    
    public Skill(int valor, String nombre){
        this.nombre = nombre;
        this.valor = valor;
    }
    
    public Skill(String nombre){
        this.nombre = nombre;
        this.valor = 0;
    }
    
    public Skill(){
        this.nombre = "";
        this.valor = 0;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public void setValor(int valor){
        this.valor = valor;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public int getValor(){
        return this.valor;
    }
    
    public void mostrarParametrosEnumerados(){
        System.out.println("1.- Nombre");
        System.out.println("2.- Valor");
    }
    
    public void mostrarInfo(){
        System.out.println(this.nombre + "           " + this.valor);
    }

}
