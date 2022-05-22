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
    public Utilidades cargaInicial(){

        Utilidades auxUtil = new Utilidades();
       
        //Para no tener que ingresar areas y postulantes a mano, descomentar el codigo a continuacion
        
        Skill auxSkill = new Skill();

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
        System.out.println("Agregando postulantes de prueba.");
        System.out.println();
        
        TrabajadorPostulante postulante1 = new TrabajadorPostulante("Juanino", "Perezinho", "9876543-2", "M", 35, "juan.perez25@gmail.com", "988776655", 8, "PUCV", "Banco", "jefe de piso", 500000, "sueldo");
        auxSkill.agregarSkill(postulante1.getSkills(), 1, "Python");
        auxSkill.agregarSkill(postulante1.getSkills(), "SQL", 2);
         
        auxUtil.agregarPostulante(postulante1);
        
        TrabajadorPostulante postulante2 = new TrabajadorPostulante("Catalina", "Herrera", "8234456-6", "F", 35, "cata.herrera35@gmail.com", "988776655", 12, "USM", "Ripley", "Gerente", 4000000, "familia");
        auxSkill.agregarSkill(postulante2.getSkills(), 5, "Contador");
        auxSkill.agregarSkill(postulante2.getSkills(), "Excel", 6);

        auxUtil.agregarPostulante(postulante2);
        
        TrabajadorPostulante postulante3 = new TrabajadorPostulante("Benjamin", "Barraza", "11475895-2", "M", 35, "juan.perez25@gmail.com", "988776655", 10, "PUCV", "Casino", "jefe en cyberseguridad", 1300000, "ambiente");
        auxSkill.agregarSkill(postulante3.getSkills(), 7, "Publicidad");
        auxSkill.agregarSkill(postulante3.getSkills(), "Photoshop", 8);

        auxUtil.agregarPostulante(postulante3);
        
        TrabajadorPostulante postulante4 = new TrabajadorPostulante("Sofia", "Ortega", "6748594-2", "F", 60, "sofia.ortega@gmail.com", "9384758596", 40, "UC", "Paris", "jefe", 3700000, "sueldo");
        auxSkill.agregarSkill(postulante4.getSkills(), 1, "Python");
        auxSkill.agregarSkill(postulante4.getSkills(), "NodeJs", 3);

        auxUtil.agregarPostulante(postulante4);
        
        TrabajadorPostulante postulante5 = new TrabajadorPostulante("Patricio", "Castillo", "14465845-1", "M", 57, "pato.castillo@gmail.com", "975834758", 28, "UCH", "Movistar", "empleado", 3400000, "sueldo");
        auxSkill.agregarSkill(postulante5.getSkills(), 2, "SQL");
        auxSkill.agregarSkill(postulante5.getSkills(), "Angular", 4);

        auxUtil.agregarPostulante(postulante5);
        
        TrabajadorPostulante postulante6 = new TrabajadorPostulante("Benjamin", "Barraza", "8766987-2", "M", 35, "juan.perez25@gmail.com", "988776655", 10, "PUCV", "Casino", "jefe en cyberseguridad", 1300000, "ambiente");
        auxSkill.agregarSkill(postulante6.getSkills(), 2, "SQL");
        auxSkill.agregarSkill(postulante6.getSkills(), "Angular", 4);

        auxUtil.agregarPostulante(postulante6);
        
        System.out.println();
        
        return auxUtil;
    }

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
    
    public void inicializar(){

        Utilidades auxUtil = new Utilidades();
        auxUtil = cargaInicial();
        Menu menu = new Menu();
        menu.menuUsuario(auxUtil);
    }
}
