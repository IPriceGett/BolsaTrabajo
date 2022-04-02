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

//comentario de prueba

public class BolsaTrabajo{
    public static void main(String[] args){
        /*Skill python = new Skill(1,"Python");
        Skill sql = new Skill(2,"SQL");
        Skill node = new Skill(3,"NodeJs");
        Skill angular = new Skill(4,"Angular");*/
        
        Utiles aux = new Utiles();
        LinkedList informaticaSkills = new LinkedList();
        aux.agregarSkill(informaticaSkills,1,"Python");
        aux.agregarSkill(informaticaSkills,2,"SQL");
        aux.agregarSkill(informaticaSkills,3,"NodeJs");
        aux.agregarSkill(informaticaSkills,4,"Angular");
        /*
        informaticaSkills.add(python);
        informaticaSkills.add(sql); 
        informaticaSkills.add(node);
        informaticaSkills.add(angular);

        Skill contador = new Skill(5,"Contador");
        Skill excel = new Skill(6,"Excel");*/


        LinkedList finanzasSkills = new LinkedList();
        aux.agregarSkill(finanzasSkills,5,"Contador");
        aux.agregarSkill(finanzasSkills,6,"Excel");
        /*
        finanzasSkills.add(contador);
        finanzasSkills.add(excel);

        Skill publicidad = new Skill(7,"Publicidad");
        Skill ps = new Skill(8,"Photoshop");*/

        LinkedList marketingSkills = new LinkedList();
        aux.agregarSkill(marketingSkills,7,"Publicidad");
        aux.agregarSkill(marketingSkills,8,"Photoshop");
        /*
        marketingSkills.add(publicidad);
        marketingSkills.add(ps);*/

        HashMap contratados = new HashMap();
        HashMap postulantes = new HashMap();

        Area informatica = new Area("Informatica", 10, 10, informaticaSkills, contratados, postulantes);
        Area finanzas = new Area("Finanzas", 10, 10, finanzasSkills, contratados, postulantes);
        Area marketing = new Area("Marketing", 10, 10, marketingSkills, contratados, postulantes);

        LinkedList areas = new LinkedList();
        areas.add(informatica);
        areas.add(finanzas);
        areas.add(marketing);

        LinkedList skillsPostulante1 = new LinkedList();
        aux.agregarSkill(skillsPostulante1, 1,"Python");
        aux.agregarSkill(skillsPostulante1, 2,"SQL");

        Curriculum postulante1 = aux.crearPostulante("Juan", "Perez", "9876543-2", "M", 25, "juan.perez25@gmail.com", "988776655", skillsPostulante1, 8, "PUCV");

        aux.agregarPostulante(postulantes, postulante1);
        aux.buscarPostulante(postulantes, "9876543-2");
        
        Empresa falsa = new Empresa("Avenida falsa 123", areas);

        System.out.println(falsa.getNombre() + " es la mejor empresa de lavado de dinero con NFTS del mundo");

    }
}
