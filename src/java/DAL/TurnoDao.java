/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import Models.Turno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Nadia
 */
public class TurnoDao implements DAO<Turno, Integer> {
    final String ID = "Dni";
    final String ESPECIALIDAD = "Especialidad";
    final String MEDICO = "Medico";
    final String FECHA  = "Fecha";
    final String HORA  = "Hora";
    
    final String INSERT = "INSERT INTO turno(" + ID + "," + ESPECIALIDAD+ "," + MEDICO+ "," + FECHA+ "," + HORA+ ") VALUES(?,?,?,?,?)";
    final String UPDATE = "UPDATE turno SET DNI=?,Especialidad=?,Medico=?,Fecha=?,Hora=? WHERE DNI=?";
    final String DELETE = "DELETE FROM turno WHERE DNI=?";
    final String GETALL = "SELECT Dni, Especialidad,Medico,Fecha,Hora FROM turno";
    final String GETONE = "SELECT Dni, Especialidad,Medico,Fecha,Hora FROM turno WHERE Dni=?";
    
    Connection con;

    public TurnoDao(Connection con) {
        this.con = con;
    }

    @Override
    public void insertar(Turno t) throws DAOException {
        PreparedStatement stat = null;
       SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
         String fecha = sdf.format(new Date());
     try{
          stat =con.prepareStatement(INSERT);
         stat.setInt(1, t.getDni());
         stat.setString(2, t.getEspecialidad());
         stat.setString(3, t.getMedico());
         stat.setString(4, fecha);
         if(stat.executeUpdate()==0) {
            throw new DAOException("no se guardo el paciente");
     }
     }catch(SQLException ex){
         throw new DAOException ("Error en SQL", ex);
       }finally{
         if(stat !=null){
             try{
                 stat.close();
             } catch (SQLException ex){
                 throw new DAOException("Error en SQL", ex);
             
             }
         }
     }
    
    }

    @Override
    public void modificar(Turno t) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminar(Turno t) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Turno> obtenerTodos() throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Turno obtener(Integer id) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
