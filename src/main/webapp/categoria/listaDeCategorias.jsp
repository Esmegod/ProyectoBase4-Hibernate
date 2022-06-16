<%-- 
    Document   : listaDeCategorias
    Created on : 4 abr. 2022, 08:13:30
    Author     : darkdestiny
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado Categorías</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"/>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" ></script>
    </head>
    <body>
        <div class="container">
            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <div class="container-fluid">
                    <a class="navbar-brand" href="#">Navbar</a>
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                            <li class="nav-item">
                                <a class="nav-link active" aria-current="page" href="#">Home</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="CategoriaServlet?accion=listaDeCategorias">Listado de Categorías</a>
                            </li>

                        </ul>
                    </div>
                </div>
            </nav>

            <div class="mb-3"></div>
            <div class="card">
                <div class="card-header">
                    <h1 class="card-title text-primary text-center">
                        Listado de Categorías
                    </h1>
                    <a href="CategoriaServlet?accion=nuevo" class="btn btn-outline-primary">Nuevo</a>
                    <a href="CategoriaServlet?accion=graficar" target="_blank" class="btn btn-outline-warning">Graficar</a>
                    <a href="CategoriaServlet?accion=verReporte" target="_blank" class="btn btn-outline-info">Reporte</a>
                </div>
                <div class="card-body">
                    <table class="table table-striped">
                        <tr>
                            <th>Clave Categor&iacute;a</th>
                            <th>Nombre Categor&iacute;a</th>
                            <th>Descripci&oacute;n Categoria</th>
                            <th>Eliminar</th>
                            <th>Actualizar</th>
                        </tr>
                        <c:forEach items="${listado}" var="dto">
                            <tr>
                                <td>
                                    <a href="CategoriaServlet?accion=ver&id=${dto.entidad.idCategoria}" class="btn btn-outline-success">
                                        <c:out value="${dto.entidad.idCategoria}"/>
                                    </a>
                                </td>
                                <td>
                                    <c:out value="${dto.entidad.nombreCategoria}"/>
                                </td>
                                <td>
                                    <c:out value="${dto.entidad.descripcionCategoria}"/>
                                </td>
                                <td>
                                    <a href="CategoriaServlet?accion=eliminar&id=${dto.entidad.idCategoria}" class="btn btn-outline-danger">
                                        Eliminar
                                    </a>
                                </td>
                                <td>
                                    <a href="CategoriaServlet?accion=actualizar&id=${dto.entidad.idCategoria}" class="btn btn-outline-info">
                                        Actualizar
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>

            </div>

        </div>
    </body>
</html>
