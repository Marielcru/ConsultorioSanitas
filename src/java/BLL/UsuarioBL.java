package BLL;

import DAL.DAOException;
import DAL.SQLConexion;
import DAL.UsuarioDAO;
import Models.Usuario;

///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package BLL;
//
//import DAL.UsuarioDAO;
//logica de negocios lo que tendria que hacer el sistema XD
///**
// *
// * @author Nadia
// */
public class UsuarioBL {

    private Usuario u=null;
    
    public UsuarioBL(){}
    
    public Usuario login(String user, String pass) throws DAOException {
        UsuarioDAO dao = new UsuarioDAO(SQLConexion.getInstance().getConnection()); //envia la conexion 
        u = dao.validarUsuario(user, pass);
       // u=new Usuario("","","");
       
        return u;
    

    }    
    public String getPage(String usuario) {
        if (!"".equals(usuario)){
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }else{
            return "salio mal";
        }
        
    }
    
}
//constructores se llaman igual que la clase. pero no devuelven nada.... los metodos visibilidad+devolucion+nombre clase