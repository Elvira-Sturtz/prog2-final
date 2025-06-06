
package com.mycompany.apuestatodook;

import com.mycompany.apuestatodook.model.PartidoDAO;
import com.mycompany.apuestatodook.model.UsuarioDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;


@WebServlet(name = "NuevoPartido", urlPatterns = {"/NuevoPartido"})
public class PartidoNuevoServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String local = request.getParameter("local");
        String visitante = request.getParameter("visitante");
        String fecha = request.getParameter("fecha");
       
        if (local.equals("") || (visitante.equals("")) || fecha.equals("")) {
            request.setAttribute("hayError", true);
            request.setAttribute("mensajeError", "Se deben completar todos los campos.");
            request.getRequestDispatcher("/WEB-INF/jsp/crearPartido.jsp").forward(request, response);
        }
        
        else{
            System.out.println("el valor de la funcion es "+validarFecha(fecha, "yyyy/MM/dd")+" la fecha es "+fecha);
            if(!validarFecha(fecha, "yyyy/MM/dd")){
                
                request.setAttribute("hayError", true);
                request.setAttribute("mensajeError", "La fecha esta mal. Ingrese Año/Mes/Dia");
                request.getRequestDispatcher("/WEB-INF/jsp/crearPartido.jsp").forward(request, response);
            }
        }
        /*if(edadStr != ""){
          edad = Integer.parseInt(edadStr);  
        }
        
        String dni = request.getParameter("dni");

         if((nombre.equals("")) || ("" == usuario) || "" == password || "" == cpassword || "" == apellido || "" == dni) {
           request.setAttribute("hayError", true);
            request.setAttribute("mensajeError", "Se deben completar todos los campos.");
            request.getRequestDispatcher("/WEB-INF/jsp/crearUsuario.jsp").forward(request, response);
         }
        else if (edad < 18) {
            request.setAttribute("hayError", true);
            request.setAttribute("mensajeError", "La edad debe ser mayor o igual a 18 años.");
            request.getRequestDispatcher("/WEB-INF/jsp/crearUsuario.jsp").forward(request, response);
        } else if (!password.equals(cpassword)) {
            request.setAttribute("hayError", true);
            request.setAttribute("mensajeError", "Las contraseñas no coinciden.");
            request.getRequestDispatcher("/WEB-INF/jsp/crearUsuario.jsp").forward(request, response);
        } else {
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            int idUsuario = usuarioDAO.add(usuario, password, "user");
            PersonaDAO personaDAO = new PersonaDAO();
            personaDAO.agregarPersona(idUsuario, nombre, apellido, edad, dni);
            request.getRequestDispatcher("/WEB-INF/jsp/usuarioCreado.jsp").forward(request, response);
        }*/
        
        //PartidoDAO usuarioDAO = new PartidoDAO();
        /*int idPartido = partidoDAO.add(local, visitante, fecha);*/
        PartidoDAO partidoDAO = new PartidoDAO();
        partidoDAO.agregarPartido(local, visitante, fecha);
        request.getRequestDispatcher("/WEB-INF/jsp/partidoCreado.jsp").forward(request, response);
    }
    
    public static boolean validarFecha(String d, String dateFormat) {
        DateFormat df = new SimpleDateFormat(dateFormat);
        df.setLenient(false);
        boolean retorno = false;
        try {
          df.parse(d);
          retorno = true;
        } catch (ParseException e) {
          retorno = false;
        }
        return retorno;
      }
}
