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

public abstract class Trabajador extends Persona {

    private LinkedList<Skill> skills; 
    private int añosExperiencia;
    private String instituto;
    private int puntaje;

    public Trabajador(int añosExperiencia, String instituto, LinkedList skills, String nombre, String apellido, String rut, String genero, int edad, String correo, String telefono){
        super(nombre, apellido, rut, genero, edad, correo, telefono);
        this.añosExperiencia = añosExperiencia;
        this.instituto = instituto;
        this.skills = skills;
    }

    public Trabajador(int annosExperiencia, String instituto, LinkedList skills){
        super();
        this.añosExperiencia = annosExperiencia;
        this.instituto = instituto;
        this.skills = skills;
    }

    public Trabajador(){
        super();
        this.añosExperiencia = 0;
        this.instituto = "";
        this.skills = new LinkedList<>();
        this.puntaje = 0;
    }
    
    public Trabajador(String nombre, String apellido, String rut,  String genero, int edad, String correo, String telefono, int annosExperiencia, String instituto){
        super(nombre, apellido, rut, genero, edad, correo, telefono);
        this.añosExperiencia = annosExperiencia;
        this.instituto = instituto;
        this.skills = new LinkedList<>();
    }

    public String getInstituto(){
        return this.instituto;
    }

    public int getAnnosExperiencia(){
        return this.añosExperiencia;
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

    public void setAñosExperiencia(int añosExperiencia){
        this.añosExperiencia = añosExperiencia;
    }

    public void setSkills(LinkedList skills){
        this.skills = skills;
    }

    public void setPuntaje(int puntaje){
        this.puntaje = puntaje;
    }
    
    abstract public int obtenerSueldo();
    abstract public String obtenerPosicion();
    
    public void mostrarInfoTrabajador(){
        System.out.println(this.getNombre() + " " + this.getApellido() + " | " + this.getRut() + " |           " + this.getPuntaje());
        return;
    }

}
