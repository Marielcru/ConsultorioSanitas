/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.DAOException;
import DAL.MediDao;
import DAL.PersonaDao;
import DAL.SQLConexion;
import Models.Especialidad;
import Models.Medico;
import Models.Persona;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Marcos
 */
public class MediBL {
    private Medico m=null;
    public Medico buscarMedico(int dni) throws DAOException {
        MediDao dao = new MediDao(SQLConexion.getInstance().getConnection()); //envia la conexion 
        m = dao.obtener(dni);
       
        return m;
    
    } 
    
   
    public Medico ingresarNuevoMedico(String dni,String nombre, String apellido,String fechaNac,  String direccion, String telefono, String mail,String especialidad,String matricula) throws DAOException {
        PersonaDao daoPersona = new PersonaDao(SQLConexion.getInstance().getConnection()); 
        SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");
        Date fechaConvertida = null;

        try {
                   fechaConvertida =  dateFormat.parse(fechaNac);
        } catch(Exception e) {
            System.out.println("Error occurred"+ e.getMessage());
        }
        int idEspecialidad=0;
        Especialidad especialidades= new EspecialidadBL().buscarEspecialidad(especialidad);
            if (especialidades != null && especialidades.getEspecialidad().equals(especialidad)){
                
                idEspecialidad=especialidades.getidEspecialidad();
        }else{
                idEspecialidad=0;
            }
       
        Persona persona=new Persona(nombre,apellido,Integer.parseInt(dni),direccion,telefono,mail,2, fechaConvertida);
        daoPersona.insertar(persona);
        Medico medico=null;
        if(persona!= null){
        MediDao dao = new MediDao(SQLConexion.getInstance().getConnection()); //envia la conexion 
        medico = new Medico(nombre,apellido,Integer.parseInt(dni),direccion,telefono,mail,3, fechaConvertida,idEspecialidad,Integer.parseInt(matricula));
        dao.insertar(medico);
        }
       // u=new Usuario("","","");
       
        return medico;
    

    } 
    
    public String getPage(String medico) {
        if (!medico.equals("")){
            return "/Medico.html"; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }else{
            return "salio mal";
        }
        
    }
    
}
