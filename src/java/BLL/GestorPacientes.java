/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

/**
 *
 * @author Marcos
 */

import DAL.DAOException;
import DAL.SQLConexion;
import DAL.PaciDao;
import DAL.PersonaDao;
import Models.ObraSocial;
import Models.Paciente;
import Models.Persona;
import java.util.Date;
import java.text.SimpleDateFormat;


//import java.util.Scanner;

//
public class GestorPacientes {
    private Paciente p=null;
    public Paciente buscarPacientes(int dni) throws DAOException {
        PaciDao dao = new PaciDao(SQLConexion.getInstance().getConnection()); //envia la conexion 
        p = dao.obtener(dni);
       
        return p;
    
    } 
    
   
    public Paciente ingresarNuevoPaciente(String dni,String nombre, String apellido,String fechaNac,  String direccion, String telefono, String mail,String obraSocial) throws DAOException {
        PersonaDao daoPersona = new PersonaDao(SQLConexion.getInstance().getConnection()); 
        SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");
        Date fechaConvertida = null;

        try {
                   fechaConvertida =  dateFormat.parse(fechaNac);
        } catch(Exception e) {
            System.out.println("Error occurred"+ e.getMessage());
        }
        int idOS=0;
        ObraSocial oSocial = new ObraSocialBL().buscarOSocial(obraSocial);
            if (oSocial != null && oSocial.getNombreOS().equalsIgnoreCase(obraSocial)){
                
                idOS=oSocial.getidOSocial();
        }else{
                idOS=0;
            }
        Persona persona=new Persona(nombre,apellido,Integer.parseInt(dni),direccion,telefono,mail,3, fechaConvertida);
        daoPersona.insertar(persona);
        Paciente paciente=null;
        if(persona!= null){
        PaciDao dao = new PaciDao(SQLConexion.getInstance().getConnection()); //envia la conexion 
        paciente = new Paciente(nombre,apellido,Integer.parseInt(dni),direccion,telefono,mail,3, fechaConvertida,idOS);
        dao.insertar(paciente);
        }
       // u=new Usuario("","","");
       
        return paciente;
    

    } 
    
    public String getPage(String paciente) {
        if (!paciente.equals("")){
            return "/Paciente.html"; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }else{
            return "salio mal";
        }
        
    }
 //chekear por dni
    
   
  //llamar al metodo obtener por id 
    //que esta en la clase usuarioDao

}
