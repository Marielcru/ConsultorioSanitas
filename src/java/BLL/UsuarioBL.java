/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.UsuarioDAO;

/**
 *
 * @author Nadia
 */
public class UsuarioBL {
    
    public boolean login(String user, String pass) {
        UsuarioDAO dao = new UsuarioDAO();
        dao.validarUsuario(user, pass);
        return true;
        
        
    }
    
}
