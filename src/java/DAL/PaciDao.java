/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import Models.Paciente;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author Marcos
 * tiene que ir en models al igual q los otros 2
 */
public class PaciDao implements DAO<Paciente, Integer> { 
    
    final String ID = "iddni";
    
    final String GETALL = "SELECT iddni, nombre, apellido FROM persona";
    final String GETONE = "SELECT iddni, nombre, apellido FROM persona";
    
    
    //final int VALIDAR = "SELECT iddni FROM persona WHERE iddni = '?';

    Connection con;
    
    public PaciDao(Connection con) {
        this.con = con;
    }

    @Override
    public void insertar(Paciente t) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void modificar(Paciente t) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminar(Paciente t) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Paciente> obtenerTodos() throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Paciente obtener(Integer id) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
    	


    

