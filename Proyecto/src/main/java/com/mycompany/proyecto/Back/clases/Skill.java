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
    private int id;
    private String nombre;

    public Skill(int id, String nombre){
        this.id = id;
        this.nombre = nombre;
    }
    
     public Skill(String nombre, int id){
        this.id = id;
        this.nombre = nombre;
    }
     
     public Skill(String nombre){
        this.id = 0;
        this.nombre = nombre;
    }
     
    public Skill(){
        this.id = 1;
        this.nombre = "";
    }

    public int getId(){
        return this.id;
    }

    public String getNombre(){
        return this.nombre;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
        //Agregar skills
    
    public void agregarSkill(LinkedList list, int id, String nombre){
        Skill skill = new Skill(id, nombre);
        list.add(skill);
    }
    
    public void agregarSkill(LinkedList list, String nombre, int id){
        Skill skill = new Skill(id, nombre);
        list.add(skill);
    }
    
    public void agregarSkill(String nombre, int id, LinkedList list){
        Skill skill = new Skill(id, nombre);
        list.add(skill);
    }
    
    public void agregarSkill(int id, String nombre, LinkedList list){
        Skill skill = new Skill(id, nombre);
        list.add(skill);
    }
    
    public void agregarSkill(String nombre, LinkedList list){
        Skill skill = new Skill(nombre);
        list.add(skill);
    }

    public void eliminarSkill(LinkedList list){
    }
}
