<%-- 
    Document   : Principal
    Created on : 12/07/2022, 11:26:13 p. m.
    Author     : USUARIO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" 
              integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <title>Principal</title>
        <link href="css/administrador estilo.css" rel="stylesheet" type="text/css"/>
        <link rel="icon" type="image/png" href="img/logo.png"/>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg bg-info">
  <div class="container-fluid">
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          
        </li>
        <li class="nav-item">
            <a style="margin: 10px; border:none" class="btn btn-outline-light" href="Controlador?menu=Producto&accion=Listar" target="myFrame" >Productos</a>
        </li>
        <li class="nav-item dropdown">
          <a style="margin: 10px; border:none" class="btn btn-outline-light " href="Controlador?menu=Empleados&accion=Listar" target="myFrame">Empleados</a>
        </li>
        <li class="nav-item">
            <a style="margin: 10px; border:none" class="btn btn-outline-light" href="Controlador?menu=Clientes" target="myFrame">Clientes</a>
        </li>
        <li class="nav-item">
            <a style="margin: 10px; border:none" class="btn btn-outline-light" href="Controlador?menu=Nueva_venta&accion=BuscarCliente" target="myFrame">Nueva Venta</a>
        </li>
      </ul>
        <div class="dropdown">
  <button style="border: none" class="btn btn-outline-light dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">
    ${Usuario.getNombres()}
  </button>
  <ul class="dropdown-menu text-center" aria-labelledby="dropdownMenuButton1">
    <li><a class="dropdown-item" href="#"> 
        <img src="img/imagenadmin.jpg" alt="60" width="60"/>
    </a></li>
    <li><a class="dropdown-item" href="#">${Usuario.getUsuario()}</a></li>
    <li><a class="dropdown-item" href="#">User@gmail.com</a></li>
    <div class="dropdown-dividier"></div>
    <form action="Validar" method="POST">
        <li><button name="accion"  value="Salir"   class="dropdown-item" href="#">Salir</button></li>
    </form>
    

  </ul>
</div>
    </div>
  </div>
</nav>
    <div  class="m-4" style="height: 700px;">
        <iframe name="myFrame" style="height: 100%;width: 100%; border: 0px solid #000;">
            
        </iframe>
    </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" 
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    </body>
</html>
