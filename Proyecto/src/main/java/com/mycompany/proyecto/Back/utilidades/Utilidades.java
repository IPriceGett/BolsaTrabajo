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
import java.util.List;


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
    
    public Postulante crearPostulante(String nombre, String apellido, String rut, String genero, int edad, String correo, String telefono, int experiencia, String instituto, Skill skill){
        
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
        postulante.setSkill(skill);

        return postulante; 
    }
   
    //Relacionado a postulantes
    
    /*Se ha implementado el comparar las skills del postulante con las de cada area, pero, hasta ahora, al encontrar el primer
      "match", se guarda en esa area. Quizas mas adelante se podria crear una formula para que a diferencia de la version de ahora,
       quede en el area donde mas skills es comun tenga.
       Por lo tanto por mientras para testear el agregar postulantes se pide ingresar skills relacionadas a una sola area, ya que
       este sera ingresado al area con el que encuentre la primera skill en comun.
    */
    public void agregarPostulante(Postulante postulante){ // crea postulante y lo agrega al mapa de postulantes y a la lista del area correspondiente
        
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
    
    public void agregarPostulante(){ // para agregar postulante por entrada en pantalla
        
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
    
    public boolean eliminarPostulante(String rut){ // se elimina del mapa de todos los postulantes y de la lista del area correspondienter
        
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
    
     public boolean buscarPostulante(String rut){ // deberia cambiarse a metodo mostrarInfo
        
        if (!mapaPostulantes.containsKey(rut)){
            System.out.println("Postulante no encontrado.");
            return false;
        }
        
        Postulante postulante = mapaPostulantes.get(rut);
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
    
    public void mostrarPostulantesPorArea(){ // muestra todos los postulantes de cierta area
        
        if (mapaPostulantes.isEmpty())
        {
            System.out.println("Aún no se ha agregado ningún postulante.");
            return;
        }
        
        for (int i = 0; i < listaAreas.size(); i++){
            
            if(listaAreas.get(i).getLargoPostulantes() == 0){
                System.out.println("Esta área no tiene postulantes.");
                continue;
            }
            
            listaAreas.get(i).mostrarPostulantes();  
        }
    }

    public void editarPostulante(){ //Se puede editar cada uno de los parametros de un postulante, incluso sus skills.
        
        Scanner scn = new Scanner(System.in);
        String rut;
        System.out.println("Ingrese el rut del postulante a editar: ");
        rut = scn.nextLine();
        
        if(!mapaPostulantes.containsKey(rut)){
            System.out.println("Postulante no encontrado");
            return;
        }
        else{
            Postulante postulante = mapaPostulantes.get(rut);
            int opcion;
            System.out.println("Ingrese el numero del dato que desea editar. Para terminar ingrese '0': ");
            postulante.mostrarParametrosEnumerados();
            
            do{
                opcion = scn.nextInt();
                scn.nextLine();
                String auxStr;
                int auxInt;
                switch(opcion){
                    case 1:
                    {
                        System.out.println("Ingrese el nuevo nombre: ");
                        auxStr = scn.nextLine();
                        postulante.setNombre(auxStr);
                        System.out.println("Nombre editado correctamente");
                        break;
                    }
                    case 2:
                    {
                        System.out.println("Ingrese el nuevo apellido: ");
                        auxStr = scn.nextLine();
                        postulante.setApellido(auxStr);
                        System.out.println("Apellido editado correctamente");
                        break;
                    }
                    case 3:
                    {
                        System.out.println("Ingrese el nuevo rut: ");
                        auxStr = scn.nextLine();
                        postulante.setRut(auxStr);
                        System.out.println("Rut editado correctamente");
                        break;
                    }
                    case 4:
                    {
                        System.out.println("Ingrese el nuevo genero: ");
                        auxStr = scn.nextLine();
                        postulante.setGenero(auxStr);
                        System.out.println("Genero editado correctamente");
                        break;
                    }
                    case 5:
                    {
                        System.out.println("Ingrese la nueva edad: ");
                        auxInt = scn.nextInt();
                        scn.nextLine();
                        postulante.setEdad(auxInt);
                        System.out.println("Edad editada correctamente");
                        break;
                    }
                    case 6:
                    {
                        System.out.println("Ingrese el nuevo correo: ");
                        auxStr = scn.nextLine();
                        postulante.setCorreo(auxStr);
                        System.out.println("Correo editado correctamente");
                        break;
                    }
                    case 7:
                    {
                        System.out.println("Ingrese el nuevo telefono: ");
                        auxStr = scn.nextLine();
                        postulante.setTelefono(auxStr);
                        System.out.println("Telefono editado correctamente");
                        break;
                    }
                    case 8: // 
                    {
                        System.out.println("A continuacion se mostraran las skills actuales del postulante.");
               
                        int opcion2;
                        
                        do{
                            if(postulante.getLargoSkills() == 0){
                                System.out.println("Este postulante no tiene skills ingresadas.");
                                break;
                            }
                                
                            for (int j = 0; j < postulante.getLargoSkills(); j++)
                            {
                                System.out.println((j+1) + ".- " + postulante.getSkill(j).getNombre());
                            }
                            System.out.println("Ingrese el numero de la skill que desee eliminar. Para continuar ingrese '999': ");
                            
                            opcion2 = scn.nextInt();
                            scn.nextLine();
                            if(opcion2 == 999) break;
                            opcion2--;
                            postulante.removeSkill(opcion2);
                        }while(opcion2 != 999);
                        
                        System.out.println("De la siguiente lista, ingrese, una por una, las skills que desea agregar. Cuando haya terminado, ingrese '0' ");
        
                        this.mostrarTodasSkills();

                        String nombreSkill = "aux";

                        while (!nombreSkill.equals("0")){ // agregar una por una. Falta checkear que no se repitan
                            nombreSkill = scn.nextLine();
                            if (nombreSkill.equals("0")){ 
                                break;
                            }

                            Skill nueva = new Skill(nombreSkill);
                            postulante.setSkill(nueva);
                        }


                        //Se eliminar y se reingresa el postulante con las nuevas skills
                        this.eliminarPostulante(postulante.getRut());
                        this.agregarPostulante(postulante);

                        break;
                    }
                    case 9:
                    {
                        System.out.println("Ingrese los años de experiencia: ");
                        auxInt = scn.nextInt();
                        scn.nextLine();
                        postulante.setExperiencia(auxInt);
                        System.out.println("Años de experiencia editados correctamente");
                        break;
                    }
                    case 10:
                    {
                        System.out.println("Ingrese el nuevo instituto educacional: ");
                        auxStr = scn.nextLine();
                        postulante.setInstituto(auxStr);
                        System.out.println("Instituto educacional editado correctamente");
                        break;
                    }
                    case 11:
                    {
                        System.out.println("Ingrese la nueva espectativa de sueldo: ");
                        auxInt = scn.nextInt();
                        scn.nextLine();
                        postulante.setExpectativa(auxInt);
                        System.out.println("Expectativa de sueldo editada correctamente");
                        break;
                    }
                }
            }while(opcion != 0);
        } 
    }

    /*public void agregarPostulantes(LinkedList postulantes){ 
        
        for(int i = 0; i< postulantes.size(); i++){
            eliminarPostulante((String) postulantes.get(i));
            agregarPostulante((Postulante) postulantes.get(i));
        }
    }*/
    
    public Postulante obtenerMejorPostulanteAreas(){ // Muestra al postulante con el mejor puntaje
        
        Postulante aux = new Postulante();
        aux = listaAreas.get(0).top();
        for(int i=0; i< listaAreas.size() -1 ; i++ ){
            if(aux.getPuntaje() <= listaAreas.get(i+1).top().getPuntaje()){
               aux = listaAreas.get(i+1).top(); 
            }
        }
        return aux;
    }

    public Postulante obtenerPeorPostulanteAreas(){ // Muestra al postulante con el peor puntaje
        
        Postulante aux = new Postulante();
        aux = listaAreas.get(0).noTop();
        for(int i=0; i< listaAreas.size() -1 ; i++ ){
            if(aux.getPuntaje() >= listaAreas.get(i+1).noTop().getPuntaje()){
               aux = listaAreas.get(i+1).noTop(); 
            }
        }
        return aux;
    }

    public int obtenerMejorExpectativaAreas(){ // Muestra al postulante con la expectativa de sueldo mas alta
        
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
    
    public void mostrarSobreXPuntaje(int minimo){ // Muestra todos los postulantes con un puntaje superior a un numero ingresado por el usuario
        
        if (mapaPostulantes.isEmpty())
        {
            System.out.println("Aún no se ha agregado ningún postulante.");
            return;
        }

        System.out.println("Los postulantes con un puntaje superior a " + minimo + " son: ");
        
        for (int i = 0; i < listaAreas.size(); i++){
            
            if(listaAreas.get(i).getLargoPostulantes() == 0)
            {
                continue;
            }
            
            listaAreas.get(i).mostrarSobreXPuntaje(minimo);
        }
    }
    
    public void sueldoInferiorA(int maximo){ // Muestra todos los postulantes con una expectativa de sueldio inferior a un numero ingresado por el usuario
        
        if (mapaPostulantes.isEmpty())
        {
            System.out.println("Aún no se ha agregado ningún postulante.");
            return;
        }
        
        System.out.println("Los postulantes con una expectativa de sueldo inferior a " + maximo + " son: ");
        
        for (int i = 0; i < listaAreas.size(); i++){

            if(listaAreas.get(i).getLargoPostulantes() == 0)
            {
                continue;
            }
            
            listaAreas.get(i).sueldoInferiorA(maximo);
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
        
        for (int i = 0; i < listaAreas.size(); i++){
            
            listaAreas.get(i).mostrarSkills();
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

    public void editarArea(){ //falta reingresar postulantes al editar las skills de un area
        
        if(listaAreas.isEmpty()){
            System.out.println("Aun no existen areas para editar.");
            return;
        }
        else{
            mostrarAreas();
            System.out.println("Ingrese el nombre del area a editar: ");
            Scanner scn = new Scanner(System.in);
            String nombre = scn.nextLine();
            
            for (int i = 0; i < listaAreas.size() ; i++) {
                if(nombre.toLowerCase().equals(listaAreas.get(i).getNombre().toLowerCase())){
                    int opcion;
                    System.out.println("Ingrese el numero del dato que desea editar. Para terminar ingrese '0': ");
                    listaAreas.get(i).mostrarParametrosEnumerados();

                    do{
                        opcion = scn.nextInt();
                        scn.nextLine();
                        String auxStr;
                        int auxInt;
                        switch(opcion){
                            case 1:
                            {
                                System.out.println("Ingrese el nuevo nombre: ");
                                auxStr = scn.nextLine();
                                listaAreas.get(i).setNombre(auxStr);
                                System.out.println("Nombre editado correctamente");
                                break;
                            }
                            case 2:
                            {
                                System.out.println("Ingrese la nueva cantidad de vacantes: ");
                                auxInt = scn.nextInt();
                                scn.nextLine();
                                listaAreas.get(i).setVacantes(auxInt);
                                System.out.println("Cantidad de vacantes editada correctamente");
                                break;
                            }
                            case 3:
                            {
                                System.out.println("Ingrese la nueva cantidad total de puestos: ");
                                auxInt = scn.nextInt();
                                scn.nextLine();
                                listaAreas.get(i).setTotal(auxInt);
                                System.out.println("Cantidad de puestos editada correctamente");
                                break;
                            }
                            case 4:
                            {   
                                System.out.println("Ingrese el numero de la skill que desea editar. Para terminar ingrese '999': ");
                                
                                for (int j = 0; j < listaAreas.get(i).getLargoSkills(); j++)
                                {
                                    System.out.println((j+1) + ".- " + listaAreas.get(i).getSkill(j).getNombre());
                                }
                                int index = scn.nextInt();
                                scn.nextLine();
                                if(index == 999) break;
                                index--;
                                Skill skill = listaAreas.get(i).getSkill(index);
                                
                                System.out.println("Ingrese el numero del parametro que desea editar. Para terminar ingrese '0': ");
                                skill.mostrarParametrosEnumerados();
                                
                                int opcion2; 
                                
                                do{
                                    opcion2 = scn.nextInt();
                                    scn.nextLine();
                                    
                                    switch(opcion2){
                                        case 1:{
                                            
                                        }
                                        case 2:{
                                            System.out.println("Ingrese la valor de la skill para el calculo del puntaje: ");
                                            auxInt = scn.nextInt();
                                            scn.nextLine();
                                            skill.setValor(auxInt);
                                            System.out.println("Valor editado correctamente");
                                            break;
                                        }
                                    }
                                }while(opcion2 != 0);
                                
                            }         
                        }
                    }while(opcion != 0);
                }
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
    
    public List<Postulante> obtenerPostulantes (){
        List<Postulante> listOfValue = new LinkedList<>(mapaPostulantes.values());
        return listOfValue;
    }
}