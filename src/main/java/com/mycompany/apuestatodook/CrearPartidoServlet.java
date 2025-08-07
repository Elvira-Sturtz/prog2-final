package com.mycompany.apuestatodook;



import com.mycompany.apuestatodook.model.Partido;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import com.mycompany.apuestatodook.model.PartidoDAO;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;




@WebServlet(name = "SvCrearPartido", urlPatterns = {"/crearPartido"})
public class CrearPartidoServlet extends HttpServlet {

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        String tipoUsuario = (String) request.getSession().getAttribute("tipoUsuario");
        if (tipoUsuario == null || !tipoUsuario.equals("admin")) {
            response.sendRedirect(request.getContextPath() + "/inicioSesion.jsp");
            return;
        }
        
        String destino = "WEB-INF/jsp/crearPartido.jsp";
        
        
        
        request.getRequestDispatcher(destino).forward(request, response);
    }

   



}
