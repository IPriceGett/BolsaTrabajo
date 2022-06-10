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
public abstract class Persona {
    private String nombre;
    private String apellido;
    private String rut;
    private String genero;
    private int edad;
    private String correo;
    private String telefono;
    private LinkedList<Skill> skills; 

    public Persona(String nombre, String apellido, String rut, String genero, int edad, String correo, String telefono){
        this.nombre = nombre;
        this.apellido = apellido;
        this.rut = rut;
        this.genero = genero;
        this.edad = edad;
        this.correo = correo;
        this.telefono = telefono;
        this.skills = new LinkedList<Skill>();
    }

    public Persona(){
        this.nombre = "";
        this.apellido = "";
        this.rut = "";
        this.genero = "";
        this.edad = 1;
        this.correo = "";
        this.telefono = "";
        this.skills = new LinkedList<Skill>();
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public void setApellido(String apellido){
        this.apellido = apellido;
    }

    public void setRut(String rut){
        this.rut = rut;
    }

    public void setGenero(String genero){
        this.genero = genero;
    }

    public void setEdad(int edad){
        this.edad = edad;
    }

    public void setCorreo(String correo){
        this.correo = correo;
    }

    public void setTelefono(String telefono){
        this.telefono = telefono;
    }
    
    public void setSkill(Skill skill){
        this.skills.add(skill);
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public String getApellido(){
        return this.apellido;
    }
    
    public String getRut(){
        return this.rut;
    }
    
    public String getGenero(){
        return this.genero;
    }
    
    public int getEdad(){
        return this.edad;
    }
    
    public String getCorreo(){
        return this.correo;
    }
    
    public String getTelefono(){
        return this.telefono;
    }
    
    public Skill getSkill(int index){
        return this.skills.get(index);
    }
    
    public int getLargoSkills(){
        return this.skills.size();
    }
    
    public void mostrarInfo(){
        System.out.println(this.getNombre() + " " + this.getApellido() + " | " + this.getRut());
        return;
    }
}
