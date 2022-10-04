/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author Marcos
 */
public class Medico {
    
    private int id;
    private int DNI;
    private String nombre="";
    private String apellido="";
    
    public Medico(int idDNI){
        this.DNI=idDNI;
        
    }

    public Medico() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public int getId(){
        return id;
    }
    
    public void setId(int id){
        this.id=id;
    }
    
    public int getidDNI(){
        return DNI;
    }
    
    public void setiddni(int idDNI){
        this.DNI=idDNI;
    }
    
    public String getnombre(){
        return nombre;
    }
    
    public void setnombre(String nombre){
        this.nombre=nombre;
    }
    
    public String getapellido(){
        return apellido;
    }
    
    public void setapellido(String apellido){
        this.apellido=apellido;
    }
    
    @Override
    public String toString(){
        return this.nombre;
    }
    
}
