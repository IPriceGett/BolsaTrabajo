/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.proyecto.Back;
import com.mycompany.proyecto.Back.clases.*;
import com.mycompany.proyecto.Back.utiles.*;

import java.util.HashMap;
import java.util.LinkedList;


public class BolsaTrabajo{
    public static void main(String[] args){
        
        Utiles aux = new Utiles();

        LinkedList informaticaSkills = new LinkedList();
        aux.agregarSkill(informaticaSkills,1,"Python");
        aux.agregarSkill(informaticaSkills,2,"SQL");
        aux.agregarSkill(informaticaSkills,3,"NodeJs");
        aux.agregarSkill(informaticaSkills,4,"Angular");

        LinkedList finanzasSkills = new LinkedList();
        aux.agregarSkill(finanzasSkills,5,"Contador");
        aux.agregarSkill(finanzasSkills,6,"Excel");
    
        LinkedList marketingSkills = new LinkedList();
        aux.agregarSkill(marketingSkills,7,"Publicidad");
        aux.agregarSkill(marketingSkills,8,"Photoshop");

        HashMap contratadosInformatica = new HashMap();
        HashMap postulantesInformatica = new HashMap();
        HashMap contratadosFinanzas = new HashMap();
        HashMap postulantesFinanzas = new HashMap();
        HashMap contratadosMarketing = new HashMap();
        HashMap postulantesMarketing = new HashMap();

        Area informatica = new Area("Informatica", 10, 10, informaticaSkills, contratadosInformatica, postulantesInformatica);
        Area finanzas = new Area("Finanzas", 10, 10, finanzasSkills, contratadosFinanzas, postulantesFinanzas);
        Area marketing = new Area("Marketing", 10, 10, marketingSkills, contratadosMarketing, postulantesMarketing);

        LinkedList areas = new LinkedList();
        areas.add(informatica);
        areas.add(finanzas);
        areas.add(marketing);

        LinkedList skillsPostulante1 = new LinkedList();
        aux.agregarSkill(skillsPostulante1, 1, "Python");
        aux.agregarSkill(skillsPostulante1, "SQL", 2);

        Curriculum postulante1 = aux.crearPostulante("Juan", "Perez", "9876543-2", "M", 35, "juan.perez25@gmail.com", "988776655", skillsPostulante1, 8, "PUCV");

        aux.agregarPostulante(postulantesInformatica, postulante1);
        aux.buscarPostulante(postulantesInformatica, postulante1.getRut());
        System.out.println();
        
         LinkedList skillsPostulante2 = new LinkedList();
        aux.agregarSkill(7, "Publicidad", skillsPostulante2);
        aux.agregarSkill(skillsPostulante2, "Photoshop", 8);
        
        Curriculum postulante2 = aux.crearPostulante("Ana", "Gallegos", "5678912-1", "F", 46, "ana.gallegos36@gmail.com", "912345678", skillsPostulante2, 15, "PUCV");
        aux.agregarPostulante(postulante2, postulantesMarketing);
        aux.buscarPostulante(postulantesMarketing, postulante2.getRut());
        System.out.println();
        
        aux.buscarPostulante(postulantesMarketing, "abc"); //Si se busca un postulante no existente
        System.out.println();

        
        Empresa falsa = new Empresa("Avenida falsa 123", areas);

        System.out.println(falsa.getNombre() + " es la mejor empresa de lavado de dinero con NFTS del mundo");

    }
}
