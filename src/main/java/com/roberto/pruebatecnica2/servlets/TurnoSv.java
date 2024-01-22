package com.roberto.pruebatecnica2.servlets;

import com.roberto.pruebatecnica2.logic.Ciudadano;
import com.roberto.pruebatecnica2.logic.Controladora;
import com.roberto.pruebatecnica2.logic.Turno;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "TurnoSv", urlPatterns = {"/TurnoSv"})
public class TurnoSv extends HttpServlet {

    private Controladora control = new Controladora();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    //realiza el listado simple o por fecha segun el aprametro que le llega
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

        List<Turno> turnos = control.listarTurnos();

        String fechaBusquedaParam = request.getParameter("fechaBusqueda");

        // Verificar si se proporciona una fecha en la solicitud
        if (fechaBusquedaParam != null && !fechaBusquedaParam.isEmpty()) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate fechaBusqueda = LocalDate.parse(fechaBusquedaParam, formatter);

            List<Turno> turnosEnFecha = turnos.stream()
                    .filter(turno -> turno.getFecha().isEqual(fechaBusqueda))
                    .sorted(Comparator.comparing(Turno::getFecha).reversed())
                    .collect(Collectors.toList());

            request.setAttribute("turnos", turnosEnFecha);
        } else {
            // Si no se proporciona una fecha, listar todos los turnos sin filtrar
            List<Turno> turnosOrdenados = turnos.stream()
                    .sorted(Comparator.comparing(Turno::getFecha).reversed())
                    .collect(Collectors.toList());

            request.setAttribute("turnos", turnosOrdenados);
        }

        request.getRequestDispatcher("index.jsp").forward(request, response);

    }

    // al hacer post realiza el alta de un turno
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int numero = Integer.parseInt(request.getParameter("numero"));
        String fecha = request.getParameter("fecha");
        String descripcion = request.getParameter("descripcion");
        int ciudadanoId = Integer.parseInt(request.getParameter("ciudadanoId"));
        Boolean estado = Boolean.valueOf(request.getParameter("estado"));

        Turno turno = new Turno();
        turno.setNumero(numero);
        turno.setFecha(LocalDate.parse(fecha));
        turno.setDescripcion(descripcion);
        turno.setEstado(estado);

        Ciudadano ciudadano = control.ciudadanoPorId(ciudadanoId);
        turno.setCiudadano(ciudadano);

        control.crearTruno(turno);

        response.sendRedirect("index.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
