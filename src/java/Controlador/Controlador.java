package Controlador;

public class Controlador {
    
protected void processRequest(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
  response.setContentType("text/html;charset=UTF-8");
  PrintWriter out = response.getWriter();
  String accion = request.getParameter("accion");
  if (accion.equals("ingresar")) {

    String usuario = request.getParameter("email");
    //String nombrecompleto =request.getParameter(dao.getUsuarios("name"));
    String pass = request.getParameter("password");

    user.setCorreo(usuario);


    user.setPassword(pass);
    r = dao.validarUsuario(user);
    if (r == 1) {
      HttpSession session = request.getSession();
      session.setAttribute("usuario", user);
      //HttpSession usua =request.getSession(true);
      //usua.setAttribute("usuario",user);
      //request.getSession().setAttribute("nom", nombrecompleto);
      //request.getSession().setAttribute("usuario",nombre);
      response.sendRedirect("administrador/index.jsp");
      //request.getRequestDispatcher("administrador/index.jsp").forward(request, response);
    } else {
      response.sendRedirect("index.jsp?accion=usuario&claveincorrecta");
      //out.println("<div class='text-danger text-center'>Usuario y/o Clave incorrecta!</div>");
      //request.getRequestDispatcher("index.jsp").forward(request, response);
    }

  } else {
    response.sendRedirect("index.jsp");
    //request.getRequestDispatcher("index.jsp").forward(request, response);
  }

}
