<%-- 
    Document   : index
    Created on : 12/07/2022, 11:11:41 p. m.
    Author     : USUARIO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" 
              integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <link href="css/estiloindex.css" rel="stylesheet" type="text/css"/>
 <link rel="icon" type="image/png" href="img/logo.png"/>
        <title>INVENTCUST</title>
    </head>
    <body>
        
        <div class="container">
            <center>  
            <div class="card col-sm-4 loo">
                
                <div class="card-body text-center">
                    <form action="Validar" method="POST">
                        <div class="form-group tu">
                            <img src="img/logo.png" class="top" alt=""/>
                            <h5 class="text-center text-light">INVENTCUST</h5>
                        </div>
                        <br/>
                        <div class="form-group mt-2">
                            <label class=" text-center text-light font-bold-f2 ">Usuario:</label>
                            <input type="text" name="txtuser" class="form-control"  />
                        </div>
                        <div class="form-group">
                            <label class="text-center text-light">Contraseña:</label>
                            <input type="password" name="txtpass" class="form-control"  />
                        </div>
                        
                        <input type="submit" name="accion" value="Ingresar" class="btn btn-danger col-5 mt-2" />
                            
                            
                        
                    </form>
                </div>   

            </div>   
           </center>
        </div>   

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" 
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    </body>
</html>
