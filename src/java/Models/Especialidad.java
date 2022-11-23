/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author Nadia
 */
public class Especialidad {
     private int idEspecialidad;
    private String especialidad;
    
    public Especialidad(int idEspecialidad,String nombreEspecialidad){
       this.idEspecialidad=idEspecialidad;
       this.especialidad=especialidad;  
    }
     
     public int getidEspecialidad(){
        return idEspecialidad;
    }
    
    public void setidEspecialidad(int idEspecialidad){
        this.idEspecialidad=idEspecialidad;
    }
   
     public String getEspecialidad(){
        return especialidad;
    }
    
    public void setEspecialidad(String especialidad){
        this.especialidad=especialidad;  
    }
}
