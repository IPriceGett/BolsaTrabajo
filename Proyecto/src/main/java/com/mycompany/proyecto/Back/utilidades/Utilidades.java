/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.proyecto.Back.utilidades;
import com.mycompany.proyecto.Back.clases.*;

/**
 *
 * @author Ignacio
 */

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Comparator;


public class Utilidades {
    
    HashMap<String, Curriculum> mapaPostulantes = new HashMap<>(); // listo eliminar listo editar
    LinkedList<Area> listaAreas = new LinkedList<>(); //listo eliminar falta editar

    public Curriculum crearPostulante(String nombre, String apellido, String rut, String genero, int edad, String correo, String telefono, LinkedList skills, int experiencia, String instituto){
        
        Curriculum postulante = new Curriculum();
        postulante.setNombre(nombre);
        postulante.setApellido(apellido);
        postulante.setRut(rut);
        postulante.setGenero(genero);
        postulante.setEdad(edad);
        postulante.setCorreo(correo);
        postulante.setTelefono(telefono);
        postulante.setSkills(skills);
        postulante.setAñosExperiencia(experiencia);
        postulante.setInstituto(instituto);

        return postulante; 
    }
    
    public Curriculum crearPostulante(String nombre, String apellido, String rut, String genero, int edad, String correo, String telefono, int experiencia, String instituto){
        
        Curriculum postulante = new Curriculum();
        postulante.setNombre(nombre);
        postulante.setApellido(apellido);
        postulante.setRut(rut);
        postulante.setGenero(genero);
        postulante.setEdad(edad);
        postulante.setCorreo(correo);
        postulante.setTelefono(telefono);
        postulante.setAñosExperiencia(experiencia);
        postulante.setInstituto(instituto);
        LinkedList<Skill> skills = new LinkedList<>();
        postulante.setSkills(skills);

        return postulante;
    }
    
    //Relacionado a postulantes
    
    /*Se ha implementado el comparar las skills del postulante con las de cada area, pero, hasta ahora, al encontrar el primer
      "match", se guarda en esa area. Quizas mas adelante se podria crear una formula para que a diferencia de la version de ahora,
       quede en el area donde mas skills es comun tenga.
       Por lo tanto por mientras para testear el agregar postulantes se pide ingresar skills relacionadas a una sola area, ya que
       este sera ingresado al area con el que encuentre la primera skill en comun.
    */
    public void agregarPostulante(Curriculum postulante){
        
        if (mapaPostulantes.containsKey(postulante.getRut())){
        System.out.println("Este postulante ya se encuentra en nuestra base de datos.");
        return;
        }
   
        Utilidades auxUtil = new Utilidades();
        Comparator<Curriculum> comparador = new ComparadorPuntaje();
        Area area;
        LinkedList<Skill> listaSkillsP = postulante.getSkills();
        LinkedList<Skill> listaSkillsA;
        Skill skillP;
        Skill skillA;
        LinkedList listaPostulantes;
        
        auxUtil.calcularPuntaje(postulante);
        
        for (int i = 0; i < listaAreas.size(); i++){
            
            area = listaAreas.get(i);
            listaSkillsA = area.getSkills();
            
            for (int j = 0; j < listaSkillsA.size(); j++){
                
                skillA = listaSkillsA.get(j);
                
                for (int k = 0; k < listaSkillsP.size(); k++){
                    
                    skillP = listaSkillsP.get(k);
                    
                    if (skillP.getNombre().equals(skillA.getNombre())){
                        
                        listaPostulantes = area.getPostulantes();
                        listaPostulantes.add(postulante);
                        Collections.sort(listaPostulantes, comparador);
                        
                        break;
                    }
                    
                    break;
                }
            }
        }
    
        mapaPostulantes.put(postulante.getRut(), postulante);
        
        System.out.println("Postulante añadido.");
    }
    
    public void agregarPostulanteUsuario(){
        
        Scanner scn = new Scanner(System.in);
        Curriculum postulante = new Curriculum();
        
        System.out.println("Por favor ingrese los siguientes datos del postulante: ");
        System.out.println("Nombre(s): ");
        postulante.setNombre(scn.nextLine());
        System.out.println("Apellido(s): ");
        postulante.setApellido(scn.nextLine());
        System.out.println("RUT (sin puntos y con guión): ");
        postulante.setRut(scn.nextLine());
        System.out.println("Genero: ");
        postulante.setGenero(scn.nextLine());
        System.out.println("Edad: ");
        postulante.setEdad(scn.nextInt());
        scn.nextLine();
        System.out.println("Correo: ");
        postulante.setCorreo(scn.nextLine());
        System.out.println("Telefono: ");
        postulante.setTelefono(scn.nextLine());
        System.out.println("Años de experiencia: ");
        postulante.setAñosExperiencia(scn.nextInt());
        scn.nextLine();
        System.out.println("Institucion Educacional: ");
        postulante.setInstituto(scn.nextLine());
        
        //Agregar skills
        
        System.out.println("De la siguiente lista, ingrese, una por una, las skills que maneja. Cuando haya terminado, ingrese '0' ");
        
        this.mostrarTodasSkills();
        
        Skill auxSkill = new Skill();
        LinkedList<Skill> listaSkills;
        listaSkills = new LinkedList<>();
        String nombreSkill = "aux";
        
        while (!nombreSkill.equals("0")){
            nombreSkill = scn.nextLine();
            if (nombreSkill.equals("0")) break;
            auxSkill.agregarSkill(nombreSkill, listaSkills);
        }
        
        postulante.setSkills(listaSkills);
        
        //Agregar postulante recien creado
        this.agregarPostulante(postulante);   
    }
    /*
    class compPuntaje implements Comparator<Curriculum>{	 
    @Override
    public int compare(Curriculum postulante1, Curriculum postulante2) {
        if(postulante1.getPuntaje() < postulante2.getPuntaje()){
            return 1;
        } else {
            return -1;
        }
    }*/

    public void calcularPuntaje(Curriculum postulante){ // Por el momento asigna un numero random, se tiene que crear formula para calcular puntaje
        int puntaje = (int) Math.floor(Math.random()*(100-1+1)+1);
        postulante.setPuntaje(puntaje);
    }
    
    public void eliminarPostulante(String rut){
        if (!mapaPostulantes.containsKey(rut)){
        System.out.println("Este postulante no se encontraba en nuestra base de datos.");
        return;
        }
        mapaPostulantes.remove(rut);
        
        for(int i = 0; i < listaAreas.size() ; i++){
           for(int j = 0; j< listaAreas.get(i).getPostulantes().size(); j++){
                if(listaAreas.get(i).getPostulantes().get(j).getRut() == rut){
                    listaAreas.get(i).removePostulante(listaAreas.get(i).getPostulantes().get(j));
                    i = listaAreas.size();
                    j = listaAreas.get(i).getPostulantes().size();
                }
           }
        }
        System.out.println("Postulante eliminado.");
    }
    
     public boolean buscarPostulante(String rut){
        
        if (!mapaPostulantes.containsKey(rut)){
            System.out.println("Postulante no encontrado.");
            return false;
        }
        
        Curriculum postulante = (Curriculum) mapaPostulantes.get(rut);
        System.out.println("Nombre: " + postulante.getNombre() + " " + postulante.getApellido());
        System.out.println("Rut: " + postulante.getRut());
        System.out.println("Genero: " + postulante.getGenero());
        System.out.println("Edad: " + postulante.getEdad());
        System.out.println("Correo: " + postulante.getCorreo());
        System.out.println("Telefono: " + postulante.getTelefono());
        System.out.println("Años de experiencia: " + postulante.getAnnosExperiencia());
        System.out.println("Institucion Educacional: " + postulante.getInstituto());
        System.out.println("Puntaje: " + postulante.getPuntaje());

        LinkedList<Skill> skills = postulante.getSkills();
        System.out.print("Skills: ");
        for (int i = 0; i < skills.size(); i++){
            Skill skill = skills.get(i);
            System.out.print(skill.getNombre() + " ");
        }
        System.out.println();

        return true;
    }
    
    public void mostrarPostulantesPorArea(){
        if (mapaPostulantes.isEmpty())
        {
            System.out.println("Aún no se ha agregado ningún postulante.");
            return;
        }

        LinkedList<Curriculum> listaPost;
        Curriculum postulante;
        
        for (int i = 0; i < listaAreas.size(); i++){
            
            System.out.println(listaAreas.get(i).getNombre().toUpperCase());
            listaPost = listaAreas.get(i).getPostulantes();
            
            if(listaPost.isEmpty()){
                 System.out.println("Esta área no tiene postulantes.");
                 continue;
            }
            
            System.out.println("Nombre completo     RUT     Puntaje de postulacion");
            
            for (int j = 0; j < listaPost.size(); j++){
                
                postulante = listaPost.get(j);
                System.out.println(postulante.getNombre() + " " + postulante.getApellido() + " | " + postulante.getRut() + " | " + postulante.getPuntaje());
            }
        }

    }

    public void editarPostulante(){
        Scanner scn = new Scanner(System.in);
        String rut;

        System.out.println("Ingrese el rut del postulante a editar: ");
        rut = scn.nextLine();

        if(this.buscarPostulante(rut)){
            this.eliminarPostulante(rut);
            this.agregarPostulanteUsuario();
        }
    }
    
    //Relacionado a trabajadores
    //Aun no implementado
    /*
    public void agregarTrabajador(Curriculum trabajador){
        String rut = trabajador.getRut();
         if (mapaPostulantes.containsKey(rut)){
            System.out.println("Este trabajador ya se encuentra en nuestra base de datos");
            return;
        }
        mapaPostulantes.put(rut, trabajador);
    }
    
    public void eliminarTrabajador(String rut){
        mapaPostulantes.remove(rut);
    }*/

    // Relacionados a Areas

    public void agregarArea(Area area){
        listaAreas.add(area);
    }
    
    public void agregarAreaUsuario(){
        
        Scanner scn = new Scanner(System.in);
        
        System.out.println("Ingrese el nombre de la nueva área: "); //Falta comprobar que no este repetida
        String nombre = scn.nextLine();
        System.out.println("Ingrese su maximo total de trabajadores: ");
        int total = scn.nextInt();
        scn.nextLine();
        
        Skill auxSkill = new Skill();
        LinkedList<Skill> lista = new LinkedList<>();
        String nombreSkill = "aux";
        
        System.out.println("Ingrese, una por una, las skills necesarias para trabajar en esta área. Para terminar ingrese '0'.");
        
        while (!nombreSkill.equals("0")){
            nombreSkill = scn.nextLine();
            if (nombreSkill.equals("0")) break;
            auxSkill.agregarSkill(nombreSkill, lista);
        }
        
        Area nueva = new Area(nombre, total, lista);
        listaAreas.add(nueva);
        
        System.out.println("Area agregada correctamente.");
    }
    
    public void mostrarTodasSkills(){
    
        LinkedList<Skill> listaSkills;
        Skill skill;
        
        for (int i = 0; i < listaAreas.size(); i++){
            
            listaSkills = listaAreas.get(i).getSkills();
            
            for (int j = 0; j < listaSkills.size(); j++){
                
                skill = listaSkills.get(j);
                System.out.println(skill.getNombre());
            }
        }
    }
    
    public void mostrarAreas(){
        if(listaAreas.isEmpty())
        {
            System.out.println("Aún no se ha agregado ninguna área.");
            return;
        }
        System.out.println("Las áreas existentes son: ");
        System.out.println();
        for (int i = 0; i < listaAreas.size(); i++){
            System.out.println(listaAreas.get(i).getNombre());
        }    
    }
    
    public void mostrarSkillsPorArea(){
    
        LinkedList<Skill> listaSkills;
        Skill skill;
        
        for (int i = 0; i < listaAreas.size(); i++){
            
            System.out.println(listaAreas.get(i).getNombre().toUpperCase());
            System.out.println();
            
            listaSkills = listaAreas.get(i).getSkills();
            
            for (int j = 0; j < listaSkills.size(); j++){
                
                skill = listaSkills.get(j);
                System.out.println(skill.getNombre());
            }
            System.out.println();
        }
    }
    
    public void agregarSkillAreaUsuario(){
        
        System.out.println("De las áreas existentes ingrese el área a la que desea agregar una nueva skill.");
        mostrarAreas();
        Scanner scn = new Scanner(System.in);
        String nombreArea = scn.nextLine();
        boolean flag = false;
        
        for (int i = 0; i < listaAreas.size(); i++){
            
            if(nombreArea.equals(listaAreas.get(i).getNombre())){
                
                LinkedList lista = listaAreas.get(i).getSkills();
                
                System.out.println("Ingrese el nombre de la nueva skill: ");
                
                String nombreSkill = scn.nextLine();
                Skill skillAux = new Skill();
                
                skillAux.agregarSkill(lista, nombreSkill, i+2);
                System.out.println("Skill agregada correctamente.");
                flag = true;
                break;
            }       
        }
        if (flag == false){
            System.out.println("Area inexsistente.");
        } 
    }

    public void eliminarArea(){

        if(listaAreas.isEmpty()){
            System.out.println("Aún no existen areas.");
            return;
        }

        Scanner scn = new Scanner(System.in);
        String eliminar;
        LinkedList<Curriculum> listaPost;

        System.out.println("De las siguientes areas seleccione la que desea eliminar:");

        mostrarAreas();

        eliminar = scn.nextLine();

        for (int i = 0; i < listaAreas.size(); i++){

            if(eliminar.equals(listaAreas.get(i).getNombre())){

                listaPost = listaAreas.get(i).getPostulantes();

                if(!listaPost.isEmpty()){

                    for (int j = 0; j < listaPost.size(); j++){

                        mapaPostulantes.remove(listaPost.get(j).getRut()); 
                    }
                }

                listaAreas.remove(i);
                System.out.println("Área eliminada correctamente.");
                return;
            }  
        }
    }
    
    // Relacionadas a Menu
    
    public void menu(){
        
        System.out.println("BOLSA DE TRABAJO");
        System.out.println();
                
        int opcion;
         do{
                mostrarOpciones();
                  
                Scanner scn = new Scanner(System.in);

                opcion = scn.nextInt();
                scn.nextLine();

                switch(opcion){

                    case 1:
                    {
                        agregarPostulanteUsuario();

                        break;
                    }

                    case 2:
                    {
                        System.out.println("Ingrese el rut del postulante a buscar (sin puntos y con guión): ");
                        String rut = scn.nextLine();

                        buscarPostulante(rut);  

                      break;
                    }

                    case 3:
                    {
                        mostrarPostulantesPorArea();

                        break;
                    }

                    case 4:
                    {
                        agregarAreaUsuario();
                        
                        break;
                    }

                    case 5:
                    {
                        mostrarAreas();
                        
                        break;
                    }

                    case 6:
                    {
                        agregarSkillAreaUsuario();

                        break;
                    }

                    case 7:
                    {
                        mostrarSkillsPorArea();

                        break; 
                    }

                    case 8:
                    {
                        eliminarArea();

                        break; 
                    }

                    case 9:
                    {
                        editarPostulante();

                        break; 
                    }

                    case 0:
                    {
                        System.out.println("Exit");

                        break;
                    }

                    default:
                        return;
                }
                
               System.out.println(); 
               
            } while(opcion != 0);
         }

    public void mostrarOpciones(){
       
        System.out.println("Elija una opcion para continuar: ");
        System.out.println("1.- Agregar postulante"); // Agrega a mapa de todos los postulantes y a lista de postulantes del area correspondiente
        System.out.println("2.- Buscar postulante"); //Busca postulante en mapa
        System.out.println("3.- Mostrar todos los postulantes"); //Recorre la lista de areas, y luego la lista de postulantes de cada una
        System.out.println("4.- Agregar área");
        System.out.println("5.- Mostrar todas las áreas");
        System.out.println("6.- Agregar skill a área");
        System.out.println("7.- Mostrar las skills de cada área");
        System.out.println("8.- Eliminar área");
        System.out.println("9.- Editar postulante");
        System.out.println("0.- Salir");
    }
}
