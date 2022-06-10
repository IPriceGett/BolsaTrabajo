/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto.Back.interfaces;

import com.mycompany.proyecto.Back.clases.*;

import java.util.Collections;
import java.util.LinkedList;


/**
 *
 * @author igale
 */
public interface Utiles {

    public void agregarPostulanteUsuario();

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
