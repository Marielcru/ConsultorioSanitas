/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.util.Date;

/**
 *
 * @author Nadia
 */
public class Turno {
     private int dni=0;
    private String especialidad=null;
    private String medico=null;
     private Date fecha=null;
     
     public Turno(int dni,String especialidad,String medico,Date fecha){
         this.dni=dni;
         this.especialidad=especialidad;
         this.medico=medico;
         this.fecha=fecha;
     }
     
     public int getDni(){
        return dni;
    }
    
    public void setDni(int dni){
        this.dni=dni;
    }
    
     public String getEspecialidad(){
        return especialidad;
    }
    
    public void setEspecialidad(String especialidad){
        this.especialidad=especialidad;
    }
    
    public String getMedico(){
        return medico;
    }
    
    public void setMedico(String medico){
        this.medico=medico;
    }
}
