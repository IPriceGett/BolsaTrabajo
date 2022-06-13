/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto.Back.clases;
import com.mycompany.proyecto.Back.utilidades.*;
import com.mycompany.proyecto.Back.interfaces.*;

/**
 *
 * @author igale
 */
public class InicialEnDuro implements Data{
    @Override
    public Utilidades cargaInicial(){

        Utilidades auxUtil = new Utilidades();

        Area informatica = new Area("Informatica", 10, 10);
        Area finanzas = new Area("Finanzas", 10, 10);
        Area marketing = new Area("Marketing", 10, 10);

        Skill python = new Skill("Python", 85);
        informatica.setSkill(python);
        Skill sql = new Skill("SQL", 25);
        informatica.setSkill(sql);
        Skill nodejs = new Skill("NodeJs", 32);
        informatica.setSkill(nodejs);
        Skill angular = new Skill("Angular", 17);
        informatica.setSkill(angular);
        
        Skill contabilidad = new Skill("Contabilidad", 74);
        finanzas.setSkill(contabilidad);
        Skill excel = new Skill("Excel", 86);
        finanzas.setSkill(excel);
        
        Skill publicidad = new Skill("Publicidad", 75);
        marketing.setSkill(publicidad);
        Skill photoshop = new Skill("Photoshop", 49);
        marketing.setSkill(photoshop);
    
        auxUtil.agregarArea(informatica);
        auxUtil.agregarArea(finanzas);
        auxUtil.agregarArea(marketing);

        //Inicializando postulantes de prueba
        System.out.println("Agregando postulantes de prueba.");
        System.out.println();
        
        Postulante postulante1 = new Postulante("Juanino", "Perezinho", "9876543-2", "M", 35, "juan.perez25@gmail.com", "988776655", 8, "PUCV", 500000);
        postulante1.setSkill(python);
        postulante1.setSkill(sql);
         
        auxUtil.agregarPostulante(postulante1);
        
        Postulante postulante2 = new Postulante("Catalina", "Herrera", "8234456-6", "F", 35, "cata.herrera35@gmail.com", "988776655", 12, "USM", 4000000);
        postulante2.setSkill(contabilidad);
        postulante2.setSkill(excel);
        
        auxUtil.agregarPostulante(postulante2);
        
        Postulante postulante3 = new Postulante("Benjamin", "Barraza", "11475895-2", "M", 35, "juan.perez25@gmail.com", "988776655", 10, "PUCV", 1300000);
        postulante3.setSkill(publicidad);
        postulante3.setSkill(photoshop);

        auxUtil.agregarPostulante(postulante3);
        
        Postulante postulante4 = new Postulante("Sofia", "Ortega", "6748594-2", "F", 60, "sofia.ortega@gmail.com", "9384758596", 40, "UC", 3700000);
        postulante4.setSkill(python);
        postulante4.setSkill(nodejs);

        auxUtil.agregarPostulante(postulante4);
        
        Postulante postulante5 = new Postulante("Patricio", "Castillo", "14465845-1", "M", 57, "pato.castillo@gmail.com", "975834758", 28, "UCH", 3400000);
        postulante5.setSkill(sql);
        postulante5.setSkill(angular);

        auxUtil.agregarPostulante(postulante5);
        
        Postulante postulante6 = new Postulante("Benjamin", "Barraza", "8766987-2", "M", 35, "juan.perez25@gmail.com", "988776655", 10, "PUCV", 1300000);
        postulante6.setSkill(angular);
        postulante6.setSkill(python);
        postulante6.setSkill(sql);

        auxUtil.agregarPostulante(postulante6);
        
        System.out.println();
        
        return auxUtil;
    }

    @Override
    public void mostrarOpcionesIniciales(){
       
        System.out.println("Elija una opcion para continuar: ");
        System.out.println("1.- Agregar postulante"); // Agrega a mapa de todos los postulantes y a lista de postulantes del area correspondiente
        System.out.println("2.- Buscar postulante"); //Busca postulante en mapa
        System.out.println("3.- Mostrar todos los postulantes"); //Recorre la lista de areas, y luego la lista de postulantes de cada una
        System.out.println("4.- Editar postulante");
        System.out.println("5.- Eliminar Postulante");
        System.out.println("6.- Agregar área");
        System.out.println("7.- Mostrar todas las áreas");
        System.out.println("8.- Editar área");
        System.out.println("9.- Eliminar área");
        System.out.println("10.- Agregar skill a área");
        System.out.println("11.- Mostrar las skills de cada área");
        System.out.println("12.- Editar skill");
        System.out.println("13.- Eliminar skill");
        System.out.println("14.- Mostrar postulante con el puntaje mas alto");
        System.out.println("15.- Mostrar postulantes con un puntaje superior a: ");
        System.out.println("16.- Mostrar postulantes con una expectativa de sueldo inferior a: ");
        System.out.println("0.- Salir");
    }
    
    @Override
    public void inicializar(){

        Utilidades auxUtil = new Utilidades();
        auxUtil = cargaInicial();
        Menu menu = new Menu();
        menu.menuUsuario(auxUtil);
    }
    
    @Override
    public Utilidades obtenerInstancia(){
        Utilidades auxUtil = new Utilidades();
        auxUtil = cargaInicial();
        return auxUtil;
    }
}
