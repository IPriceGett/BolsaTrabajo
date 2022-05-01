/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto.Back.utilidades;
import com.mycompany.proyecto.Back.clases.*;

/**
 *
 * @author mati
 */

import java.util.Comparator;


public class ComparadorPuntaje implements Comparator<Curriculum>{     
    @Override
    public int compare(Curriculum postulante1, Curriculum postulante2) {
        if(postulante1.getPuntaje() < postulante2.getPuntaje()){
            return 1;
        } else {
            return -1;
        }
    }
    
}
