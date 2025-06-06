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




@WebServlet(name = "SvModificarPartido", urlPatterns = {"/modificarPartido"})
public class ModificarPartidoServlet extends HttpServlet {

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //PartidoDAO partidosDAO = new PartidoDAO();
        String destino;
        
     //LocalDate fechaActual = LocalDate.now(); // Fecha actual

    // Filtrar partidos futuros
    /*List<Partido> partidosFuturos = partidosDAO.getAll().stream()
        .filter(partido -> {
            try {
                LocalDate fechaPartido = LocalDate.parse(partido.getFecha());
                return fechaPartido.isAfter(fechaActual);
            } catch (Exception e) {
                return false;
            }
        })
        .collect(Collectors.toList());

    request.setAttribute("listaDePartidos", partidosFuturos);
    

       

            
        
        // esto muestra todos los partidos 
        //request.setAttribute("listaDePartidos", partidosDAO.getAll());*/
        destino = "WEB-INF/jsp/modificarPartido.jsp";
        
        
        
        request.getRequestDispatcher(destino).forward(request, response);
    }

   



}
