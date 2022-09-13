/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author Marcos
 */
public class Paciente {
    //caracteristicas de la base de datos... datos que necesito de la base de datos
    //usamos interfaz para obligar a la clase implementar nos aseguramos que esten todos los metodos del DAO

    private int id;
    private int dni;
    private String nombre="";
    private String apellido="";
    
    public Paciente(int iddni){
        this.dni=iddni;
        }
    
    public int getId(){
        return id;
    }
    
    public void setId(int id){
        this.id=id;
    }
    
    public int getiddni(){
        return dni;
    }
    
    public void setiddni(int iddni){
        this.dni=iddni;
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


