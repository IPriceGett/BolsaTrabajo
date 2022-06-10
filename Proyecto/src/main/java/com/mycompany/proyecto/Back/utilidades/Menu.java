/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto.Back.utilidades;
import com.mycompany.proyecto.Back.clases.*;

/**
 *
 * @author igale
 */

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Comparator;

public class Menu {

public void menuUsuario(Utilidades utiles){
        
        System.out.println("BOLSA DE TRABAJO");
        System.out.println();

        InicialEnDuro data = new InicialEnDuro();
                
        int opcion;
         do{
                data.mostrarOpcionesIniciales();
                  
                Scanner scn = new Scanner(System.in);

                opcion = scn.nextInt();
                scn.nextLine();

                switch(opcion){

                    case 1:
                    {
                        utiles.agregarPostulanteUsuario();

                        break;
                    }

                    case 2:
                    {
                        System.out.println("Ingrese el rut del postulante a buscar (sin puntos y con guión): ");
                        String rut = scn.nextLine();

                        utiles.buscarPostulante(rut);  

                      break;
                    }

                    case 3:
                    {
                        utiles.mostrarPostulantesPorArea();

                        break;
                    }
                    
                    case 4:
                    {
                        utiles.editarPostulante();

                        break; 
                    }
                    
                    case 5:
                    {
                        String rut;

                        System.out.println("Ingrese el rut (sin puntos y con guion) del postulante que desea eliminar: ");
                        rut = scn.nextLine();
                        
                        if(utiles.eliminarPostulante(rut))
                            System.out.println("Postulante eliminado correctamente.");
                        
                        else
                            System.out.println("Este postulante no se encontraba en nuestra base de datos.");
                        
                        break;
                    }

                    case 6:
                    {
                        utiles.agregarAreaUsuario();
                        
                        break;
                    }

                    case 7:
                    {
                        utiles.mostrarAreas();
                        
                        break;
                    }
                    
                    case 8:
                    {
                        utiles.editarArea();

                        break; 
                    }
                    
                    case 9:
                    {
                        utiles.eliminarArea();

                        break; 
                    }

                    case 10:
                    {
                        utiles.agregarSkillAreaUsuario();

                        break;
                    }

                    case 11:
                    {
                        utiles.mostrarSkillsPorArea();

                        break; 
                    }

                    case 12:
                    {
                        String area, skill, nuevo;
                        utiles.mostrarSkillsPorArea();
                        System.out.println("De la lista mostrada arriba ingrese el nombre del area y la skill que desea editar (Uno a uno)");
                        area = scn.nextLine();
                        skill = scn.nextLine();
                        System.out.println("Ingrese el nuevo nombre de la skill");
                        nuevo = scn.nextLine();
                        //utiles.editarSkillArea(area, skill, nuevo);

                        break; 
                    }

                    case 13:
                    {
                        String area, skill;
                        utiles.mostrarSkillsPorArea();
                        System.out.println("De la lista mostrada arriba ingrese el nombre del area y la skill que desea eliminar (Uno a uno)");
                        area = scn.nextLine();
                        skill = scn.nextLine();
                        //utiles.eliminarSkillArea(area, skill);

                        break; 
                    }
                    
                    case 14:
                    {
                        Postulante postulante;
                        postulante = utiles.obtenerMejorPostulanteAreas();
                        System.out.println("El/La mejor postulante es " + postulante.getNombre() + " " + postulante.getApellido() + ", RUT " + postulante.getRut() + ", con un puntaje de " + postulante.getPuntaje() + ".");

                        break;
                    }
                    
                    case 15:
                    {
                        int minimo;
                        System.out.println("Ingrese el puntaje minimo a mostrar (entre 0 y 99): ");
                        minimo = scn.nextInt();
                        scn.nextLine();
                        
                        utiles.mostrarSobreXPuntaje(minimo);

                        break;
                    }
                    
                    case 16:
                    {
                        int maximo;
                        System.out.println("Ingrese el sueldo maximo a mostrar: ");
                        maximo = scn.nextInt();
                        scn.nextLine();
                        
                        utiles.sueldoInferiorA(maximo);

                        break;
                    }

                    case 0:
                    {
                        System.out.println("Exit");

                        break;
                    }

                    default:
                    {
                        return;
                    }
                }
                
               System.out.println(); 
               
            } while(opcion != 0);
         }

    
    
}
