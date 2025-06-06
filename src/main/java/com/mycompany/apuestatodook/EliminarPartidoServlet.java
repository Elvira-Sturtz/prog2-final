/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
/*
package com.mycompany.apuestatodook;

import com.mycompany.apuestatodook.model.Partido;
import com.mycompany.apuestatodook.model.PartidoDAO;
import com.mycompany.apuestatodook.model.Usuario;
import com.mycompany.apuestatodook.model.UsuarioDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author elvir
 
@WebServlet(name = "EliminarPartidoServlet", urlPatterns = {"/EliminarPartido"})
public class EliminarPartidoServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. 
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EliminarPartidoServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EliminarPartidoServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

*/
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