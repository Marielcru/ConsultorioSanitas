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
public class Medico extends Persona {
    private String nombre;
     private String apellido;
     private int dni;
     private String direccion;
     private String telefono;
     private String mail;
     private int rol;
      private Date fechaNac;
    private int matricula;
     private int idEspecialidad;
    
    public Medico(String nombre, String apellido, int dni, String direccion, String telefono, String mail, int rol, Date fechaNac,int idEspecialidad,int matricula) {
        super(nombre, apellido, dni, direccion, telefono, mail, rol, fechaNac);
        this.nombre=nombre;
        this.apellido=apellido;
        this.dni=dni;
        this.direccion=direccion;
        this.telefono=telefono;
        this.mail=mail;
        this.rol=rol;
        this.fechaNac=fechaNac;
        this.matricula=matricula;
        this.idEspecialidad=idEspecialidad;
    }
    
    public int getiddni(){
        return dni;
    }
    
    public void setiddni(int iddni){
        dni=iddni;
    }
    
     public int getMatricula(){
        return matricula;
    }
    
    public void setMatricula(int matricula){
        this.matricula=matricula;
    }
   
     public int getidEspecialidad(){
        return idEspecialidad;
    }
    
    public void setidEspecialidad(int idEspecialidad){
         this.idEspecialidad=idEspecialidad;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    
     public String getApellido(){
        return apellido;
    }
    
    public void setApellido(String apellido){
        this.apellido=apellido;
    }
    
    public String getDireccion(){
        return direccion;
    }
    
    public void setDireccion(String direccion){
        this.direccion=direccion;
    }
    
    public String getTelefono(){
        return telefono;
    }
    
    public void setTelefono(String telefono){
        this.telefono=telefono;
    }
    
    public String getMail(){
        return mail;
    }
    
    public void setMail(String mail){
        this.mail=mail;
    }
    
    public Date getFechaNac(){
        return fechaNac;
    }
    
    public void setMail(Date fechaNac){
        this.fechaNac=fechaNac;
    }
    
    
}
