/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.proyecto.Back.utilidades;
import com.mycompany.proyecto.Back.clases.*;

/**
 *
 * @author Ignacio
 */

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;


public class Utilidades {
    
    HashMap<String, Curriculum> mapaPostulantes = new HashMap<>();
    LinkedList<Area> listaAreas = new LinkedList<>();

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
    
    public Curriculum crearPostulante(String nombre, String apellido, String rut, String genero, int edad, String correo, String telefono, int experiencia, String instituto){
        Curriculum postulante = new Curriculum();
        postulante.setNombre(nombre);
        postulante.setApellido(apellido);
        postulante.setRut(rut);
        postulante.setGenero(genero);
        postulante.setEdad(edad);
        postulante.setCorreo(correo);
        postulante.setTelefono(telefono);
        postulante.setAnnosExperiencia(experiencia);
        postulante.setInstituto(instituto);
        LinkedList<Skill> skills = new LinkedList<>();
        postulante.setSkills(skills);

        return postulante;
    }
    
    //Agregar postulante
    
    /*A los metodos para agregar postulantes les falta el detalle de que depende de sus skills a cual mapa de la
    respectiva area es asignado, esto aun no está implementado. 
    */
    public void agregarPostulante(Curriculum postulante){
        
        if (mapaPostulantes.containsKey(postulante.getRut())){
        System.out.println("Este postulante ya se encuentra en nuestra base de datos.");
        return;
        }
   
        Utilidades auxUtil = new Utilidades();
        Area area;
        LinkedList listaSkillsP = postulante.getSkills();
        LinkedList listaSkillsA;
        Skill skillP;
        Skill skillA;
        LinkedList listaPostulantes;
        
        auxUtil.calcularPuntaje(postulante);
        
        for (int i = 0; i < listaAreas.size(); i++){
            
            area = (Area) listaAreas.get(i);
            listaSkillsA = area.getSkills();
            
            for (int j = 0; j < listaSkillsA.size(); j++){
                
                skillA = (Skill) listaSkillsA.get(j);
                
                for (int k = 0; k < listaSkillsP.size(); k++){
                    
                    skillP = (Skill) listaSkillsP.get(k);
                    
                    if (skillP.getId() == skillA.getId()){
                        
                        listaPostulantes = area.getPostulantes();
                        listaPostulantes.add(postulante);
                        Collections.sort(listaPostulantes, new compPuntaje());
                        
                        break;
                    }
                    
                    break;
                }
            }
        }
    
        
        mapaPostulantes.put(postulante.getRut(), postulante);
        
        System.out.println("Postulante añadido.");
  
    }
    
    class compPuntaje implements Comparator<Curriculum>{	 
    @Override
    public int compare(Curriculum postulante1, Curriculum postulante2) {
        if(postulante1.getPuntaje() < postulante2.getPuntaje()){
            return 1;
        } else {
            return -1;
        }
    }
}

    public void calcularPuntaje(Curriculum postulante){ // random por mientras
        int puntaje = (int) Math.floor(Math.random()*(100-1+1)+1);
        postulante.setPuntaje(puntaje);
    }
 
    //Eliminar postulante
    
    public void eliminarPostulante(String rut){
        if (!mapaPostulantes.containsKey(rut)){
        System.out.println("Este postulante no se encontraba en nuestra base de datos.");
        return;
        }
        mapaPostulantes.remove(rut);
        System.out.println("Postulante eliminado.");
    }
    
     //Agregar trabajador
     
    public void agregarTrabajador(Curriculum trabajador){
        String rut = trabajador.getRut();
         if (mapaPostulantes.containsKey(rut)){
            System.out.println("Este trabajador ya se encuentra en nuestra base de datos");
            return;
        }
        mapaPostulantes.put(rut, trabajador);
    }
  
    //Eliminar Trabajador
    
    public void eliminarTrabajador(String rut){
        mapaPostulantes.remove(rut);
    }
 
    //Buscar postulantes 
    
    public void buscarPostulante(String rut){
        
         if (!mapaPostulantes.containsKey(rut)){
            System.out.println("Postulante no encontrado.");
            return;
        }
        
        Curriculum postulante = (Curriculum) mapaPostulantes.get(rut);
        System.out.println("Nombre: " + postulante.getNombre() + " " + postulante.getApellido());
        System.out.println("Rut: " + postulante.getRut());
        System.out.println("Genero: " + postulante.getGenero());
        System.out.println("Edad: " + postulante.getEdad());
        System.out.println("Correo: " + postulante.getCorreo());
        System.out.println("Telefono: " + postulante.getTelefono());
        System.out.println("Años de experiencia: " + postulante.getAnnosExperiencia());
        System.out.println("Instituto: " + postulante.getInstituto());
        System.out.println("Puntaje: " + postulante.getPuntaje());

        LinkedList skills = postulante.getSkills();
        System.out.print("Skills: ");
        for (int i = 0; i < skills.size(); i++){
            Skill skill = (Skill) skills.get(i);
            System.out.print(skill.getNombre() + " ");
        }
        System.out.println();
    }
    
    public void agregarArea(Area area){
        listaAreas.add(area);
    }
    
    public void mostrarPostulantesPorArea(){
        LinkedList aux;
        Curriculum postulante;
        
        for (int i = 0; i < listaAreas.size(); i++){
            
            System.out.println(listaAreas.get(i).getNombre());
            aux = listaAreas.get(i).getPostulantes();
            
            for (int j = 0; j < aux.size(); j++){
                
                postulante = (Curriculum)aux.get(j);
                System.out.println(postulante.getNombre());
            }
        }
         
  
    }

}
