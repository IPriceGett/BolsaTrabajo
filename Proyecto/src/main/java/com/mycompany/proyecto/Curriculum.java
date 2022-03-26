/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.proyecto;

/**
 *
 * @author Ignacio
 */
public class Curriculum extends Persona{

    private Skill[] skills;
    private int annosExperiencia;
    private String instituto;

    public Curriculum(int annosExperiencia, String instituto, Skill[] skills, String nombre, String apellido, String rut, String genero, int edad, String correo, String telefono){
        super(nombre, apellido, rut, genero, edad, correo, telefono);
        this.annosExperiencia = annosExperiencia;
        this.instituto = instituto;
        this.skills = skills;
    }

    public String getInstituto(){
        return this.instituto;
    }

    public int getAnnosExperiencia(){
        return this.annosExperiencia;
    }

    public Skill[] getSkills(){
        return this.skills;
    }

    public void setInstituto(String instituto){
        this.instituto = instituto;
    }

    public void setAnnosExperiencia(int annosExperiencia){
        this.annosExperiencia = annosExperiencia;
    }

    public void setSkills(Skill[] skills){
        this.skills = skills;
    }

}
