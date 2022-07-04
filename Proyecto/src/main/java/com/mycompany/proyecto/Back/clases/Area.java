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
    private LinkedList<Skill> skills;
    private LinkedList<Postulante> postulantes; //Lista de postulantes a la correspondiente area, ordenados de mayor a menor por su puntaje de postulacion. 

    public Area(){
        this.nombre = "";
        this.vacantes = 1;
        this.total = 1;
        this.skills = new LinkedList<Skill>();
        this.postulantes = new LinkedList<Postulante>();  
    }

    public Area(String nombre, int vacantes, int total){
        this.nombre = nombre;
        this.vacantes = vacantes;
        this.total = total;
        this.skills = new LinkedList<Skill>();
        this.postulantes = new LinkedList<Postulante>();  
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setVacantes(int vacantes){
        this.vacantes = vacantes;
    }

    public void setTotal(int num){
       this.total = num;
    }
   
    public void setSkill(Skill skill){
        this.skills.add(skill);
    }

    public void setPostulante(Postulante postulante){
        this.postulantes.add(postulante);
    }

    public String getNombre(){
        return this.nombre;
    }

    public int getVacantes(){
        return this.vacantes;
    }

    public Skill getSkill(int index){
        return this.skills.get(index);
    }

    public int getTotal(){
        return this.total;
    }
    
    public int getLargoSkills(){
        return this.skills.size();
    }
    
    public int getLargoPostulantes(){
        return this.postulantes.size();
    }
    
    public Postulante getPostulante(int index){
        return postulantes.get(index);
    }
    
    public void add(Postulante postulante){
        this.postulantes.add(postulante);
    }
   
    public void removePostulante(int index){
        this.postulantes.remove(index);
    }
    
    public Postulante top(){
        Postulante aux = new Postulante();
        for(int i=0; i< postulantes.size() ; i++ ){
            if(aux.getPuntaje() <= postulantes.get(i).getPuntaje()){
               aux = postulantes.get(i); 
            }
        }
        return aux;
    }

    public Postulante noTop(){
        Postulante aux = new Postulante();
        for(int i=0; i< postulantes.size() ; i++ ){
            if(aux.getPuntaje() >= postulantes.get(i).getPuntaje()){
               aux = postulantes.get(i); 
            }
        }
        return aux;
    }
    
    public Postulante peorExpectativa(){
        Postulante aux = new Postulante();
        for(int i=0; i< postulantes.size() ; i++ ){
            if(aux.getExpectativa() >= postulantes.get(i).getExpectativa()){
               aux = postulantes.get(i); 
            }
        }
        return aux;
    }

    public Postulante mejorExpectativa(){
        Postulante aux = new Postulante();
        for(int i=0; i< postulantes.size() ; i++ ){
            if(aux.getExpectativa() <= postulantes.get(i).getExpectativa()){
               aux = postulantes.get(i); 
            }
        }
        return aux;
    }
    
    public void mostrarSkills(){
        System.out.println(this.getNombre().toUpperCase());
        System.out.println();
        
        System.out.println("Nombre          |          Valor");
        for (int i = 0; i < this.getLargoSkills(); i++){
                this.skills.get(i).mostrarInfo();
            }
            System.out.println();
    }
    
    public void mostrarPostulantes(){
        System.out.println(this.getNombre().toUpperCase());
     
        System.out.println("Nombre completo        RUT      Puntaje de postulacion     Expectativa de sueldo");

        for (int j = 0; j < this.getLargoPostulantes(); j++){

            this.getPostulante(j).mostrarInfo();
        }
        System.out.println();
    }
    
    public void mostrarSobreXPuntaje(int minimo){
        
        Postulante postulante;
        int cont;
        
        System.out.println(this.getNombre().toUpperCase());
        cont = 0;

        for (int j = 0; j < this.getLargoPostulantes(); j++){
            postulante = this.getPostulante(j);

            if(postulante.getPuntaje() > minimo){
                System.out.println(postulante.getNombre() + " " + postulante.getApellido() + ", " + postulante.getPuntaje() + " puntos.");
                cont++;
            }     
        }

        if(cont == 0)
            System.out.println("No existen postulantes que cumplan el requisito.");
    }
    
    public void sueldoInferiorA(int maximo){
        
        Postulante postulante;
        int cont;
        
        System.out.println(this.getNombre().toUpperCase());
        cont = 0;

        for (int j = 0; j < this.getLargoPostulantes(); j++){
            postulante = this.getPostulante(j);

            if(postulante.getExpectativa() < maximo){
                System.out.println(postulante.getNombre() + " " + postulante.getApellido() + ", con una expectativa de sueldo de " + postulante.getExpectativa());
                cont++;
            }     
        }

        if(cont == 0)
            System.out.println("No existen postulantes que cumplan el requisito.");
    }
    
    public void mostrarParametrosEnumerados(){
        System.out.println("1.- Nombre");
        System.out.println("2.- Cantidad de vacantes");
        System.out.println("3.- Cantidad total de puestos");
        System.out.println("4.- Skills");
    }

}
