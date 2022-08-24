/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import Config.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author USUARIO
 */
public class VentaDAO {
    
    Connection con;
    Conexion cn= new Conexion();
    PreparedStatement pr;
    ResultSet rs;
    int r;
    
    public String GenerarSeriee(){
        
        String NumSerie="";
        String sql="select max(NumeroSerie) from ventas";
        try {
            con=cn.Conexion();
            pr=con.prepareStatement(sql);
            rs=pr.executeQuery();
            while (rs.next()) {                
                NumSerie=rs.getString(1);
                
            }
        } catch (Exception e) {
        }
        return NumSerie;
    }
    
    public String IdVentas(){
        
        String idventas="";
        String sql ="select max (IdVentas) from ventas ";
        try {
            con=cn.Conexion();
            pr=con.prepareStatement(sql);
            rs=pr.executeQuery();
            while (rs.next()) {
                idventas=rs.getString(1);
                
            }
        } catch (Exception e) {
        }
        return idventas;
    }
    
    public int GuardarVenta(Venta vee){
        String sql="INSERT INTO ventas (IdCliente,IdEmpleado,NumeroSerie,FechaVentas,Monto,Estado) "
                + "VALUES (?,?,?,?,?,?) ";
        try {
            con=cn.Conexion();
            pr=con.prepareStatement(sql);
            pr.setInt(1, vee.getIdCliente());
            pr.setInt(2, vee.getIdEmpleado());
            pr.setString(3, vee.getNumserie());
            pr.setString(4, vee.getFecha());
            pr.setDouble(5, vee.getPrecio());
            pr.setString(6, vee.getEstado());
            pr.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }
    public int GuardarDtalleVenta(Venta venta ){
        String sql="INSERT INTO detalle_ventas (IdVentas,IdProducto,Cantidad,PrecioVenta) VALUES (?,?,?,?) ";
        try {
            con=cn.Conexion();
            pr=con.prepareStatement(sql);
            pr.setInt(1, venta.getId());
            pr.setInt(2, venta.getIdProducto());
            pr.setInt(3, venta.getCantidad());
            pr.setDouble(4, venta.getPrecio());
            pr.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }
     public int Actualizar(Venta venta ){
        String sql="UPDATE ventas SET IdCliente=?,"
                + "IdEmpleado=?,NumeroSerie=?,FechaVentas=?,"
                + "Monto=?, Estado=? WHERE IdVentas=?";
        try {
            con=cn.Conexion();
            pr=con.prepareStatement(sql);
            pr.setInt(1,venta.getIdCliente()  );
            pr.setInt(2,venta.getIdEmpleado() );
            pr.setString(3,venta.getNumserie() );
            pr.setString(4,venta.getFecha() );
            pr.setDouble(5, venta.getMonto());
            pr.setString(6, venta.getEstado());
            pr.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }
     public void  Eliminar(int id ){
        String sql="DELETE FROM ventas WHERE IdVentas="+id;
        try {
            con=cn.Conexion();
            pr=con.prepareStatement(sql);
            pr.executeUpdate();

            
        } catch (Exception e) {
        }
    }
     public List Listar(){
        String sql="SELECT * FROM ventas";
        List<Venta>lista=new ArrayList<>();
        try {
            con=cn.Conexion();
            pr=con.prepareStatement(sql);
            rs=pr.executeQuery();
            while (rs.next()) {                
                Venta ve=new Venta();
                ve.setId(rs.getInt(1));
                ve.setIdCliente(rs.getInt(2));
                ve.setIdEmpleado(rs.getInt(3));
                ve.setNumserie(rs.getString(4));
                ve.setMonto(rs. getDouble(5));
                ve.setEstado(rs.getString(6));
                lista.add(ve);
                

            }
        } catch (Exception e) {
        }
        return lista;
    }

}
