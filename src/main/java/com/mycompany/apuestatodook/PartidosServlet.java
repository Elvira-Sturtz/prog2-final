package com.mycompany.apuestatodook;



import com.mycompany.apuestatodook.model.Apuesta;
import com.mycompany.apuestatodook.model.ApuestaDAO;
import com.mycompany.apuestatodook.model.Partido;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import com.mycompany.apuestatodook.model.PartidoDAO;
import com.mycompany.apuestatodook.model.Usuario;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;




@WebServlet(name = "SvPartidos", urlPatterns = {"/Partidos"})
public class PartidosServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        PartidoDAO partidosDAO = new PartidoDAO();
        String destino;
        
     LocalDate fechaActual = LocalDate.now(); // Fecha actual

    // Filtrar partidos futuros
    List<Partido> partidosFuturos = partidosDAO.getAllOrder().stream()
        .filter(partido -> {
            try {
                LocalDate fechaPartido = LocalDate.parse(partido.getFecha());
                return fechaPartido.isAfter(fechaActual) || fechaPartido.isEqual(fechaActual);
            } catch (Exception e) {
                return false;
            }
        })
        .collect(Collectors.toList());

    request.setAttribute("listaDePartidos", partidosFuturos);
    

       // Obtener usuario de la sesión 

           
        Usuario usuario = (Usuario) request.getSession().getAttribute("userLogueado");

        if (usuario != null && usuario.getTipo().equalsIgnoreCase("admin"))
            {
            request.setAttribute("esAdmin", true);
            request.setAttribute("mensajeAdmin", "Modo Administrador");    
            
        } else if (usuario != null && usuario.getTipo().equalsIgnoreCase("user")) 
            {
            request.setAttribute("esAdmin", false);
            
        }
            
        // Fecha de hoy para usar en el JSP
    request.setAttribute("fechaHoy", fechaActual.toString()); 
    
        // esto muestra todos los partidos 
        //request.setAttribute("listaDePartidos", partidosDAO.getAll());
        destino = "WEB-INF/jsp/partidos.jsp";
        
        
        
        request.getRequestDispatcher(destino).forward(request, response);
    
    

    }

   



}
