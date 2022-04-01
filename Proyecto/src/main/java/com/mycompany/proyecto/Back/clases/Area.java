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

public class Area {

    private String nombre;
    private int vacantes;
    private int total;
    private LinkedList skills;
    private Curriculum[] contratados; //mapa 
    private Curriculum[] postulantes; //mapa

     public Area(){
        this.nombre = "";
        this.vacantes = 1;
        this.total = 1;
        this.skills = new LinkedList();
        this.contratados = new Curriculum[1];
        this.postulantes = new Curriculum[1];  
    }

    public Area(String nombre, int vacantes, int total, LinkedList skills, int maximoPostulantes){
        this.nombre = nombre;
        this.vacantes = vacantes;
        this.total = total;
        this.skills = skills;
        this.contratados = new Curriculum[total];
        this.postulantes = new Curriculum[maximoPostulantes];  
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

    public Curriculum[] getPostulantes(){
        return this.postulantes;
    }

    public Curriculum[] getContratados(){
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

    public void setContratados(Curriculum[] contratados){
        this.contratados = contratados;
    }

    public void setPostulantes(Curriculum[] postulantes){
        this.postulantes = postulantes;
    }

}
