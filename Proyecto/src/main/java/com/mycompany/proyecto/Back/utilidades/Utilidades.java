/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.proyecto.Back.utilidades;
import com.mycompany.proyecto.Back.clases.*;
import com.mycompany.proyecto.Back.interfaces.*;

/**
 *
 * @author Ignacio
 */

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Comparator;


public class Utilidades implements Utiles{
    
    private HashMap<String, Postulante> mapaPostulantes = new HashMap<String, Postulante>(); 
    private LinkedList<Area> listaAreas = new LinkedList<Area>(); 

    public Postulante crearPostulante(String nombre, String apellido, String rut, String genero, int edad, String correo, String telefono, int experiencia, String instituto){
        
        Postulante postulante = new Postulante();
        postulante.setNombre(nombre);
        postulante.setApellido(apellido);
        postulante.setRut(rut);
        postulante.setGenero(genero);
        postulante.setEdad(edad);
        postulante.setCorreo(correo);
        postulante.setTelefono(telefono);
        postulante.setExperiencia(experiencia);
        postulante.setInstituto(instituto);

        return postulante; 
    }
   
    //Relacionado a postulantes
    
    /*Se ha implementado el comparar las skills del postulante con las de cada area, pero, hasta ahora, al encontrar el primer
      "match", se guarda en esa area. Quizas mas adelante se podria crear una formula para que a diferencia de la version de ahora,
       quede en el area donde mas skills es comun tenga.
       Por lo tanto por mientras para testear el agregar postulantes se pide ingresar skills relacionadas a una sola area, ya que
       este sera ingresado al area con el que encuentre la primera skill en comun.
    */
    public void agregarPostulante(Postulante postulante){
        
        if (mapaPostulantes.containsKey(postulante.getRut())){
            System.out.println("Este postulante ya se encuentra en nuestra base de datos.");
            return;
        }
        
        Area area;
        
        Skill skillP;
        Skill skillA;
        
        calcularPuntaje(postulante);
        
        for (int i = 0; i < listaAreas.size(); i++){
            
            area = listaAreas.get(i);
            
            for (int j = 0; j < area.getLargoSkills(); j++){
                
                skillA = area.getSkill(j);
                
                for (int k = 0; k < postulante.getLargoSkills(); k++){
                    
                    skillP = postulante.getSkill(k);
                    
                    if (skillP.getNombre().equals(skillA.getNombre())){
                        
                        area.add(postulante);
                        k = postulante.getLargoSkills() + 1;
                        j = area.getLargoSkills() + 1;
                        i = listaAreas.size() + 1;
                    }
                }
            }
        }
        
        // aki falta ordenar la lista
        
        mapaPostulantes.put(postulante.getRut(), postulante);
        
        System.out.println("Postulante añadido.");
    }
    
    public void agregarPostulanteUsuario(){
        
        Scanner scn = new Scanner(System.in);
        Postulante postulante = new Postulante();
        
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
        postulante.setExperiencia(scn.nextInt());
        scn.nextLine();
        System.out.println("Institucion Educacional: ");
        postulante.setInstituto(scn.nextLine());
        
        //Agregar skills
        
        System.out.println("De la siguiente lista, ingrese, una por una, las skills que maneja. Cuando haya terminado, ingrese '0' ");
        
        this.mostrarTodasSkills();
        
        String nombreSkill = "aux";
        
        while (!nombreSkill.equals("0")){ // agregar una por una
            nombreSkill = scn.nextLine();
            if (nombreSkill.equals("0")){ 
                break;
            }
            
            Skill nueva = new Skill(nombreSkill);
            postulante.setSkill(nueva);
        }
        
        
        //Agregar postulante recien creado
        this.agregarPostulante(postulante);   
    }

    public void calcularPuntaje(Postulante postulante){ // Por el momento asigna un numero random, se tiene que crear formula para calcular puntaje
        
        int puntaje = (int) Math.floor(Math.random()*(100-1+1)+1);
        postulante.setPuntaje(puntaje);
    }
    
    public boolean eliminarPostulante(String rut){
        
        if (!mapaPostulantes.containsKey(rut)){
            return false;
        }
        mapaPostulantes.remove(rut);
        
        Postulante postulante = new Postulante();
        
        for(int i = 0; i < listaAreas.size() ; i++){
            for(int j = 0; j < listaAreas.get(i).getLargoPostulantes(); j++){
                postulante = listaAreas.get(i).getPostulante(j);
                if(postulante.getRut().equals(rut)){
                    listaAreas.get(i).removePostulante(j);
                    break;
                }
            }
        }
        return true;
    }
    
     public boolean buscarPostulante(String rut){
        
        if (!mapaPostulantes.containsKey(rut)){
            System.out.println("Postulante no encontrado.");
            return false;
        }
        
        Postulante postulante = (Postulante) mapaPostulantes.get(rut);
        System.out.println("Nombre: " + postulante.getNombre() + " " + postulante.getApellido());
        System.out.println("Rut: " + postulante.getRut());
        System.out.println("Genero: " + postulante.getGenero());
        System.out.println("Edad: " + postulante.getEdad());
        System.out.println("Correo: " + postulante.getCorreo());
        System.out.println("Telefono: " + postulante.getTelefono());
        System.out.println("Años de experiencia: " + postulante.getExperiencia());
        System.out.println("Institucion Educacional: " + postulante.getInstituto());
        System.out.println("Puntaje: " + postulante.getPuntaje());

        System.out.print("Skills: ");
        for (int i = 0; i < postulante.getLargoSkills(); i++){
            System.out.print(postulante.getSkill(i).getNombre() + " ");
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
        
        Postulante postulante;
        
        for (int i = 0; i < listaAreas.size(); i++){
            
            System.out.println(listaAreas.get(i).getNombre().toUpperCase());
            
            
            if(listaAreas.get(i).getLargoPostulantes() == 0){
                System.out.println("Esta área no tiene postulantes.");
                continue;
            }
            
            System.out.println("Nombre completo        RUT      Puntaje de postulacion     Expectativa de sueldo");
            
            for (int j = 0; j < listaAreas.get(i).getLargoPostulantes(); j++){
                
                postulante = listaAreas.get(i).getPostulante(j);
                postulante.mostrarInfo();
            }
        }
    }

    public void editarPostulante(){ // ojo aqui editar un solo parametro no borrar y agregar de 0
        
        Scanner scn = new Scanner(System.in);
        String rut;

        System.out.println("Ingrese el rut del postulante a editar: ");
        rut = scn.nextLine();
        if(mapaPostulantes.containsKey(rut)){
            this.eliminarPostulante(rut);
            Postulante postulante = new Postulante();
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
            postulante.setExperiencia(scn.nextInt());
            scn.nextLine();
            System.out.println("Institucion Educacional: ");
            postulante.setInstituto(scn.nextLine());
            agregarPostulante(postulante);
            System.out.println("De la siguiente lista, ingrese, una por una, las skills que maneja. Cuando haya terminado, ingrese '0' ");
        
        this.mostrarTodasSkills();
        
        String nombreSkill = "aux";
        
        while (!nombreSkill.equals("0")){
            nombreSkill = scn.nextLine();
            if (nombreSkill.equals("0")){
                break;
            }
            
            Skill nueva = new Skill(nombreSkill);
            postulante.setSkill(nueva);
        }
        
       
        }
    }

    public void agregarPostulantes(LinkedList postulantes){
        
        for(int i = 0; i< postulantes.size(); i++){
            eliminarPostulante((String) postulantes.get(i));
            agregarPostulante((Postulante) postulantes.get(i));
        }
    }
    
    public Postulante obtenerMejorPostulanteAreas(){
        
        Postulante aux = new Postulante();
        aux = listaAreas.get(0).top();
        for(int i=0; i< listaAreas.size() -1 ; i++ ){
            if(aux.getPuntaje() <= listaAreas.get(i+1).top().getPuntaje()){
               aux = listaAreas.get(i+1).top(); 
            }
        }
        return aux;
    }

    public Postulante obtenerPeorPostulanteAreas(){
        
        Postulante aux = new Postulante();
        aux = listaAreas.get(0).noTop();
        for(int i=0; i< listaAreas.size() -1 ; i++ ){
            if(aux.getPuntaje() >= listaAreas.get(i+1).noTop().getPuntaje()){
               aux = listaAreas.get(i+1).noTop(); 
            }
        }
        return aux;
    }

    public int obtenerMejorExpectativaAreas(){
        
        Postulante aux = new Postulante();
        aux = listaAreas.get(0).mejorExpectativa();
        for(int i=0; i< listaAreas.size() -1 ; i++ ){
            if(aux.getExpectativa() <= listaAreas.get(i+1).mejorExpectativa().getExpectativa()){
               aux = listaAreas.get(i+1).mejorExpectativa(); 
            }
        }
        return aux.getExpectativa();
    }

    public int obtenerPeorExpectativaAreas(){
        
        Postulante aux = new Postulante();
        aux = listaAreas.get(0).peorExpectativa();
        for(int i=0; i< listaAreas.size() -1 ; i++ ){
            if(aux.getExpectativa() >= listaAreas.get(i+1).peorExpectativa().getExpectativa()){
               aux = listaAreas.get(i+1).peorExpectativa(); 
            }
        }
        return aux.getExpectativa();
    }
    
    public void mostrarSobreXPuntaje(int minimo){
        
        if (mapaPostulantes.isEmpty())
        {
            System.out.println("Aún no se ha agregado ningún postulante.");
            return;
        }

        Postulante postulante;
        int cont;
        
        System.out.println("Los postulantes con un puntaje superior a " + minimo + " son: ");
        
        for (int i = 0; i < listaAreas.size(); i++){
            
            if(listaAreas.get(i).getLargoPostulantes() == 0)
            {
                continue;
            }
            
            System.out.println(listaAreas.get(i).getNombre().toUpperCase());
            cont = 0;
            
            for (int j = 0; j < listaAreas.get(i).getLargoPostulantes(); j++){
                postulante = listaAreas.get(i).getPostulante(j);
                
                if(postulante.getPuntaje() > minimo){
                    System.out.println(postulante.getNombre() + " " + postulante.getApellido() + ", " + postulante.getPuntaje() + " puntos.");
                    cont++;
                }     
            }
            
            if(cont == 0)
                System.out.println("No existen postulantes que cumplan el requisito.");
        }
    }
    
    public void sueldoInferiorA(int maximo){
        
        if (mapaPostulantes.isEmpty())
        {
            System.out.println("Aún no se ha agregado ningún postulante.");
            return;
        }

        Postulante postulante;
        int cont;
        
        System.out.println("Los postulantes con una expectativa de sueldo inferior a " + maximo + " son: ");
        
        for (int i = 0; i < listaAreas.size(); i++){

            if(listaAreas.get(i).getLargoPostulantes() == 0)
            {
                continue;
            }
            
            System.out.println(listaAreas.get(i).getNombre().toUpperCase());
            cont = 0;
            
            for (int j = 0; j < listaAreas.get(i).getLargoPostulantes(); j++){
                postulante = listaAreas.get(i).getPostulante(j);
                
                if(postulante.getExpectativa() < maximo){
                    System.out.println(postulante.getNombre() + " " + postulante.getApellido() + ", con una expectativa de sueldo de " + postulante.getExpectativa());
                    cont++;
                }     
            }
            
            if(cont == 0)
                System.out.println("No existen postulantes que cumplan el requisito.");
        }
    }
    
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
        String nombreSkill = "aux";
        
        System.out.println("Ingrese, una por una, las skills necesarias para trabajar en esta área. Para terminar ingrese '0'.");
        
        Area area = new Area();
        area.setNombre(nombre);
        area.setTotal(total);
        
        while (!nombreSkill.equals("0")){ // ojo aki como crear una skill cada vez???
            nombreSkill = scn.nextLine();
            if (nombreSkill.equals("0")){
                break;
            }
            
            Skill nueva = new Skill(nombreSkill);
            area.setSkill(nueva);
        }
    
        listaAreas.add(area);
        
        System.out.println("Area agregada correctamente.");
    }
    
    public void mostrarTodasSkills(){
    
        Skill skill;
        
        for (int i = 0; i < listaAreas.size(); i++){
            
            for (int j = 0; j < listaAreas.get(i).getLargoSkills(); j++){
                
                skill = listaAreas.get(i).getSkill(j);
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
        System.out.println();    
    }
    
    public void mostrarSkillsPorArea(){
    
        Skill skill;
        
        for (int i = 0; i < listaAreas.size(); i++){
            
            System.out.println(listaAreas.get(i).getNombre().toUpperCase());
            System.out.println();
            
            for (int j = 0; j < listaAreas.get(i).getLargoSkills(); j++){
                
                skill = listaAreas.get(i).getSkill(j);
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
                
                System.out.println("Ingrese el nombre de la nueva skill: ");
                
                String nombreSkill = scn.nextLine();
                Skill skillAux = new Skill(nombreSkill);
                
                listaAreas.get(i).setSkill(skillAux);
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

        System.out.println("De las siguientes areas seleccione la que desea eliminar:");

        mostrarAreas();

        eliminar = scn.nextLine();

        for (int i = 0; i < listaAreas.size(); i++){

            if(eliminar.equals(listaAreas.get(i).getNombre())){

                if(listaAreas.get(i).getLargoPostulantes() != 0){

                    for (int j = 0; j < listaAreas.get(i).getLargoPostulantes(); j++){

                        mapaPostulantes.remove(listaAreas.get(i).getPostulante(j).getRut()); 
                    }
                }

                listaAreas.remove(i);
                System.out.println("Área eliminada correctamente.");
                return;
            }  
        }
    }

    public void editarArea(){ // se puede editar mas que el nombre
        
        if(listaAreas.isEmpty()){
            System.out.println("Aun no existen areas para editar.");
            return;
        }

        Scanner scn = new Scanner(System.in);
        String nombre;
        String nuevo;

        mostrarAreas();
        System.out.println("Ingrese el nombre del area a editar: ");
        nombre = scn.nextLine();

        for (int i = 0; i < listaAreas.size() ; i++) {
            if(nombre.equals(listaAreas.get(i).getNombre())){
                System.out.println("Ingrese el nuevo nombre: ");
                nuevo = scn.nextLine();
                listaAreas.get(i).setNombre(nuevo);
                System.out.println("Area editada correctamente.");
                return;
            }
        }
    }

    // Relacionados a Skill
    /*
    public void editarSkillArea(String nombreArea, String nombreAntiguo, String nombreNuevo){
        
        LinkedList aux;
        for(int i = 0; i< listaAreas.size(); i++){
            if(listaAreas.get(i).getNombre().equals(nombreArea)){
                for(int j = 0; j< listaAreas.get(i).getSkills().size(); j++){
                    if(((Skill)listaAreas.get(i).getSkills().get(j)).getNombre().equals(nombreAntiguo)){
                       ((Skill)listaAreas.get(i).getSkills().get(j)).setNombre(nombreNuevo);
                       aux = listaAreas.get(i).getPostulantes();
                       listaAreas.get(i).getPostulantes().clear();
                       agregarPostulantes(aux);
                    }
                }
            }
        }
    }
    public void eliminarSkillArea(String nombreArea, String nombreSkill){
        
        LinkedList aux;
        for(int i = 0; i< listaAreas.size(); i++){
            if(listaAreas.get(i).getNombre().equals(nombreArea)){
                for(int j = 0; j< listaAreas.get(i).getSkills().size(); j++){
                    if(((Skill)listaAreas.get(i).getSkills().get(j)).getNombre().equals(nombreSkill)){
                       listaAreas.get(i).getSkills().remove(j);
                       aux = listaAreas.get(i).getPostulantes();
                       listaAreas.get(i).getPostulantes().clear();
                       agregarPostulantes(aux);
                    }
                }
            }
        }
    }*/
}