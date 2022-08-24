<%-- 
    Document   : Productos
    Created on : 19/07/2022, 10:56:48 a. m.
    Author     : USUARIO
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Productos</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" 
              integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <link href="css/estilo ver producto.css" rel="stylesheet" type="text/css"/>
        <link rel="icon" type="image/png" href="img/logo.png"/>
    </head>
    <body>
        <div class="col-8">
        <table class="table table-dark table-bordered border-light table-hover mt-2 mb-2">
                <thead>
                    <tr>
                        <th>IDPRODUCTO</th>
                        <th>NOMBRES</th>
                        <th>PRECIO</th>
                        <th>STOCK</th>
                        <th>ESTADO</th>
                        <th>ACCIONES</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="PRO" items="${Producto}">
                    <tr>
                        <td>${PRO.getIdProducto()}</td>
                        <td>${PRO.getNombresP()}</td>
                        <td>${PRO.getPrecio()}</td>
                        <td>${PRO.getStock()}</td>
                        <td>${PRO.getEstadoP()}</td>
                        <td>
                            <a href="" class="btn btn-warning lupe" >Editar</a>
                            <a href="" class="btn btn-danger lupe">Eliminar</a>
                        </td>
                    </tr>
                    </c:forEach>
                    
                </tbody>
            </table>
            </div>
<div class="card col-sm-4 yu">
            <div class="card-body">
                <form action="Controlador?menu=Producto" method="POST">
                    <div class="form-group">
                        <label>Nombre Producto</label>
                        <input type="text" value="${empleado.getDni()}" name="txtNombreP" class="form-control">
                    </div>
                    <div class="form-group">
                        <label>Precio</label>
                        <input type="text" value="${empleado.getNombres()}" name="txtPrecio" class="form-control">
                    </div>
                    <div class="form-group">
                        <label>Stock</label>
                        <input type="number"  value="${empleado.getTelefono()}" name="txtStock" class="form-control">
                    </div>
                    <div class="form-group">
                        <label>Estado</label>
                        <input type="number" value="${empleado.getEstado()}" name="txtEstado" class="form-control">
                    </div>
                    
                    <input type="submit" name="accion" value="Agregar" class="btn btn-info">
                    <input type="submit" name="accion" value="Actualizar" class="btn btn-success">
                </form>
                
            </div>
            
        </div>
    </body>
</html>
