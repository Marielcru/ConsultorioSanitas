/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.AdmiDao;

/**
 *
 * @author Nadia
 */
public class AdmiBL {
    
    public boolean login(String user, String pass) {
        AdmiDao dao = new AdmiDao();
        dao.validarUsuario(user, pass);
        return true;
        
        
    }
    
}