/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto.Front;

import com.mycompany.proyecto.Back.clases.Postulante;
import com.mycompany.proyecto.Back.interfaces.Utiles;
import java.util.List;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 *
 * @author igale
 */
public class TPostulantes implements TableModel{
    
    private Utiles instancia;
    private List<Postulante> list;
    public TPostulantes(Utiles instancia){
        this.instancia = instancia;
        this.list = instancia.obtenerPostulantes();
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 9;
    }

    @Override
    public String getColumnName(int columnIndex) {
        String titulo = "";
        switch(columnIndex){
            case 0:{
                titulo =  "Nombre";
                break;
            }
            case 1:{
                titulo =  "Apellido";
                break;
            }
            case 2:{
                titulo =  "RUT";
                break;
            }
            case 3:{
                titulo =  "Genero";
                break;
            }
            case 4:{
                titulo =  "Edad";
                break;
            }
            case 5:{
                titulo =  "Correo";
                break;
            }
            case 6:{
                titulo =  "Telefono";
                break;
            }
            case 7:{
                titulo =  "Experiencia";
                break;
            }
            case 8:{
                titulo =  "Instituto";
                break;
            }
        }
        return titulo;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Postulante p = list.get(rowIndex);
        String valor = "";
        switch(columnIndex){
            case 0:{
                valor =  p.getNombre();
                break;
            }
            case 1:{
                valor =  p.getApellido();
                break;
            }
            case 2:{
                valor =  p.getRut();
                break;
            }
            case 3:{
                valor =  p.getGenero();
                break;
            }
            case 4:{
                int edad =  p.getEdad();
                valor = Integer.toString(edad);
                break;
            }
            case 5:{
                valor =  p.getCorreo();
                break;
            }
            case 6:{
                valor =  p.getTelefono();
                break;
            }
            case 7:{
                valor =  Integer.toString(p.getExperiencia());
                break;
            }
            case 8:{
                valor =  p.getInstituto();
                break;
            }
        }
        return valor;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        
    }

    @Override
    public void addTableModelListener(TableModelListener l) {
        
    }

    @Override
    public void removeTableModelListener(TableModelListener l) {
        
    }
    
}
