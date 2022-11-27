/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.DAOException;
import DAL.SQLConexion;
import DAL.TurnoDao;
import Models.Turno;

/**
 *
 * @author Nadia
 */
public class TurnoBL {
    private Turno t=null;
    
    public Turno buscarTurnos(int id) throws DAOException {
        TurnoDao dao = new TurnoDao(SQLConexion.getInstance().getConnection()); //envia la conexion 
        t = dao.obtener(id);
       
        return t;
    }
    
}
