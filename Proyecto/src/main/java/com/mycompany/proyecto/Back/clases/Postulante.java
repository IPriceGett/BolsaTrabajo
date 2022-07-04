/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto.Back.clases;

import java.util.LinkedList;

/**
 *
 * @author igale
 */
public class Postulante extends Persona {
    private int añosExperiencia;
    private String instituto;
    private int puntaje;
    private int expectativaSueldo;
    

    public Postulante(){
        super();
        this.añosExperiencia = 0;
        this.instituto = "";
        this.puntaje = 0;
        this.expectativaSueldo = 0;
    }
    
    public Postulante (String nombre, String apellido, String rut, String genero, int edad, String correo, String telefono, int experiencia, String instituto, int expectativa){
        super(nombre, apellido, rut, genero, edad, correo, telefono);
        this.añosExperiencia = experiencia;
        this.instituto = instituto;
        this.expectativaSueldo = expectativa;
    }
    
    public void setExperiencia(int num){
        this.añosExperiencia = num;
    }
    
    public void setInstituto(String nombre){
        this.instituto = nombre;
    }
    
    public void setPuntaje(int puntaje){
        this.puntaje = puntaje;
    }
    
    public void setExpectativa(int num){
        this.expectativaSueldo =  num;
    }
    
    public int getExperiencia(){
        return this.añosExperiencia;
    }
    
    public String getInstituto(){
        return this.instituto;
    }
    
    public int getPuntaje(){
        return this.puntaje;
    }

    public int getExpectativa(){
        return this.expectativaSueldo;
    }
    

    public void mostrarInfo(){
        System.out.println(this.getNombre() + " " + this.getApellido() + " | " + this.getRut() + " |           " + this.getPuntaje() + "           |          " + this.getExpectativa());
        return;
    }
    
    public void mostrarParametrosEnumerados(){
        super.mostrarParametrosEnumerados();
        System.out.println("9.- Años de experiencia");
        System.out.println("10.- Instituto educacional");
        System.out.println("11.- Expectativa de sueldo");
    }
    
    public void removeSkill(int index){
        super.removeSkill(index);
    }
}
