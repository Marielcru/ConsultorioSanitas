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
    private int idTurno=0;
     private int dni=0;
    private String especialidad=null;
    private String medico=null;
     private Date fecha=null;
      private String hora=null;
     
     public Turno(int dni,String especialidad,String medico,Date fecha,String hora){
         this.dni=dni;
         this.especialidad=especialidad;
         this.medico=medico;
         this.fecha=fecha;
         this.hora=hora;
     }
     
     public int getIdTurno(){
        return idTurno;
    }
    
    public void setIdTurno(int idTurno){
        this.idTurno=idTurno;
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
    
    public Date getFecha(){
        return fecha;
    }
    
    public void setFecha(Date fecha){
        this.fecha=fecha;
    }
    
    public String getHora(){
        return hora;
    }
    
    public void setHora(String hora){
        this.hora=hora;
    }
}
