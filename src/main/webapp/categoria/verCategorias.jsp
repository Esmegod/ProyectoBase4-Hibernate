<%-- 
    Document   : verCategorias
    Created on : 7 abr. 2022, 07:57:54
    Author     : darkdestiny
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Datos de la Categoría</title>
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
            <div class="card text-primary">
                <div class="card-header">
                    <h1 class="card-title  text-center">
                        Datos de la Categoría
                    </h1>
                </div>
                <div class="card-body">
                    <ul class="list-group">
                        <li class="list-group-item">
                            <c:out value="${categoria.entidad.idCategoria}"/>
                        </li>
                        <li class="list-group-item">
                            <c:out value="${categoria.entidad.nombreCategoria}"/>
                        </li>
                        <li class="list-group-item">
                            <c:out value="${categoria.entidad.descripcionCategoria}"/>
                        </li>
                        
                    </ul>
                </div>
            </div>

        </div>
    </body>
</html>
