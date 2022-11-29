/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.DAOException;
import DAL.SQLConexion;
import DAL.OSocialDao;
import DAL.PersonaDao;
import Models.ObraSocial;
import java.util.List;

/**
 *
 * @author Nadia
 */
public class ObraSocialBL {
    //private ObraSocial o=null;
    
    public ObraSocialBL(){}
    
    public ObraSocial buscarOSocial(String nombre) throws DAOException {
        OSocialDao dao = new OSocialDao(SQLConexion.getInstance().getConnection()); //envia la conexion 
        List<ObraSocial> lista = dao.obtenerTodos();
        for(ObraSocial os: lista){
            if(os.getNombreOS().equalsIgnoreCase(nombre)){
                return os;
                    }
        }
       // u=new Usuario("","","");
       
        return null;
    

    }

     public ObraSocial ingresarObraSocial(int id,String nombre) throws DAOException{
         OSocialDao dao = new OSocialDao(SQLConexion.getInstance().getConnection()); 
         ObraSocial oSocial = new ObraSocial(id,nombre);
         dao.insertar(oSocial);
         return oSocial;
     }
    public String getPage(String obraSocial) {
        if (!obraSocial.equals("")){
            return "/Administrador.html"; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }else{
            return "salio mal";
        }
    }
        
}
