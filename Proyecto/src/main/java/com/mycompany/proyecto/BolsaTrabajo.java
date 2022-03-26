/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.proyecto;
import com.mycompany.proyecto.Skill;


/**
 *
 * @author Ignacio
 */
public class BolsaTrabajo{
    public static void main(String[] args){
        Skill python = new Skill(1,"Python");
        Skill sql = new Skill(2,"SQL");
        Skill node = new Skill(3,"NodeJs");
        Skill angular = new Skill(4,"Angular");

        Skill[] informaticaSkills = new Skill[4];
        informaticaSkills[0] = python;
        informaticaSkills[1] = sql;
        informaticaSkills[2] = node;
        informaticaSkills[3] = angular;

        Skill contador = new Skill(5,"Contador");
        Skill excel = new Skill(6,"Excel");


        Skill[] finanzasSkills = new Skill[2];
        finanzasSkills[0] = contador;
        finanzasSkills[1] = excel;

        Skill publicidad = new Skill(7,"Publicidad");
        Skill ps = new Skill(8,"Photoshop");

        Skill[] marketingSkills = new Skill[2];
        marketingSkills[0] = publicidad;
        marketingSkills[1] = ps;

        Area informatica = new Area("Informatica", 10, 10, informaticaSkills, 20);
        Area finanzas = new Area("Finanzas", 10, 10, finanzasSkills, 20);
        Area marketing = new Area("Marketing", 10, 10, marketingSkills, 20);

        Area[] areas = new Area[3];
        areas[0] = informatica;
        areas[1] = finanzas;
        areas[2] = marketing;

        Empresa falsa = new Empresa("Avenida falsa 123", areas);

        System.out.println(falsa.getNombre() + " es la mejor empresa de lavado de dinero con NFTS del mundo");

    }
}
