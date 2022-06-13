/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto.Back.interfaces;

import com.mycompany.proyecto.Back.clases.*;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


/**
 *
 * @author igale
 */
public interface Utiles {
    
    public List<Postulante> obtenerPostulantes();
    
    public Postulante crearPostulante(String nombre, String apellido, String rut, String genero, int edad, String correo, String telefono, int experiencia, String instituto, Skill skill);
    
    public void agregarPostulante(Postulante postulante);
    
    public void agregarPostulante();

    public boolean buscarPostulante(String rut);

    public void mostrarPostulantesPorArea();
   
    public void agregarAreaUsuario();
   
    public void mostrarAreas();

    public void agregarSkillAreaUsuario();

    public void mostrarSkillsPorArea();

    public void eliminarArea();

    public void editarPostulante();

    public void editarArea();

    //public void editarSkillArea(String nombreArea, String nombreAntiguo, String nombreNuevo);

    //public void eliminarSkillArea(String nombreArea, String nombreSkill);
     
}
