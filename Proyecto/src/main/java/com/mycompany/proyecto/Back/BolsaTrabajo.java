/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.proyecto.Back;
import com.mycompany.proyecto.Back.clases.*;
import java.util.LinkedList;


public class BolsaTrabajo{
    public static void main(String[] args){
        Skill python = new Skill(1,"Python");
        Skill sql = new Skill(2,"SQL");
        Skill node = new Skill(3,"NodeJs");
        Skill angular = new Skill(4,"Angular");

        LinkedList informaticaSkills = new LinkedList();
        informaticaSkills.add(python);
        informaticaSkills.add(sql); 
        informaticaSkills.add(node);
        informaticaSkills.add(angular);

        Skill contador = new Skill(5,"Contador");
        Skill excel = new Skill(6,"Excel");


        LinkedList finanzasSkills = new LinkedList();
        finanzasSkills.add(contador);
        finanzasSkills.add(excel);

        Skill publicidad = new Skill(7,"Publicidad");
        Skill ps = new Skill(8,"Photoshop");

        LinkedList marketingSkills = new LinkedList();
        marketingSkills.add(publicidad);
        marketingSkills.add(ps);

        Area informatica = new Area("Informatica", 10, 10, informaticaSkills, 20);
        Area finanzas = new Area("Finanzas", 10, 10, finanzasSkills, 20);
        Area marketing = new Area("Marketing", 10, 10, marketingSkills, 20);

        LinkedList areas = new LinkedList();
        areas.add(informatica);
        areas.add(finanzas);
        areas.add(marketing);

        Empresa falsa = new Empresa("Avenida falsa 123", areas);

        System.out.println(falsa.getNombre() + " es la mejor empresa de lavado de dinero con NFTS del mundo");

    }
}
