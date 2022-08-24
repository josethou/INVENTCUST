/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;


import Config.GenerarSerie;
import Modelo.Cliente;
import Modelo.ClienteDAO;
import Modelo.Empleado;
import Modelo.EmpleadoDAO;
import Modelo.Producto;
import Modelo.ProductoDAO;
import Modelo.Venta;
import Modelo.VentaDAO;
import java.awt.font.NumericShaper;
import java.io.IOException;

import java.util.ArrayList;

import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author USUARIO
 */
public class Controlador extends HttpServlet {
    String NumeroSeri;
    VentaDAO VDAO = new VentaDAO();
    Cliente cli= new Cliente();
    ClienteDAO clidao=new ClienteDAO();
    Producto pro= new Producto();
    ProductoDAO prodao= new ProductoDAO();
    int ide;
    Empleado em= new Empleado();
    EmpleadoDAO empdo= new EmpleadoDAO();
    Venta vent= new Venta();
    List <Venta> lista= new ArrayList<>();
    int item;
    int Cod;
    int Idv;
    String Descripcion;
    double Precio;
    int Cant;
    double SubtTotal;
    double TotalPagar;
    int idp;
    
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       String menu=request.getParameter("menu");
       String accion=request.getParameter("accion");
        if (menu.equals("Principal")) {
            request.getRequestDispatcher("Principal.jsp").forward(request, response);    
        }
        if (menu.equals("Empleados")) {
            switch (accion) {
                case "Listar":
                    List lista=empdo.Listar();
                    request.setAttribute("empleados", lista);
                    break;
                case "Agregar":
                    String Dni =request.getParameter("txtDni");
                    String Nombres =request.getParameter("txtNombres");
                    String Telefono =request.getParameter("txtTelefono");
                    String Estado =request.getParameter("txtEstado");
                    String Usuario =request.getParameter("txtUsuario");
                    em.setDni(Dni);
                    em.setNombres(Nombres);
                    em.setTelefono(Telefono);
                    em.setEstado(Estado);
                    em.setUsuario(Usuario);
                    empdo.Agregar(em);
                    request.getRequestDispatcher("Controlador?menu=Empleados&accion=Listar").forward(request, response);
                    
                    break;
                case "Actualizar":
                    String Dni1 =request.getParameter("txtDni");
                    String Nombres1 =request.getParameter("txtNombres");
                    String Telefono1 =request.getParameter("txtTelefono");
                    String Estado1 =request.getParameter("txtEstado");
                    String Usuario1 =request.getParameter("txtUsuario");
                    em.setDni(Dni1);
                    em.setNombres(Nombres1);
                    em.setTelefono(Telefono1);
                    em.setEstado(Estado1);
                    em.setUsuario(Usuario1);
                    em.setId(ide);
                    empdo.Actualizar(em);
                    request.getRequestDispatcher("Controlador?menu=Empleados&accion=Listar").forward(request, response);

                    break;     
                case "Eliminar":
                    ide=Integer.parseInt(request.getParameter("id"));
                    empdo.Eliminar(ide);
                    request.getRequestDispatcher("Controlador?menu=Empleados&accion=Listar").forward(request, response);


                    break;    
                case "Editar":
                    ide=Integer.parseInt(request.getParameter("id"));
                    Empleado e=empdo.ListarId(ide);
                    request.setAttribute("empleado", e);
                    request.getRequestDispatcher("Controlador?menu=Empleados&accion=Listar").forward(request, response);
                    break;    
                default:
                    
                    throw new AssertionError();
            }
            request.getRequestDispatcher("Empleados.jsp").forward(request, response);    

        }
        if (menu.equals("Producto")) {
            switch (accion) {
                 case "Eliminar":
                    idp=Integer.parseInt(request.getParameter("id"));
                    prodao.Eliminar(idp);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);


                    break;    
                case "Editar":
                    idp=Integer.parseInt(request.getParameter("id"));
                    Producto PRO=prodao.ListarId(idp);
                    request.setAttribute("Producto", PRO);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    break;
                case "Listar":
                    List lista=prodao.Listar();
                    request.setAttribute("Producto", lista);
                    break;
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("Productos.jsp").forward(request, response);    

        }
        if (menu.equals("Clientes")) {
            request.getRequestDispatcher("Clientes.jsp").forward(request, response);    

        }
        if (menu.equals("Nueva_venta")){ 
            switch (accion) {
                case "BuscarCliente":
                    
                    String dni=request.getParameter("CodigoCliente");
                    cli.setDniC(dni);
                    cli=clidao.Buscar(dni);
                    request.setAttribute("cli", cli);
                    break;
                case "Buscar_Producto":
                    int id = Integer.parseInt(request.getParameter("CodigoProducto"));
                    pro=prodao.ListarId(id);
                    request.setAttribute("cli", cli);
                    request.setAttribute("producto",pro);
                    request.setAttribute("lista", lista);
                    request.setAttribute("TotalPagar", TotalPagar);
                    break;
                case "Agregar":
                    TotalPagar=0.0;
                    item=item+1;
                    Cod=pro.getIdProducto();
                    Descripcion=request.getParameter("NombreProducto");
                    Precio=Double.parseDouble(request.getParameter("Precio"));
                    Cant=Integer.parseInt(request.getParameter("Cantidad"));
                    SubtTotal=Precio*Cant;
                    vent=new Venta();
                    vent.setItem(item);
                    vent.setIdProducto(Cod);
                    vent.setDescriptionP(Descripcion);
                    vent.setPrecio(Precio);
                    vent.setCantidad(Cant);
                    vent.setSubtotal(SubtTotal);
                    lista.add(vent);
                    for (int i = 0; i < lista.size(); i++) {
                        TotalPagar= TotalPagar+lista.get(i).getSubtotal();
                    }
                    request.setAttribute("TotalPagar", TotalPagar);
                    request.setAttribute("lista", lista);
                     
                    break;    
                case "NumeroSerie":
                    NumeroSeri= VDAO.GenerarSeriee();
                    if (NumeroSeri==null) {
                        NumeroSeri="00000001";
                        request.setAttribute("nserie", NumeroSeri);
                    }else{
                        int incrementar = Integer.parseInt(NumeroSeri);
                        GenerarSerie gs=new GenerarSerie();
                        NumeroSeri=gs.NumeroSerie(incrementar);
                        request.setAttribute("nserie",NumeroSeri);    
                            
                        }
                        
                    break;
                case "GenerarVenta" :
                    //Actualizar Stock
                    for (int i = 0; i < lista.size(); i++) {
                        Producto pr = new Producto();
                        int cantidad=lista.get(i).getCantidad();
                        int idproducto=lista.get(i).getIdProducto();
                        ProductoDAO pordao = new ProductoDAO();
                        pr=pordao.Buscar(idproducto);
                        int stoc=pr.getStock()-cantidad;
                        pordao.ActualizarStock(idproducto, stoc);
                    }
                    
                    //Guardar venta
                    vent.setIdCliente(cli.getIdClientes());
                    vent.setIdEmpleado(2);
                    vent.setNumserie(NumeroSeri);
                    vent.setFecha("2022-05-25");
                    vent.setMonto(TotalPagar);
                    vent.setEstado("1");
                    VDAO.GuardarVenta(vent);
                    //Guardar Detalle ventas
                    int Dvent=Integer.parseInt(VDAO.IdVentas());
                    for (int i = 0; i <lista.size(); i++) {
                        vent=new Venta();
                        vent.setId(Dvent);
                        vent.setIdProducto(lista.get(i).getIdProducto());
                        vent.setCantidad(lista.get(i).getCantidad());
                        vent.setPrecio(lista.get(i).getPrecio());
                        VDAO.GuardarDtalleVenta(vent);
                    }
                    case "Eliminar":
                    Idv=Integer.parseInt(request.getParameter("id"));
                    VDAO.Eliminar(Idv);
                    request.getRequestDispatcher("Controlador?menu=Nueva_venta&accion=Listar").forward(request, response);


                    break;    
                case "Editar":
                    ide=Integer.parseInt(request.getParameter("id"));
                    Empleado e=empdo.ListarId(ide);
                    request.setAttribute("ventas", e);
                    request.getRequestDispatcher("Controlador?menu=Nueva_venta&accion=Listar").forward(request, response);
                    break;
                case "Listar":
                    List lista=VDAO.Listar();
                    request.setAttribute("ventas", lista);
                    break;    
                default:
                    
              TotalPagar=0.0;
              item= 0;
                 
               
                    
            }
            request.getRequestDispatcher("Nueva Venta.jsp").forward(request, response);    

        }
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
