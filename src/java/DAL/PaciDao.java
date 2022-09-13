/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import Models.Paciente;
import java.sql.Connection;

/**
 *
 * @author Marcos
 * tiene que ir en models al igual q los otros 2
 */
public abstract class PaciDao implements DAO<Paciente, Integer> { 
    
    final String ID = "iddni";
    
    final String GETALL = "SELECT iddni, nombre, apellido FROM persona";
    final String GETONE = "SELECT iddni, nombre, apellido FROM persona";
    
    
    //final int VALIDAR = "SELECT iddni FROM persona WHERE iddni = '?';

    Connection con;
    
    public PaciDao(Connection con) {
        this.con = con;
    }
}
    	


    

