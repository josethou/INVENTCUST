<%-- 
    Document   : Empleados
    Created on : 19/07/2022, 10:58:03 a. m.
    Author     : USUARIO
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" 
              integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <link href="css/estilo Registra V.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <div class="  d-flex">            
             <div class="card col-sm-4 yu">
            <div class="card-body">
                <form action="Controlador?menu=Empleados" method="POST">
                    <div class="form-group">
                        <label>Dni</label>
                        <input type="text" value="${empleado.getDni()}" name="txtDni" class="form-control">
                    </div>
                    <div class="form-group">
                        <label>Nombres</label>
                        <input type="text" value="${empleado.getNombres()}" name="txtNombres" class="form-control">
                    </div>
                    <div class="form-group">
                        <label>Telefono</label>
                        <input type="number"  value="${empleado.getTelefono()}" name="txtTelefono" class="form-control">
                    </div>
                    <div class="form-group">
                        <label>Estado</label>
                        <input type="number" value="${empleado.getEstado()}" name="txtEstado" class="form-control">
                    </div>
                    <div class="form-group">
                        <label>Usuario</label>
                        <input type="text" value="${empleado.getUsuario()}" name="txtUsuario" class="form-control">
                    </div>
                    <input type="submit" name="accion" value="Agregar" class="btn btn-info">
                    <input type="submit" name="accion" value="Actualizar" class="btn btn-success">
                </form>
                
            </div>
            
        </div>
            <div class="col-sm-8 co ">
            <table class="table table-dark table-bordered border-light table-hover">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>DNI</th>
                        <th>NOMBRES</th>
                        <th>TELEFONO</th>
                        <th>ESTADO</th>
                        <th>USUARIO</th>
                        <th>ACCIONES</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="em" items="${empleados}">
                    <tr>
                        <td>${em.getId()}</td>
                        <td>${em.getDni()}</td>
                        <td>${em.getNombres()}</td>
                        <td>${em.getTelefono()}</td>
                        <td>${em.getEstado()}</td>
                        <td>${em.getUsuario()}</td>
                        <td>
                            <a href="Controlador?menu=Empleados&accion=Editar&id=${em.getId()}" class="btn btn-warning" >Editar</a>
                            <a href="Controlador?menu=Empleados&accion=Eliminar&id=${em.getId()}" class="btn btn-danger">Eliminar</a>
                        </td>
                    </tr>
                    </c:forEach>
                    
                </tbody>
            </table>
        </div>
            
        </div>
        
       
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" 
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    </body>
</html>
