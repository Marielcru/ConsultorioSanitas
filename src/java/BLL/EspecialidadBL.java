/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.DAOException;
import DAL.EspecialidadDao;
import DAL.SQLConexion;
import Models.Especialidad;
import java.util.List;

/**
 *
 * @author Nadia
 */
public class EspecialidadBL {
    public EspecialidadBL(){}
    
     public Especialidad buscarEspecialidad(String nombre) throws DAOException {
        EspecialidadDao dao = new EspecialidadDao(SQLConexion.getInstance().getConnection()); //envia la conexion 
        List<Especialidad> lista = dao.obtenerTodos();
        for(Especialidad es: lista){
            if(es.getEspecialidad().equalsIgnoreCase(nombre)){
                return es;
                    }
        }
       // u=new Usuario("","","");
       
        return null;
     }
     
     public String getPage(String especialidad) {
        if (!especialidad.equals("")){
            return "/Administrador.html"; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }else{
            return "salio mal";
        }
    }
}
