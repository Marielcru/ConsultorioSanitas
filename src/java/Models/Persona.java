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
public class Persona {
    private int dni=0;
    private String nombre=null;
    private String apellido=null;
    private String direccion=null;
    private String telefono=null;
     private String mail=null;
     private int rol=0;
     private Date fechaNac=null;
    
    
    public Persona(String nombre,String apellido,int dni,String direccion,String telefono,String mail,int rol,Date fechaNac){
        this.nombre=nombre;
        this.apellido=apellido;
        this.dni=dni;
        this.direccion=direccion;
        this.telefono=telefono;
        this.mail=mail;
        this.rol=rol;
        this.fechaNac=fechaNac;
    }
    
    public int getDni(){
        return dni;
    }
    
    public void setDni(int dni){
        this.dni=dni;
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
    
     public int getRol(){
        return rol;
    }
    
    public void setRol(int rol){
        this.rol=rol;
    }
    
     public Date getFechaNac(){
        return fechaNac;
    }
    
    public void setFechaNac(Date fechaNac){
        this.fechaNac=fechaNac;
    }
    
    @Override
    public String toString(){
        return this.nombre;
    }
    
}
