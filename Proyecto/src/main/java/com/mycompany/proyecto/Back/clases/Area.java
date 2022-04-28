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

import java.util.HashMap;
import java.util.LinkedList;

public class Area {

    private String nombre;
    private int vacantes;
    private int total;
    private LinkedList<Skill> skills; //  falta eliminar y editar
    private HashMap contratados; //mapa 
    private LinkedList<Curriculum> postulantes; //Lista de postulantes a la correspondiente area, ordenados de mayor a menor por su puntaje de postulacion. listo eliminar falta editar

    public Area(){
        this.nombre = "";
        this.vacantes = 1;
        this.total = 1;
        this.skills = new LinkedList<>();
        this.contratados = new HashMap();
        this.postulantes = new LinkedList<>();  
    }

    public Area(String nombre, int vacantes, int total, LinkedList skills, HashMap contratados, LinkedList postulantes){
        this.nombre = nombre;
        this.vacantes = vacantes;
        this.total = total;
        this.skills = skills;
        this.contratados = contratados;
        this.postulantes = postulantes;  
    }
    
    public Area(String nombre, int vacantes, int total){
        this.nombre = nombre;
        this.vacantes = vacantes;
        this.total = total;
        this.skills = new LinkedList<>();
        this.contratados = new HashMap();
        this.postulantes = new LinkedList<>();  
    }
    
    public Area(String nombre, int total, LinkedList lista){
        this.nombre = nombre;
        this.vacantes = total;
        this.total = total;
        this.skills = lista;
        this.contratados = new HashMap();
        this.postulantes = new LinkedList<>();  
    }

   
    public String getNombre(){
        return this.nombre;
    }

    public int getVacantes(){
        return this.vacantes;
    }

    public LinkedList getSkills(){
        return this.skills;
    }

    public Skill getSkill(int numeroSkill){
        return (Skill) this.skills.get(numeroSkill);
    }

    public LinkedList getPostulantes(){
        return this.postulantes;
    }

    public HashMap getContratados(){
        return this.contratados;
    }

    public int getPuestosTotales(){
        return this.total;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setVacantes(int vacantes){
        this.vacantes = vacantes;
    }

    public void setSkills(LinkedList skills){
        this.skills = skills;
    }

    public void setContratados(HashMap contratados){
        this.contratados = contratados;
    }

    public void setPostulantes(Curriculum postulante){
        this.postulantes.add(postulante);
    }

}
