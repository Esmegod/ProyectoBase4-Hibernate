<%-- 
    Document   : categoriaForm
    Created on : 7 abr. 2022, 08:18:51
    Author     : darkdestiny
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Categoría Form</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"/>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" ></script>
    </head>
    <body>
        <%
            String accion  = request.getParameter("accion");
        %>
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
                        Formulario para Datos de la Categoría
                    </h1>
                </div>
                <div class="card-body">
                    <form method="post" action="CategoriaServlet?accion=guardar">
                        <%
                            if(accion.equals("nuevo")){
                        %>
                            <div class="mb-3" hidden="true">
                                <label for="txtId" class="form-label">Clave Categor&iacute;a</label>
                                <input type="text" class="form-control" id="txtId" name="txtId" 
                                       value="${dto.entidad.idCategoria}"
                                       placeholder="Nombre de la Categoría"

                                       />
                            </div>
                        <%}else{%>
                        <div class="mb-3" >
                            <label for="txtId" class="form-label">Clave Categor&iacute;a</label>
                            <input type="text" class="form-control" id="txtId" name="txtId" 
                                   value="${dto.entidad.idCategoria}"
                                   placeholder="Nombre de la Categoría"
                                   readonly
                                   />
                        </div>
                        <%}%>
                        
                        <div class="mb-3">
                            <label for="txtNombre" class="form-label">Nombre Categor&iacute;a</label>
                            <input type="text" class="form-control" id="txtNombre" name="txtNombre" 
                                   value="${dto.entidad.nombreCategoria}"
                                   placeholder="Nombre de la Categoría"
                                   required
                                   />
                        </div>
                        
                        <div class="mb-3">
                            <label for="txtDescripcion" class="form-label"> Descripción de la Categoría</label>
                            <input type="text" name="txtDescripcion" id="txtDescripcion" 
                                   class="form-control"
                                   value="${dto.entidad.descripcionCategoria}"
                                   placeholder="Descripción de la Categoría"
                                   required/>
                        </div>
                        <div class="mb-3">
                          
                            <input type="submit" name="btnEnviar" id="btnEnviar" 
                                   class="btn-outline-primary"
                                   value="Registrar"
                                   />
                        </div>

                    </form>
                </div>
            </div>

        </div>
    </body>
</html>
