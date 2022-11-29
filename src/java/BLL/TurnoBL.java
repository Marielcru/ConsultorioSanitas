/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.DAOException;
import DAL.SQLConexion;
import DAL.TurnoDao;
import Models.Especialidad;
import Models.Turno;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Nadia
 */
public class TurnoBL {
   
    
    public List<Turno> buscarTurnos(int id,String especialidad,String medico,String fecha,String hora) throws DAOException {
        TurnoDao dao = new TurnoDao(SQLConexion.getInstance().getConnection()); //envia la conexion 
        SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");
        Date fechaConvertida = null;
        List<Turno> turnos = dao.obtenerTodos();
         List<String> horariosTurnos = null;
         List<String> al = new ArrayList<>();
        al.add("9:00");
        al.add("9:30");
        al.add("10:00");
        al.add("10:30");
        al.add("11:00");
        al.add("11:30");
        al.add("13:00");
        al.add("13:30");
        al.add("14:00");
        al.add("14:30");
        al.add("15:00");
        al.add("15:30");
        /*
       // List<String> horarios = List.of("9:00","9:30","10:00","10:30","11:00" ,"11:30","13:00","13:30","14:00","14:30" ,"15:00","15:30");
        for(Turno turno : turnos){
            //if(fechaConvertida.equals(turno.getFecha()) AND getEspecialidad().equals(especialidad)){
              al.remove(indexof(turno.getHora()));
                    
                    
                }
                
               // horarios.add(hora)
            }
*/
       
       
        return turnos;
    }
    
    public Turno ingresarNuevoTurno(int dni,String especialidad,String medico,String fecha,String hora) throws DAOException {

        TurnoDao dao = new TurnoDao(SQLConexion.getInstance().getConnection()); 
        SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");
        Date fechaConvertida = null;

        try {
                   fechaConvertida =  dateFormat.parse(fecha);
        } catch(Exception e) {
            System.out.println("Error occurred"+ e.getMessage());
        }
       
        Turno turno=new Turno(dni,especialidad,medico,fechaConvertida,hora);
        dao.insertar(turno);
        
       
        return turno;
    

    } 
    
}
