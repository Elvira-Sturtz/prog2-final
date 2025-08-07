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




@WebServlet(name = "SvModificarPartido", urlPatterns = {"/ModificarPartido"})
public class ModificarPartidoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int partidoId = Integer.parseInt(request.getParameter("id"));
        PartidoDAO PartidoDAO = new PartidoDAO();
        Partido partidoPorId = PartidoDAO.getPartidoPorId(partidoId);
        request.setAttribute("partidoPorId", partidoPorId);
        /*
        PartidoDAO PartidoDAO = new PartidoDAO();
        
        //Partido partido = 
        PartidoDAO.deletePartidoPorId(partidoId);      
        
       /* request.setAttribute("partido", partido);
        
        
        ApuestaDAO apuestaDAO = new ApuestaDAO();
            List<Apuesta> apuestas = apuestaDAO.getAllApuestasConResultado();
        /*
        Usuario usuario = (Usuario) request.getSession().getAttribute("userLogueado");
        
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        double dineroUsuario = usuarioDAO.getDineroPorIdUsuario(usuario.getIDusuario());

        usuario.setDinero(dineroUsuario);
        request.getSession().setAttribute("userLogueado", usuario);
        
        request.setAttribute("dineroUsuario", dineroUsuario);
        
        */
        request.getRequestDispatcher("WEB-INF/jsp/modificarPartido.jsp").forward(request, response);
    }
}