<%@page import="java.util.List"%>
<%@page import="com.roberto.pruebatecnica2.logic.Turno"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Turnero</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.0.8/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <style>
            body{
                background-color: rgb(240 248 255);
            }
            h1{
                text-align: center;
            }
        </style>
    </head>
    <body class="container mt-5">
        <h1 class="mb-4">Turnero</h1>

        <form action="TurnoSv" method="POST" class="container mt-5">
            <div class="row">
                <div class="col-md-6">
                    <div class="form-group">
                        <label for="numero">Número de Turno:</label>
                        <input type="number" class="form-control" id="numero" name="numero" required>
                    </div>

                    <div class="form-group">
                        <label for="fecha">Fecha:</label>
                        <input type="date" class="form-control" id="fecha" name="fecha" required>
                    </div>
                </div>

                <div class="col-md-6">
                    <div class="form-group">
                        <label for="descripcion">Descripción del Trámite:</label>
                        <textarea class="form-control" id="descripcion" name="descripcion" required></textarea>
                    </div>

                    <div class="form-group">
                        <label for="ciudadanoId">ID del Ciudadano (del 1 al 6):</label>
                        <input type="text" class="form-control" id="ciudadanoId" name="ciudadanoId" required>
                    </div>
                </div>
            </div>

            <div class="form-group">
                <input type="hidden" name="estado" value="false">
                <input type="submit" class="btn btn-primary" value="Agregar Turno">
            </div>
        </form>
        <br>
        <form action="TurnoSv" method="GET">

            <label for="fechaBusqueda">Buscar solo por fecha o listar (donde hay muchos ejemplos 17/01/2024):</label>

            <input type="date" id="fechaBusqueda" name="fechaBusqueda">

            <input type="submit" value="Buscar">
        </form>
        
        <br>
        
        <form action="TurnoSvEstado" method="GET">
            <label for="fechaBusqueda">Buscar por fecha y estado:</label>
            <input type="date" id="fechaBusqueda" name="fechaBusqueda" required>
            <label for="estado"> (marca la casilla para buscar los atendidos y desmarca para buscar los turnos en espera)</label>
            <input type="checkbox" name="estado" value="true" style="width: 1.25em; height: 1.25em;">
            <input type="submit" value="Buscar">

        </form>

        <% if (request.getAttribute("turnos") != null) {%>
        <table class="table table-bordered mt-4">
            <thead class="thead-dark">
                <tr>
                    <th>Id Turno</th>
                    <th>Dni</th>
                    <th>Nombre</th>
                    <th>Apellido</th>
                    <th>Fecha</th>                        
                    <th>Descripcion</th>
                    <th>Estado<th>
                </tr>
            </thead>  
            <tbody>
                <% for (Turno turno : (List<Turno>) request.getAttribute("turnos")) {%>
                <tr>
                    <td><%= turno.getId()%></td>
                    <td><%= turno.getCiudadano().getDni()%></td>
                    <td><%= turno.getCiudadano().getNombre()%></td>
                    <td><%= turno.getCiudadano().getApellido()%></td>
                    <td><%= turno.getFecha()%></td>                       
                    <td><%= turno.getDescripcion()%></td>
                    <td><input type="checkbox" disabled <%= turno.getEstado() ? "checked" : ""%>></td>
                </tr>
                <% }%>

            </tbody>
        </table>
        <% }%>
    </body>
</html>
