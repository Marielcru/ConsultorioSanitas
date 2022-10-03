/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

///**
// *
// * @author Marcos
// */
//
import DAL.DAOException;
import DAL.PaciDao;
import DAL.SQLConexion;
import Models.Paciente;

public class GestorPacientes {
 
    public Paciente obtenerPacientePorDNI(int dni) throws DAOException{
        PaciDao dao= new PaciDao(SQLConexion.getInstance().getConnection());
       return dao.obtener(dni);
    }         
}