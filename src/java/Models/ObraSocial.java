/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author Nadia
 */
public class ObraSocial {
    private int idOSocial;
    private String nombreOS;
    
    public ObraSocial() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
     public ObraSocial(int id,String nombreOS){
       this.idOSocial=idOSocial;
       this.nombreOS=nombreOS;  
    }
     
     public int getidOSocial(){
        return idOSocial;
    }
    
    public void setidOSocial(int idOSocial){
        this.idOSocial=idOSocial;
    }
   
     public String getNombreOS(){
        return nombreOS;
    }
    
    public void setNombreOS(String nombreOS){
        this.nombreOS=nombreOS;
    }
}
