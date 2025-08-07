
package com.mycompany.apuestatodook;

import com.mycompany.apuestatodook.model.Apuesta;
import com.mycompany.apuestatodook.model.ApuestaDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import com.mycompany.apuestatodook.model.Partido;
import com.mycompany.apuestatodook.model.PartidoDAO;
import com.mycompany.apuestatodook.model.Usuario;
import com.mycompany.apuestatodook.model.UsuarioDAO;
import java.util.List;

@WebServlet(name = "SvEliminarPartido", urlPatterns = {"/EliminarPartido"})
public class EliminarPartidoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int partidoId = Integer.parseInt(request.getParameter("id"));
        
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
        request.getRequestDispatcher("WEB-INF/jsp/partidoEliminado.jsp").forward(request, response);
    }
}