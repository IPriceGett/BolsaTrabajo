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
        aux.agregarSkill(skillsPostulante1, 1,"Python");
        aux.agregarSkill(skillsPostulante1, 2,"SQL");

        Curriculum postulante1 = aux.crearPostulante("Juan", "Perez", "9876543-2", "M", 25, "juan.perez25@gmail.com", "988776655", skillsPostulante1, 8, "PUCV");

        aux.agregarPostulante(postulantesInformatica, postulante1);
        aux.buscarPostulante(postulantesInformatica, "9876543-2");
        
        Empresa falsa = new Empresa("Avenida falsa 123", areas);

        System.out.println(falsa.getNombre() + " es la mejor empresa de lavado de dinero con NFTS del mundo");

    }
}
