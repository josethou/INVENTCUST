<%-- 
    Document   : Nueva Venta
    Created on : 19/07/2022, 10:59:08 a. m.
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
        <title>Nueva Venta</title>
        <link href="css/footer administrador.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="row d.flex"  >
            <div class="col-5" >
                <div class="card" >
                    <form action="Controlador?menu=Nueva_venta" method="POST">
                    <div class="card-body">
                        <div class="form-group" >
                            <label>Datos del Cliente</label>
                        </div>
                        <br/>
                        
                        <div class="form-group d-flex" >
                            <div class="col-sm-6 d-flex">
                                <input type="text" name="CodigoCliente" value="${cli.getDniC()}" class="form-control" placeholder="Codigo" >
                                <input type="submit" name="accion" value="BuscarCliente" class="btn btn-outline-info">
                            </div>
                            <div class="col-sm-6">
                               <input type="text" name="NombreClientes" value="${cli.getNombresC()}"  class="form-control" >
                            </div>
                        </div>
                            <br/>
                        <div class="form-group" >
                            <label>Datos Productos</label>
                        </div>
                            <br/>
                        <div class="form-group d-flex" >
                            <div class="col-sm-6 d-flex">
                                <input type="number" name="CodigoProducto" value="${producto.getIdProducto()}" class="form-control"  placeholder="Codigo" >
                                <button type="submit" name="accion" value="Buscar_Producto" class="btn btn-outline-info">Buscar</button>
                                
                            </div>
                            <div class="col-sm-6">
                               <input type="text" name="NombreProducto"  value="${producto.getNombresP()}" class="form-control" >
                            </div>
                        </div>
                        <div class="form-group d-flex" >
                            <div class="col-sm-6 d-flex">
                                <input type="text" name="Precio" value="${producto.getPrecio()}"    class="form-control" placeholder="Precio" >
                            </div>
                            <div class="col-sm-3     d-flex">
                                <input type="number" name="Cantidad" value="1"   class="form-control" placeholder="Cantidad" >
                            </div>
                            <div class="col-sm-3">
                               <input type="text" name="Stook" value="${producto.getStock()}" class="form-control" >
                            </div>
                        </div>
                        <div class="form-group mt-3">
                            <button type="submit" name="accion" value="Agregar" class="btn btn-outline-info" >Agregar Producto</button>                                                        
                        </div>
                    </div>
                  </form>   
                </div>
            </div>
            <div class="col-7 " >
                <div class="card">
                    <div class="card-body">
                        <div class="d-flex col-sm-6 float-end ml-auto">
                            <label>Numero de Serie</label>
                            <input type="text" name="NumeroSeries" value="NumeroSerie" class="form-control"/>
                        <br/>
                        </div>
                        
                        <table class="table table-dark table-bordered border-light table-hover mt-2 mb-2">
                <thead>
                    <tr>
                        <th>NUMEROPRO</th>
                        <th>CODIGO</th>
                        <th>DESCRIPCION</th>
                        <th>PRECIO</th>
                        <th>CANTIDAD</th>
                        <th>SUBTOTAL</th>
                        <th>ACCIONES</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="list" items="${lista}">
                    <tr>
                        <td>${list.getItem()}</td>
                        <td>${list.getIdProducto()}</td>
                        <td>${list.getDescriptionP()}</td>
                        <td>${list.getPrecio()}</td>
                        <td>${list.getCantidad()}</td>
                        <td>${list.getSubtotal()}</td>
                        <td>
                            <a href="" class="btn btn-warning lupe" >Editar</a>
                            <a href="" class="btn btn-danger lupe">Eliminar</a>
                        </td>
                    </tr>
                    </c:forEach>
                    
                </tbody>
            </table>

           </div>
                <div class="card-footer d-flex">
                        <div class="col-sm-6">
                            <a href="Controlador?menu=Nueva_venta&accion=GenerarVenta" onclick="print()" class="btn btn-success" >Generar Venta</a>
                            
                        </div>  
                    <div class="col-sm-3 ml-auto">
                        <input type="text" name="textTotal" value="S/.${TotalPagar}0" class="form-control "  />
                    </div>
                </div>     
                </div>
                            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" 
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    </body>
</html>
