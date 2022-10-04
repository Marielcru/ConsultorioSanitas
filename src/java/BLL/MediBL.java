/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.DAOException;
import DAL.MediDao;
import DAL.SQLConexion;
import Models.Medico;

/**
 *
 * @author Marcos
 */
public class MediBL {
    public Medico obtenerPacientePorDNI(int DNI) throws DAOException{
        MediDao dao= new MediDao(SQLConexion.getInstance().getConnection());
       return dao.obtener(DNI);
    
}
}