
package com.roberto.pruebatecnica2.servlets;

import com.roberto.pruebatecnica2.logic.Controladora;
import com.roberto.pruebatecnica2.logic.Turno;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "TurnoSvEstado", urlPatterns = {"/TurnoSvEstado"})
public class TurnoSvEstado extends HttpServlet {
  
     private Controladora control = new Controladora();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");       
    }
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        List<Turno> turnos = control.listarTurnos();

        //se ajusta el formato por si fuese a dar fallo
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate fechaBusqueda = LocalDate.parse(request.getParameter("fechaBusqueda"), formatter);
        
        Boolean estadoBusqueda = Boolean.valueOf(request.getParameter("estado"));

        // filtrado por fecha y por estado
        List<Turno> turnosEnFecha = turnos.stream()
                .filter(turno -> turno.getFecha().isEqual(fechaBusqueda) && (estadoBusqueda == null || turno.getEstado().equals(estadoBusqueda)))
                .collect(Collectors.toList());

        request.setAttribute("turnos", turnosEnFecha);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
