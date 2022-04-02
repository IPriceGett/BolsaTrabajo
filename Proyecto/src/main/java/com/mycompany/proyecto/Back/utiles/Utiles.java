/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.proyecto.Back.utiles;
import com.mycompany.proyecto.Back.clases.*;

/**
 *
 * @author Ignacio
 */

import java.util.HashMap;
import java.util.LinkedList;

public class Utiles {

    public Curriculum crearPostulante(String nombre, String apellido, String rut, String genero, int edad, String correo, String telefono, LinkedList skills, int experiencia, String instituto){
        Curriculum postulante = new Curriculum();
        postulante.setNombre(nombre);
        postulante.setApellido(apellido);
        postulante.setRut(rut);
        postulante.setGenero(genero);
        postulante.setEdad(edad);
        postulante.setCorreo(correo);
        postulante.setTelefono(telefono);
        postulante.setSkills(skills);
        postulante.setAnnosExperiencia(experiencia);
        postulante.setInstituto(instituto);

        return postulante;
    }
    
    //Agregar postulante
    
    /*A los metodos para agregar postulantes les falta el detalle de que depende de sus skills a cual mapa de la
    respectiva area es asignado, esto aun no está implementado. 
    */
    public void agregarPostulante(HashMap map, Curriculum postulante){
        String rut = postulante.getRut();
        if (map.containsKey(rut)){
            System.out.println("Este postulante ya se encuentra en nuestra base de datos");
            return;
        }
        
        map.put(rut, postulante);
    }
    
    public void agregarPostulante(Curriculum postulante,HashMap map){
        String rut = postulante.getRut();
        if (map.containsKey(rut)){
            System.out.println("Este postulante ya se encuentra en nuestra base de datos");
            return;
        }
        
        map.put(rut, postulante);
    }
    
    //Eliminar postulante
    
    public void eliminarPostulante(HashMap map, String rut){
        map.remove(rut);
    }
    
     public void eliminarPostulante(String rut,HashMap map){
        map.remove(rut);
    }
    
     //Agregar trabajador
     
    public void agregarTrabajador(HashMap map, Curriculum trabajador){
        String rut = trabajador.getRut();
         if (map.containsKey(rut)){
            System.out.println("Este trabajador ya se encuentra en nuestra base de datos");
            return;
        }
        map.put(map, rut);
    }
    
    public void agregarTrabajador(Curriculum trabajador, HashMap map){
        String rut = trabajador.getRut();
         if (map.containsKey(rut)){
            System.out.println("Este trabajador ya se encuentra en nuestra base de datos");
            return;
        }
        map.put(map, rut);
    }
    
    //Eliminar Trabajador
    
    public void eliminarTrabajador(HashMap map, String rut){
        map.remove(rut);
    }
    
    public void eliminarTrabajador(String rut,HashMap map){
        map.remove(rut);
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
    
    public void eliminarSkill(LinkedList list){}

    //Buscar postulantes 
    
    public void buscarPostulante(HashMap postulantes, String rut){
        if (postulantes.containsKey(rut) == false){
            System.out.println("Postulante no encontrado.");
            return;
        }

        Curriculum postulante = (Curriculum) postulantes.get(rut);
        System.out.println("Nombre: " + postulante.getNombre() + " " + postulante.getApellido());
        System.out.println("Rut: " + postulante.getRut());
        System.out.println("Genero: " + postulante.getGenero());
        System.out.println("Edad: " + postulante.getEdad());
        System.out.println("Correo: " + postulante.getCorreo());
        System.out.println("Telefono: " + postulante.getTelefono());
        System.out.println("Años de experiencia: " + postulante.getAnnosExperiencia());
        System.out.println("Instituto: " + postulante.getInstituto());

        LinkedList skills = postulante.getSkills();
        System.out.print("Skills: ");
        for (int i = 0; i < skills.size(); i++){
            Skill skill = (Skill) skills.get(i);
            System.out.print(skill.getNombre() + ", ");
        }
        System.out.println();
        
    }

 public void buscarPostulante(String rut, HashMap postulantes){
         if (postulantes.containsKey(rut) == false){
            System.out.println("Postulante no encontrado.");
            return;
        }
        
        Curriculum postulante = (Curriculum) postulantes.get(rut);
        System.out.println("Nombre: " + postulante.getNombre() + " " + postulante.getApellido());
        System.out.println("Rut: " + postulante.getRut());
        System.out.println("Genero: " + postulante.getGenero());
        System.out.println("Edad: " + postulante.getEdad());
        System.out.println("Correo: " + postulante.getCorreo());
        System.out.println("Telefono: " + postulante.getTelefono());
        System.out.println("Años de experiencia: " + postulante.getAnnosExperiencia());
        System.out.println("Instituto: " + postulante.getInstituto());

        LinkedList skills = postulante.getSkills();
        System.out.print("Skills: ");
        for (int i = 0; i < skills.size(); i++){
            Skill skill = (Skill) skills.get(i);
            System.out.print(skill.getNombre() + ", ");
        }
        System.out.println();
    }    
}
