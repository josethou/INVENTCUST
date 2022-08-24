/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public class ProductoDAO {
    Conexion cn= new Conexion();
    Connection con;
    PreparedStatement pr;
    ResultSet rs;
    int r;
    
    public Producto Buscar(int id){
        Producto p=new Producto();
        String sql="SELECT * FROM producto WHERE IdProducto="+id;
        try {
            con=cn.Conexion();
            pr=con.prepareStatement(sql);
            rs=pr.executeQuery();
            while (rs.next()) {                
                p.setIdProducto(rs.getInt(1));
                p.setNombresP(rs.getString(2));
                p.setPrecio(rs.getDouble(3));
                p.setStock(rs.getInt(4));
                p.setEstadoP(rs.getString(5));
                
            }
        } catch (Exception e) {
        }
        return p;
    }
    
    public int ActualizarStock(int id,int stock){
        
        String sql="UPDATE producto SET Stock=? WHERE IdProducto=?";
        try {
            con=cn.Conexion();
            pr=con.prepareStatement(sql);
            pr.setInt(1, stock);
            pr.setInt(2, id);
            pr.executeUpdate();
            
        } catch (Exception e) {
        }
        return r;
    }
    //Operaciones CRUD
    public List Listar(){
        String sql="SELECT * FROM producto";
        List<Producto>lista=new ArrayList<>();
        try {
            con=cn.Conexion();
            pr=con.prepareStatement(sql);
            rs=pr.executeQuery();
            while (rs.next()) {                
                Producto pro=new Producto();
                pro.setIdProducto(rs.getInt(1));
                pro.setNombresP(rs.getString(2));
                pro.setEstadoP(rs.getString(3));
                pro.setStock(rs.getInt(4));
                pro.setPrecio(rs.getDouble(5));
                lista.add(pro);
                

            }
        } catch (Exception e) {
        }
        return lista;
    }
    public int Actualizar(Producto pro ){
        String sql="UPDATE producto SET Nombres=?,Precio=?,Stock=?,Estado=? WHERE IdProducto=?";
        try {
            con=cn.Conexion();
            pr=con.prepareStatement(sql);
            pr.setString(1,pro.getNombresP()  );
            pr.setDouble(2,pro.getPrecio() );
            pr.setInt(3,pro.getStock() );
            pr.setString(4,pro.getEstadoP() );
            pr.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }
    public Producto ListarId(int id){
       Producto proo=new Producto();
       String sql="SELECT * FROM producto WHERE IdProducto="+id;
        try {
            con=cn.Conexion();
            pr=con.prepareStatement(sql);
            rs=pr.executeQuery();
            while (rs.next()) {                
                proo.setNombresP(rs.getString(2));
                proo.setPrecio(rs.getDouble(3));
                proo.setStock(rs.getInt(4));
                proo.setEstadoP(rs.getString(5));
                
                
            }
        } catch (Exception e) {
        }
        return proo;
    }
    public int Agregar(Producto pro ){
        String sql="INSERT INTO producto(Nombres,Precio,Stock,Estado) VALUES(?,?,?,?) ";
        try {
            con=cn.Conexion();
            pr=con.prepareStatement(sql);
            pr.setString(1, pro.getNombresP());
            pr.setDouble(2, pro.getPrecio());
            pr.setInt(3, pro.getStock());
            pr.setString(4, pro.getEstadoP());
            pr.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }
    public void  Eliminar(int id ){
        String sql="DELETE FROM producto WHERE IdProducto="+id;
        try {
            con=cn.Conexion();
            pr=con.prepareStatement(sql);
            pr.executeUpdate();

            
        } catch (Exception e) {
        }
    }
}
