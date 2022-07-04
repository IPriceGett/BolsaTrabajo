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
public class Trabajador extends Persona {
    private int anosContratado;
    private int sueldo;
    private String posicionDeTrabajo;
    
    public Trabajador(){
        super();
        this.sueldo = 0;
        this.anosContratado = 0;
        this.posicionDeTrabajo = "nula";
    }
    
    public Trabajador(String nombre, String apellido, String rut, String genero, int edad, String correo, String telefono, int sueldo, String posicion){
        super(nombre, apellido, rut, genero, edad, correo, telefono);
        this.sueldo = sueldo;
        this.anosContratado = 0;
        this.posicionDeTrabajo = posicion;
    }
    
    public void setSueldo(int sueldo){
        this.sueldo = sueldo;
    }
    
    public void setPosicion(String posicion){
        this.posicionDeTrabajo = posicion;
    }
    
    public void setAnos(int anos){
        this.anosContratado = anos;
    }
    
    public int getSueldo(){ 
        return this.sueldo; 
    }
    
    public int getAnos(){
        return this.anosContratado;
    }
    
    public String getPosicion(){ 
        return this.posicionDeTrabajo; 
    }
    
    public void mostrarInfo(){
        System.out.println(this.getNombre() + " " + this.getApellido() + " | " + this.getRut() + " | " + anosContratado + " | " + sueldo);
        return;
    }
    
    public void mostrarParametrosEnumerados(){
        super.mostrarParametrosEnumerados();
        System.out.println("9.- Anos contratado");
        System.out.println("10.- Sueldo");
        System.out.println("11.- Posicion de trabajo");
    }
}
