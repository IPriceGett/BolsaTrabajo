/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.proyecto.Back;
import com.mycompany.proyecto.Back.clases.*;
import com.mycompany.proyecto.Back.utilidades.*;


public class BolsaTrabajo{
    public static void main(String[] args){
        
        Skill auxSkill = new Skill();
        Utilidades auxUtil = new Utilidades();
       
        //Inicializando areas de prueba
        
        Area informatica = new Area("Informatica", 10, 10);
        Area finanzas = new Area("Finanzas", 10, 10);
        Area marketing = new Area("Marketing", 10, 10);

        auxSkill.agregarSkill(informatica.getSkills(),1,"Python");
        auxSkill.agregarSkill(informatica.getSkills(),2,"SQL");
        auxSkill.agregarSkill(informatica.getSkills(),3,"NodeJs");
        auxSkill.agregarSkill(informatica.getSkills(),4,"Angular");

        auxSkill.agregarSkill(finanzas.getSkills(),5,"Contador");
        auxSkill.agregarSkill(finanzas.getSkills(),6,"Excel");
    
        auxSkill.agregarSkill(marketing.getSkills(),7,"Publicidad");
        auxSkill.agregarSkill(marketing.getSkills(),8,"Photoshop");

        
        auxUtil.agregarArea(informatica);
        auxUtil.agregarArea(finanzas);
        auxUtil.agregarArea(marketing);

        //Inicializando postulantes de prueba
        
        Curriculum postulante1 = new Curriculum("Juan", "Perez", "9876543-2", "M", 35, "juan.perez25@gmail.com", "988776655", 8, "PUCV");
        auxSkill.agregarSkill(postulante1.getSkills(), 1, "Python");
        auxSkill.agregarSkill(postulante1.getSkills(), "SQL", 2);
         
        auxUtil.agregarPostulante(postulante1);
        
        Curriculum postulante2 = new Curriculum("Pedro", "Perez", "54545545-6", "M", 35, "juan.perez25@gmail.com", "988776655", 8, "PUCV");
        auxSkill.agregarSkill(postulante2.getSkills(), 5, "Contador");
        auxSkill.agregarSkill(postulante2.getSkills(), "Excel", 6);

        auxUtil.agregarPostulante(postulante2);
        
        Curriculum postulante3 = new Curriculum("Benja", "Perez", "435345345-2", "M", 35, "juan.perez25@gmail.com", "988776655", 8, "PUCV");
        auxSkill.agregarSkill(postulante3.getSkills(), 7, "Publicidad");
        auxSkill.agregarSkill(postulante3.getSkills(), "Photoshop", 8);

        auxUtil.agregarPostulante(postulante3);
       
        //Menu
        
        auxUtil.menu();
        
    }
}
