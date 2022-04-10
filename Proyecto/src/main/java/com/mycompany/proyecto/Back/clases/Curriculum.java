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

public class Curriculum extends Persona {

    private LinkedList<Skill> skills; 
    private int annosExperiencia;
    private String instituto;
    private int puntaje;

    public Curriculum(int annosExperiencia, String instituto, LinkedList skills, String nombre, String apellido, String rut, String genero, int edad, String correo, String telefono){
        super(nombre, apellido, rut, genero, edad, correo, telefono);
        this.annosExperiencia = annosExperiencia;
        this.instituto = instituto;
        this.skills = skills;
    }

    public Curriculum(int annosExperiencia, String instituto, LinkedList skills){
        super();
        this.annosExperiencia = annosExperiencia;
        this.instituto = instituto;
        this.skills = skills;
    }

    public Curriculum(){
        super();
        this.annosExperiencia = 0;
        this.instituto = "";
        this.skills = new LinkedList<>();
        this.puntaje = 0;
    }
    
    public Curriculum(String nombre, String apellido, String rut,  String genero, int edad, String correo, String telefono, int annosExperiencia, String instituto){
        super(nombre, apellido, rut, genero, edad, correo, telefono);
        this.annosExperiencia = annosExperiencia;
        this.instituto = instituto;
        this.skills = new LinkedList<>();
    }

    public String getInstituto(){
        return this.instituto;
    }

    public int getAnnosExperiencia(){
        return this.annosExperiencia;
    }

    public LinkedList getSkills(){
        return this.skills;
    }

    public int getPuntaje(){
        return this.puntaje;
    }

    public void setInstituto(String instituto){
        this.instituto = instituto;
    }

    public void setAnnosExperiencia(int annosExperiencia){
        this.annosExperiencia = annosExperiencia;
    }

    public void setSkills(LinkedList skills){
        this.skills = skills;
    }

    public void setPuntaje(int puntaje){
        this.puntaje = puntaje;
    }
    
    
    	

}
