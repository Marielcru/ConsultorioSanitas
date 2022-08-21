package Controlador;

import DAL.UsuarioDAO;
import Models.Usuario;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Controlador {
    
    UsuarioDAO dao = new UsuariosDAO();
    Usuario user = new Usuarios();
    int r=0;
   
 protected void processRequest(HttpServletRequest request,HttpServletResponse response)
             throws ServletException, IOException {
         response.setContentType("text/html;charset=UTF-8");
           
             String accion=request.getParameter("accion");
             if(accion.equals("ingresar"))
             {
             
             String usuario =request.getParameter("usserName");
             //String nombrecompleto =request.getParameter(dao.getUsuarios("name"));
             String pass = request.getParameter("password");
            
             user.setId(usuario);
             
             
             user.setContrasenia(pass);
             r=dao.validarUsuario(pass);
             if(r==1){
                  request.getSession().setAttribute("usuario", usuario);
                  //request.getSession().setAttribute("nom", nombrecompleto);
                   //request.getSession().setAttribute("usuario",nombre);
                  response.sendRedirect("administrador/index.jsp");
                 request.getRequestDispatcher("administrador/index.jsp").forward(request,response);
             }else{
                  response.sendRedirect("index.jsp");
                 request.getRequestDispatcher("index.jsp").forward(request,response);
             }
             
             }else{
                 response.sendRedirect("index.jsp");
                  request.getRequestDispatcher("index.jsp").forward(request, response);
             }
       
     }

    private static class Usuarios extends Usuario {

        public Usuarios() {
        }
    }
}